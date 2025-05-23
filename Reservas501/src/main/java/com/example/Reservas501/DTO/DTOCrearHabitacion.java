package com.example.Reservas501.DTO;

import com.example.Reservas501.Entities.Habitacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

@Data
public class DTOCrearHabitacion {
    private String nombre;
    private String contrasena;

    @JsonProperty("numero_habitacion")
    private int numero_habitacion;

    private String tipo;
    private BigDecimal precio;

    @JsonProperty("hotel_id")
    private int hotel_id;
}
