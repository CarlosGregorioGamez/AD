package com.example.Reservas501.Repositories;

import com.example.Reservas501.Entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservasRepository extends JpaRepository<Reserva, Integer> {

    @Query("Select * from reservas where nombre = :nombre and contrasena = :contrasena")
    List<Reserva> findReservasByUsuarioNombreYContrasena(String nombre, String contrasena);

    @Query("Select * from reservas where estado = :estado")
    List<Reserva> findReservasByEstado(String estado);

}
