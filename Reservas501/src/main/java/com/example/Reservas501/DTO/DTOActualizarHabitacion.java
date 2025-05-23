package com.example.Reservas501.DTO;

import lombok.Data;

@Data
public class DTOActualizarHabitacion {
    private String nombre;
    private String contrasena;
    private int habitacion_id;
    private int numero_habitacion;
    private String tipo;
    private double precio;
    private int hotel_id;
    private boolean disponible;

    public DTOActualizarHabitacion(int habitacion_id, int numeroHabitacion, String tipo, double precio, int hotel_id, boolean disponible) {
        this.habitacion_id = habitacion_id;
        this.numero_habitacion = numeroHabitacion;
        this.tipo = tipo;
        this.precio = precio;
        this.hotel_id = hotel_id;
        this.disponible = disponible;
    }
}
