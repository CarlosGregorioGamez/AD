package com.example.Reservas501.Services;

import com.example.Reservas501.DTO.DTOUsuarioContrasena;
import com.example.Reservas501.Entities.Habitacion;
import com.example.Reservas501.Repositories.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository repository;
    private DTOUsuarioContrasena dtoUsuarioContrasena;

    public String crearHabitacion(Habitacion habitacion) {
        try {
            Habitacion crearHabitacion = new Habitacion(
                    habitacion.getHabitacion_id(),
                    habitacion.getTipo(),
                    habitacion.getPrecio(),
                    habitacion.getHotel_id());
            repository.save(crearHabitacion);
            return "Habitación creada con éxito";
        } catch (Exception e) {
            return "Ha habido un problema con la creación de la habitación";
        }
    }
}
