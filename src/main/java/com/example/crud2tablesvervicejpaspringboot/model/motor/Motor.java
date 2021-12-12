package com.example.crud2tablesvervicejpaspringboot.model.motor;

import com.example.crud2tablesvervicejpaspringboot.model.category.Category;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "motor")
@AllArgsConstructor
@NoArgsConstructor
public class Motor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String description;
@ManyToOne
    @JoinColumn(name = "category_id")
@EqualsAndHashCode.Exclude
@ToString.Exclude
    private Category category;
}
