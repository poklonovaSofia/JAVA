package org.example.projectt.app.models.toyota;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.projectt.app.models.BaseEntity;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "toyota_car_complect")
public class ComplectModel extends BaseEntity {

    private String thumb;

    private String description;

    @ManyToMany
    private Collection<EngineModel> carEngine;

    @ManyToMany
    private Collection<ColorModel> carColor;

    private String linkToImage;
}