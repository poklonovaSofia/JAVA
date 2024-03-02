package org.example.projectt.app.models.toyota;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.projectt.app.models.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "toyota_car_engine")
public class EngineModel extends BaseEntity {

    private String type;
    private float engineCapacity;
}



