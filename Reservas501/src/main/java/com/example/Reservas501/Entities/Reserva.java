package com.example.Reservas501.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    private int reserva_id;
    private int usuario_id;
    private int habitacion_id;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String estado;

}
