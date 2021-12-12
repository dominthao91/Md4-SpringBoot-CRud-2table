package com.example.crud2tablesvervicejpaspringboot.service.image;

import com.example.crud2tablesvervicejpaspringboot.model.image.Image;
import com.example.crud2tablesvervicejpaspringboot.model.motor.Motor;
import com.example.crud2tablesvervicejpaspringboot.repository.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService implements IImageService{
    @Autowired
    private IImageRepository iImageRepository;
    @Override
    public Iterable<Image> findAll() {
        return iImageRepository.findAll();
    }

    @Override
    public Optional<Image> findById(Long id) {
        return iImageRepository.findById(id);
    }

    @Override
    public void save(Image image) {
iImageRepository.save(image);
    }

    @Override
    public void remove(Long id) {
iImageRepository.deleteById(id);
    }

    @Override
    public List<Image> findAllByMotor(Motor motor) {
        return  iImageRepository.findAllByMotor(motor);
    }
}