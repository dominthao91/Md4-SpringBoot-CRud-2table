package com.example.crud2tablesvervicejpaspringboot.model.image;
import com.example.crud2tablesvervicejpaspringboot.model.motor.Motor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Motor motor;
}
