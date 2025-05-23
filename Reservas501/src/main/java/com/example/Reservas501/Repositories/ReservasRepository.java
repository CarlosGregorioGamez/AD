package com.example.Reservas501.Repositories;

import com.example.Reservas501.Entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservasRepository extends JpaRepository<Reserva, Integer> {
    List<Reserva> findByUsuarioId(int usuarioId);

    List<Reserva> findByEstado(String estado);

    boolean existsByIdAndUsuarioIdAndHabitacionHotelId(int id, int usuarioId, int hotelId);
}
