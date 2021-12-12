package com.example.crud2tablesvervicejpaspringboot.model.motor;

import com.example.crud2tablesvervicejpaspringboot.model.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotorRequest {
    private Long id;
    private String name;
    private double price;
    private String description;
    private Category category;
    private List<MultipartFile> multipartFiles;
}
