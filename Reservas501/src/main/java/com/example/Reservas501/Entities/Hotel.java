package com.example.Reservas501.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotel_id;
    private String nombre;
    private String direccion;

    public Hotel(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
}
