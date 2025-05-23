package com.example.Reservas501.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DTOReservaSimple {
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private int habitacion_id;
}
