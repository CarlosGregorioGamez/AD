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
    private static final String URLvalidacion = "http://locahost:8502/usuarios/validar";

    private boolean validarEnMicroServicioUsuarios(DTOUsuarioContrasena usuarioContraseña){
        RestTemplate restTemplate = new RestTemplate();
        DTOUsuarioContrasena usuario = dtoUsuarioContrasena.builder()
                .nombre(usuarioContraseña.getNombre())
                .contrasena(usuarioContraseña.getContrasena())
                .build();
        ResponseEntity<Boolean> response = restTemplate.postForEntity(URLvalidacion, usuario, Boolean.class);
        return Boolean.TRUE.equals(response.getBody());
    }

    public String crearHabitacion(Habitacion habitacion){
        Habitacion crearHabitacion = new Habitacion(
                habitacion.getHabitacion_id(),
                habitacion.getTipo(),
                habitacion.getPrecio(),
                habitacion.getHotel_id());
        repository.save(crearHabitacion);
        return "Habitación creada con éxito";
    }
}
