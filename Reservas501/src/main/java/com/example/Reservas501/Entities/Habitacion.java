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


    public Habitacion(int numero_habitacion, String tipo, double precio, int hotelId) {
        this.numero_habitacion = numero_habitacion;
        this.tipo = tipo;
        this.precio = precio;
        this.hotel_id = hotelId;
    }



}
