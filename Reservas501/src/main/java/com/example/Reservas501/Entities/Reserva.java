package com.example.Reservas501.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reserva_id;
    private int usuario_id;
    private int habitacion_id;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String estado;

    public Reserva(int habitacion_id, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.habitacion_id = habitacion_id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }
}
