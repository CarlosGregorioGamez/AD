package com.example.Reservas501.Services;

import com.example.Reservas501.DTO.DTOReservaSimple;
import com.example.Reservas501.DTO.DTOUsuarioContrasena;
import com.example.Reservas501.Entities.Hotel;
import com.example.Reservas501.Entities.Reserva;
import com.example.Reservas501.Repositories.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservasService {

    @Autowired
    private ReservasRepository repository;
    private DTOUsuarioContrasena dtoUsuarioContrasena;

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




}
