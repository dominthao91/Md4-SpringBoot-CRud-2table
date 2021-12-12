package com.example.crud2tablesvervicejpaspringboot.service.image;

import com.example.crud2tablesvervicejpaspringboot.model.image.Image;
import com.example.crud2tablesvervicejpaspringboot.model.motor.Motor;
import com.example.crud2tablesvervicejpaspringboot.service.IGeneralService;

import java.util.List;

public interface IImageService extends IGeneralService<Image> {
    List<Image>findAllByMotor(Motor motor);
}
