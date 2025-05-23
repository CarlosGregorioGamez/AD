package com.example.Reservas501.Controllers;

import com.example.Reservas501.DTO.DTOActualizarHabitacion;
import com.example.Reservas501.DTO.DTOActualizarHotel;
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
public class HotelController {

    @Autowired
    private HotelService hotelService;
    public static final String URLvalidacion = "http://localhost:8502/usuarios/validar";

    private ResponseEntity<Boolean> validarEnMicroServicioUsuarios(String nombre, String contrasena) {
        RestTemplate restTemplate = new RestTemplate();
        DTOUsuarioContrasena usuario = new DTOUsuarioContrasena(nombre, contrasena);
        return restTemplate.postForEntity(URLvalidacion, usuario, Boolean.class);
    }

    @PostMapping("/hotel")
    public ResponseEntity<String> crearHotel(@RequestBody DTOCrearHotel hotel) {
        ResponseEntity<Boolean> validacion = validarEnMicroServicioUsuarios(hotel.getNombre(), hotel.getContrasena());
        if (validacion.getStatusCode() != HttpStatus.OK || Boolean.FALSE.equals(validacion.getBody())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fallo en la validación del usuario");
        }
        String response = hotelService.crearHotel(new Hotel(
                hotel.getNombre_hotel(),
                hotel.getDireccion()
        ));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PatchMapping("/hotel")
    public ResponseEntity<String> actualizarHabitacion(@RequestBody DTOActualizarHotel hotel) {
        ResponseEntity<Boolean> validacion = validarEnMicroServicioUsuarios(hotel.getNombre(), hotel.getContrasena());
        if (validacion.getStatusCode() != HttpStatus.OK || Boolean.FALSE.equals(validacion.getBody())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fallo en la validación del usuario");
        }
        String response = hotelService.actualizarHotel(new Hotel(
                hotel.getHotel_id(),
                hotel.getNombre_hotel(),
                hotel.getDireccion()
        ));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @DeleteMapping("/hotel/{id}")
    public ResponseEntity<String> eliminarHotel(@PathVariable int id, @RequestBody DTOActualizarHabitacion habitacion) {
        ResponseEntity<Boolean> validacion = validarEnMicroServicioUsuarios(habitacion.getNombre(), habitacion.getContrasena());
        if (validacion.getStatusCode() != HttpStatus.OK || Boolean.FALSE.equals(validacion.getBody())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fallo en la validación del usuario");
        }
        String response = hotelService.borrarHotel(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/hotel/id{id}")
    public ResponseEntity<String> ObtenerIdPorNombre(@PathVariable int id, @RequestBody DTOActualizarHabitacion habitacion) {
        ResponseEntity<Boolean> validacion = validarEnMicroServicioUsuarios(habitacion.getNombre(), habitacion.getContrasena());
        if (validacion.getStatusCode() != HttpStatus.OK || Boolean.FALSE.equals(validacion.getBody())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fallo en la validación del usuario");
        }
        String response = hotelService.borrarHotel(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PostMapping("/hotel/id/{id}")
    public ResponseEntity<String> ObtenerNombrePorId(@PathVariable int id,
                                                     @RequestBody DTOActualizarHabitacion habitacion) {
        ResponseEntity<Boolean> validacion = validarEnMicroServicioUsuarios(habitacion.getNombre(), habitacion.getContrasena());
        if (validacion.getStatusCode() != HttpStatus.OK || Boolean.FALSE.equals(validacion.getBody())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fallo en la validación del usuario");
        }
        String response = hotelService.obtenerNombreAPartirDeId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



}