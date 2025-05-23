package com.example.Reservas501.DTO;

import com.example.Reservas501.Entities.Habitacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOCrearHabitacion extends Habitacion{
    private String nombre;
    private String contrasena;
}
