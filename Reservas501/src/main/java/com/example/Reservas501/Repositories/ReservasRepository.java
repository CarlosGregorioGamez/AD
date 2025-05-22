package com.example.Reservas501.Repositories;

import com.example.Reservas501.Entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservasRepository extends JpaRepository<Reserva, Integer> {
}
