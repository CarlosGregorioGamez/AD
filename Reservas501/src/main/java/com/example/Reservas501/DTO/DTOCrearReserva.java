package com.example.Reservas501.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DTOCrearReserva {
    private String nombre;
    private String contrasena;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private int habitacion_id;
}
