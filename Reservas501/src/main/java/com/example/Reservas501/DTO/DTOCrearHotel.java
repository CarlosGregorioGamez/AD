package com.example.Reservas501.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DTOCrearHotel {
    private String nombre;
    private String contrasena;

    private String nombre_hotel;

    private String direccion;


}
