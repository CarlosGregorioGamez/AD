package com.example.Reservas501.Services;

import com.example.Reservas501.DTO.DTOReservaSimple;
import com.example.Reservas501.DTO.DTOUsuarioContrasena;
import com.example.Reservas501.Entities.Hotel;
import com.example.Reservas501.Entities.Reserva;
import com.example.Reservas501.Repositories.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ReservasService {

    @Autowired
    private ReservasRepository repository;
    private DTOUsuarioContrasena dtoUsuarioContrasena;
    public static final String URLvalidacion = "http://localhost:8502/usuarios/validar";

    private ResponseEntity<Boolean> validarEnMicroServicioUsuarios(String nombre, String contrasena) {
        RestTemplate restTemplate = new RestTemplate();
        DTOUsuarioContrasena usuario = new DTOUsuarioContrasena(nombre, contrasena);
        return restTemplate.postForEntity(URLvalidacion, usuario, Boolean.class);
    }

    public String crearReserva(Reserva reserva) {
        try {
            Reserva crearReserva = new Reserva(
                    reserva.getHabitacion_id(),
                    reserva.getFecha_inicio(),
                    reserva.getFecha_fin()
            );
            repository.save(crearReserva);
            return "Hotel creado con éxito";
        } catch (Exception e) {
            return "Ha habido un problema con la creación del hotel";
        }
    }

    public String cambiarEstado(Reserva reserva) {
        try {
            Optional<Reserva> existenteOpt = repository.findById(reserva.getReserva_id());

            if (existenteOpt.isPresent()) {
                Reserva existente = existenteOpt.get();
                existente.setEstado(reserva.getEstado());
                repository.save(existente);
                return "Hotel actualizado con éxito";
            } else {
                return "Hotel no encontrado";
            }
        } catch (Exception e) {
            return "Ha habido un problema con la actualizacion del hotel";
        }
    }


    public List<Reserva> obtenerReservasPorUsuario(String nombre, String contrasena) {
        ResponseEntity<Boolean> validacion = validarEnMicroServicioUsuarios(nombre, contrasena);

        if (Boolean.TRUE.equals(validacion.getBody())) {
            return repository.findReservasByUsuarioNombreYContrasena(nombre, contrasena);
        } else {
            return List.of();
        }
    }

    public List<Reserva> obtenerReservasPorEstado(String estado) {
        try {
            return repository.findReservasByEstado(estado);
        } catch (Exception e) {
            return List.of();
        }
    }

    public boolean checkReserva(int idUsuario, int idHotel, int idReserva) {
        Optional<Reserva> reservaOpt = repository.findById(idReserva);

        if (reservaOpt.isEmpty()) {
            return false;
        }

        Reserva reserva = reservaOpt.get();

        // Verificamos si el usuario coincide
        if (!(reserva.getUsuario_id() == (idUsuario))) {
            return false;
        }

        // Verificamos si la habitación pertenece al hotel solicitado
        if (reserva.getHabitacion() == null || !(reserva.getHabitacion().getHotel_id() == idHotel)) {
            return false;
        }

        return reserva.getHabitacion().getHotel_id() == (idHotel);
    }

}
