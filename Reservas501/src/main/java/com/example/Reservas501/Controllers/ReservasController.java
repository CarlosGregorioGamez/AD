package com.example.Reservas501.Controllers;

import com.example.Reservas501.DTO.DTOUsuarioContrasena;
import com.example.Reservas501.Services.HotelService;
import com.example.Reservas501.Services.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ReservasController {

    @Autowired
    private ReservasService service;
    public static final String URLvalidacion = "http://localhost:8502/usuarios/validar";

    private ResponseEntity<Boolean> validarEnMicroServicioUsuarios(String nombre, String contrasena) {
        RestTemplate restTemplate = new RestTemplate();
        DTOUsuarioContrasena usuario = new DTOUsuarioContrasena(nombre, contrasena);
        return restTemplate.postForEntity(URLvalidacion, usuario, Boolean.class);
    }


}
