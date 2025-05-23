package com.example.Reservas501.Repositories;

import com.example.Reservas501.Entities.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {


}
