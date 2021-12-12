package com.example.crud2tablesvervicejpaspringboot.service.motor;

import com.example.crud2tablesvervicejpaspringboot.model.category.Category;
import com.example.crud2tablesvervicejpaspringboot.model.motor.Motor;
import com.example.crud2tablesvervicejpaspringboot.repository.IMotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MotorService implements IMotorService{
    @Autowired
    private IMotorRepository motorRepository;
    @Override
    public Optional<Motor> findById(Long id) {
        return motorRepository.findById(id);
    }

    @Override
    public void save(Motor motor) {
motorRepository.save(motor);
    }

    @Override
    public void remove(Long id) {
motorRepository.deleteById(id);
    }

    @Override
    public Iterable<Motor> findAll() {
        return motorRepository.findAll();
    }

    @Override
    public Iterable<Motor> findAllByNameContaining(String name) {
        return motorRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Motor> findAllByCategory(Category category) {
        return motorRepository.findAllByCategory(category);
    }
}
