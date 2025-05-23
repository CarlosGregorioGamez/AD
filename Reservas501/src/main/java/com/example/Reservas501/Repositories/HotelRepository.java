package com.example.Reservas501.Repositories;

import com.example.Reservas501.Entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    @Query("Select h.id from Hotel h where h.nombre = :nombre")
    String idEmpleadosPorNombre(@Param("nombre") String nombre);
}
