package com.example.Reservas501.Controllers;

import com.example.Reservas501.DTO.DTOActualizarHabitacion;
import com.example.Reservas501.DTO.DTOCrearHabitacion;
import com.example.Reservas501.DTO.DTOCrearHotel;
import com.example.Reservas501.DTO.DTOUsuarioContrasena;
import com.example.Reservas501.Entities.Habitacion;
import com.example.Reservas501.Entities.Hotel;
import com.example.Reservas501.Services.HabitacionService;
import com.example.Reservas501.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/reservas")
public class HabitacionController {

    @Autowired
    private HabitacionService service;
    public static final String URLvalidacion = "http://localhost:8502/usuarios/validar";

    private ResponseEntity<Boolean> validarEnMicroServicioUsuarios(String nombre, String contrasena) {
        RestTemplate restTemplate = new RestTemplate();
        DTOUsuarioContrasena usuario = new DTOUsuarioContrasena(nombre, contrasena);
        return restTemplate.postForEntity(URLvalidacion, usuario, Boolean.class);
    }


    @PostMapping("/habitacion")
    public ResponseEntity<String> crearHabitacion(@RequestBody DTOCrearHabitacion habitacion) {
        ResponseEntity<Boolean> validacion = validarEnMicroServicioUsuarios(habitacion.getNombre(), habitacion.getContrasena());
        if (validacion.getStatusCode() != HttpStatus.OK || Boolean.FALSE.equals(validacion.getBody())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fallo en la validación del usuario");
        }
        String response = service.crearHabitacion(new Habitacion(
                habitacion.getNumero_habitacion(),
                habitacion.getTipo(),
                habitacion.getPrecio().doubleValue(),
                habitacion.getHotel_id()
        ));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PatchMapping("/habitacion")
    public ResponseEntity<String> actualizarHabitacion(@RequestBody DTOActualizarHabitacion habitacion) {
        ResponseEntity<Boolean> validacion = validarEnMicroServicioUsuarios(habitacion.getNombre(), habitacion.getContrasena());
        if (validacion.getStatusCode() != HttpStatus.OK || Boolean.FALSE.equals(validacion.getBody())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fallo en la validación del usuario");
        }
        String response = service.actualizarHabitacion(new Habitacion(
                habitacion.getHabitacion_id(),
                habitacion.getHotel_id(),
                habitacion.getNumero_habitacion(),
                habitacion.getTipo(),
                habitacion.getPrecio(),
                habitacion.isDisponible()
        ));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @DeleteMapping("/habitacion/{id}")
    public ResponseEntity<String> borrarHabitacion(@PathVariable int id, @RequestBody DTOActualizarHabitacion habitacion) {
        ResponseEntity<Boolean> validacion = validarEnMicroServicioUsuarios(habitacion.getNombre(), habitacion.getContrasena());
        if (validacion.getStatusCode() != HttpStatus.OK || Boolean.FALSE.equals(validacion.getBody())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fallo en la validación del usuario");
        }
        String response = service.borrarHabitacion(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
