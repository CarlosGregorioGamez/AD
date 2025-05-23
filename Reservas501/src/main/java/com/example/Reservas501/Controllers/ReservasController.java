package com.example.Reservas501.Controllers;

import com.example.Reservas501.DTO.*;
import com.example.Reservas501.Entities.Reserva;
import com.example.Reservas501.Services.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    @PostMapping("")
    public ResponseEntity<String> crearHotel(@RequestBody DTOCrearReserva reserva) {
        ResponseEntity<Boolean> validacion = validarEnMicroServicioUsuarios(reserva.getNombre(), reserva.getContrasena());
        if (validacion.getStatusCode() != HttpStatus.OK || Boolean.FALSE.equals(validacion.getBody())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fallo en la validación del usuario");
        }
        String response = service.crearReserva(new Reserva(
                reserva.getHabitacion_id(),
                reserva.getFecha_inicio(),
                reserva.getFecha_fin()
        ));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("")
    public ResponseEntity<String> cambiarEstado(@RequestBody DTOCambiarEstadoReserva reserva) {
        ResponseEntity<Boolean> validacion = validarEnMicroServicioUsuarios(reserva.getNombre(), reserva.getContrasena());
        if (validacion.getStatusCode() != HttpStatus.OK || Boolean.FALSE.equals(validacion.getBody())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fallo en la validación del usuario");
        }
        String response = service.cambiarEstado(new Reserva(
                reserva.getReserva_id(),
                reserva.getEstado()
        ));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping("")
    public ResponseEntity<List<Reserva>> listarReservasUsuario(
            @RequestParam String nombre,
            @RequestParam String contrasena) {

        List<Reserva> reservas = service.obtenerReservasPorUsuario(nombre, contrasena);
        return ResponseEntity.ok(reservas);
    }

    public ResponseEntity<List<Reserva>> listarReservasSegunEstado(
            @PathVariable String estado) {

        List<Reserva> reservas = service.obtenerReservasPorEstado(estado);
        return ResponseEntity.ok(reservas);
    }

    public ResponseEntity<Boolean> checkReserva(
            @PathVariable int idUsuario,
            @PathVariable int idHotel,
            @PathVariable int idReserva) {

        boolean resultado = service.checkReserva(idUsuario, idHotel, idReserva);
        return ResponseEntity.ok(resultado);
    }
}
