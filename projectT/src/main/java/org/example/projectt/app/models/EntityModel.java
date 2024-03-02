package org.example.projectt.app.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "entities")
public class EntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private UUID id;
    private Long id;

    private String name;
    private int age;

}
