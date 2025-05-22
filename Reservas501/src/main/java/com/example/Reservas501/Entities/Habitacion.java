package com.example.Reservas501.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {

    private int habitacion_id;
    private int hotel_id;
    private int numero_habitacion;
    private String tipo;
    private double precio;
    private boolean disponible;

}
