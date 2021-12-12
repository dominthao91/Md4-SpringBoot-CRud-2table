package com.example.crud2tablesvervicejpaspringboot.repository;

import com.example.crud2tablesvervicejpaspringboot.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
