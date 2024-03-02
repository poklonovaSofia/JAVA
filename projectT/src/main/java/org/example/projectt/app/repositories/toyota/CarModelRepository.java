package org.example.projectt.app.repositories.toyota;


import org.example.projectt.app.models.toyota.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel, Long>
{
}
