package com.example.Reservas501.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "habitacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int habitacion_id;
    private int hotel_id;
    private int numero_habitacion;
    private String tipo;
    @Column(columnDefinition = "DECIMAL(10,2)")
    private double precio;
    private boolean disponible;


    public Habitacion(int habitacionId, String tipo, double precio, int hotelId) {
        this.habitacion_id = habitacionId;
        this.tipo = tipo;
        this.precio = precio;
        this.hotel_id = hotelId;
    }

    public int getHabitacion_id() {
        return habitacion_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public int getNumero_habitacion() {
        return numero_habitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
