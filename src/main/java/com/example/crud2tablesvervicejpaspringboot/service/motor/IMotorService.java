package com.example.crud2tablesvervicejpaspringboot.service.motor;

import com.example.crud2tablesvervicejpaspringboot.model.category.Category;
import com.example.crud2tablesvervicejpaspringboot.model.motor.Motor;
import com.example.crud2tablesvervicejpaspringboot.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMotorService extends IGeneralService<Motor> {
    Iterable<Motor> findAll();

    Iterable<Motor> findAllByNameContaining(String name);

    Iterable<Motor> findAllByCategory(Category category);
}
