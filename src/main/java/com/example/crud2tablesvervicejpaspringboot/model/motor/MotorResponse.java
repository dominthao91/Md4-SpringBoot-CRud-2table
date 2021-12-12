package com.example.crud2tablesvervicejpaspringboot.model.motor;

import com.example.crud2tablesvervicejpaspringboot.model.category.Category;
import com.example.crud2tablesvervicejpaspringboot.model.image.Image;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class MotorResponse {
    private Long id;
    private String name;
    private double price;
    private String description;
    private Category category;
    private List<Image> images;
}
