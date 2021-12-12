package com.example.crud2tablesvervicejpaspringboot.repository;

import com.example.crud2tablesvervicejpaspringboot.model.category.Category;
import com.example.crud2tablesvervicejpaspringboot.model.motor.Motor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMotorRepository extends JpaRepository<Motor,Long> {
    Iterable<Motor> findAllByNameContaining(String name);

    Iterable<Motor> findAllByCategory(Category category);
}
