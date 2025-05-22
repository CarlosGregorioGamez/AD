package com.example.Reservas501.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int habitacion_id;
    private int hotel_id;
    private int numero_habitacion;
    private String tipo;
    private double precio;
    private boolean disponible;


    public Habitacion(int habitacionId, String tipo, double precio, int hotelId) {
        this.habitacion_id = habitacionId;
        this.tipo = tipo;
        this.precio = precio;
        this.hotel_id = hotelId;
    }
}
