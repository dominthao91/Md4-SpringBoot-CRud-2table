package com.example.crud2tablesvervicejpaspringboot.repository;

import com.example.crud2tablesvervicejpaspringboot.model.image.Image;
import com.example.crud2tablesvervicejpaspringboot.model.motor.Motor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImageRepository extends JpaRepository<Image,Long> {
    List<Image> findAllByMotor(Motor motor);
}
