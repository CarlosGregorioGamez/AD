package com.example.Reservas501.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @ManyToOne
    @JoinColumn(name = "habitacion_id")
    Habitacion habitacion;
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

    public Reserva(int reserva_id, String estado) {
        this.reserva_id = reserva_id;
        this.estado = estado;
    }
}
