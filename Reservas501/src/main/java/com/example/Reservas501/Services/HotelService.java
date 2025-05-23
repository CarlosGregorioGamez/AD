package com.example.Reservas501.Services;

import com.example.Reservas501.DTO.DTOUsuarioContrasena;
import com.example.Reservas501.Entities.Habitacion;
import com.example.Reservas501.Entities.Hotel;
import com.example.Reservas501.Repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository repository;
    private DTOUsuarioContrasena dtoUsuarioContrasena;

    public String crearHotel(Hotel hotel) {
        try {
            Hotel crearHotel = new Hotel(
                    hotel.getNombre(),
                    hotel.getDireccion());
            repository.save(crearHotel);
            return "Habitación creada con éxito";
        } catch (Exception e) {
            return "Ha habido un problema con la creación de la habitación";
        }
    }

    public String actualizarHabitacion(Habitacion habitacion) {
        try {
            Optional<Habitacion> existenteOpt = habitacionRepository.findById(habitacion.getHabitacion_id());

            if (existenteOpt.isPresent()) {
                Habitacion existente = existenteOpt.get();
                existente.setNumero_habitacion(habitacion.getNumero_habitacion());
                existente.setTipo(habitacion.getTipo());
                existente.setPrecio(habitacion.getPrecio());
                existente.setHotel_id(habitacion.getHotel_id());
                existente.setDisponible(habitacion.isDisponible());

                habitacionRepository.save(existente);
                return "Habitación actualizada con éxito";
            } else {
                return "Habitación no encontrada";
            }
        } catch (Exception e) {
            return "Ha habido un problema con la creación de la habitación";
        }
    }

    public String borrarHabitacion(int id) {
        try {
            habitacionRepository.deleteById(id);
            return "Habitación eliminada con éxito";
        } catch (Exception e) {
            return "Ha habido un problema con la creación de la habitación";
        }
    }
}
