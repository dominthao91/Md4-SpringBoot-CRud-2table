package com.example.crud2tablesvervicejpaspringboot.controller.category;

import com.example.crud2tablesvervicejpaspringboot.model.category.Category;
import com.example.crud2tablesvervicejpaspringboot.model.image.Image;
import com.example.crud2tablesvervicejpaspringboot.model.motor.Motor;
import com.example.crud2tablesvervicejpaspringboot.model.motor.MotorRequest;
import com.example.crud2tablesvervicejpaspringboot.service.category.ICategoryService;
import com.example.crud2tablesvervicejpaspringboot.service.image.IImageService;
import com.example.crud2tablesvervicejpaspringboot.service.motor.IMotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/motors")
public class MotorController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IMotorService motorService;
    @Autowired
    private IImageService iImageService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Motor>>showAllMotor(@RequestParam(name = "m",required = false) String m,
                                                       @RequestParam(name = "category",required = false)Category category,
                                                       @RequestParam(defaultValue = "0") int page){
        final int SIZE= 5;
        Iterable<Motor> motors;
        if (m!=null){
            motors = motorService.findAllByNameContaining(m);
        }else if (category!=null){
            motors =motorService.findAllByCategory(category);
        }else {
            motors = motorService.findAll();
        }
        return new ResponseEntity<>(motors, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?>createMotor(MotorRequest motorRequest)throws Exception{
        List<MultipartFile> multipartFiles =motorRequest.getMultipartFiles();
        Motor motor = new Motor();
        motor.setName(motorRequest.getName());
        motor.setDescription(motorRequest.getDescription());
        motor.setPrice(motorRequest.getPrice());
        motor.setCategory(motorRequest.getCategory());
        motorService.save(motor);
        for (MultipartFile multipartFile : multipartFiles) {
            String fileName = multipartFile.getOriginalFilename();
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + motor.getId()  + fileName));
            Image image = new Image();
            image.setName(fileName);
            image.setMotor(motor);
            iImageService.save(image);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeMotor(@PathVariable Long id) {
        motorService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Motor> updateMotor(@PathVariable Long id,MotorRequest motorRequest) throws IOException {
        Motor motor = motorService.findById(id).get();
        if (motor.getId() == null) {
            motor.setId(id);
        }
        motor.setName(motorRequest.getName());
        motor.setPrice(motorRequest.getPrice());
        motor.setDescription(motorRequest.getDescription());
        motor.setCategory(motorRequest.getCategory());
        List<MultipartFile> multipartFiles = motorRequest.getMultipartFiles();
        for (MultipartFile multipartFile : multipartFiles) {
            String fileName = multipartFile.getOriginalFilename();
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + motor.getId()  + fileName));
            Image image = new Image();
            image.setName(fileName);
            image.setMotor(motor);
            iImageService.save(image);
        }
        motorService.save(motor);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}