package com.example.Reservas501.Services;

import com.example.Reservas501.DTO.DTOUsuarioContrasena;
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
            return "Hotel creado con éxito";
        } catch (Exception e) {
            return "Ha habido un problema con la creación del hotel";
        }
    }

    public String actualizarHotel(Hotel hotel) {
        try {
            Optional<Hotel> existenteOpt = repository.findById(hotel.getHotel_id());

            if (existenteOpt.isPresent()) {
                Hotel existente = existenteOpt.get();
                existente.setNombre(hotel.getNombre());
                existente.setDireccion(hotel.getDireccion());
                repository.save(existente);
                return "Hotel actualizado con éxito";
            } else {
                return "Hotel no encontrado";
            }
        } catch (Exception e) {
            return "Ha habido un problema con la actualizacion del hotel";
        }
    }

    public String borrarHotel(int id) {
        try {
            repository.deleteById(id);
            return "Hotel eliminado con éxito";
        } catch (Exception e) {
            return "Ha habido un problema con la eliminacion del hotel";
        }
    }

    public String obtenerIdAPartirDeNombre(String nombre){
        return repository.idEmpleadosPorNombre(nombre);
    }

    public String obtenerNombreAPartirDeId(int id){
        String nombre = repository.findById(id).get().getNombre();
        return nombre;
    }
}
