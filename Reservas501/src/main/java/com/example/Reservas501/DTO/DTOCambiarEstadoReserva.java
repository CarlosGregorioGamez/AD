package com.example.Reservas501.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOCambiarEstadoReserva {
    private String nombre;
    private String contrasena;
    private int reserva_id;
    private String estado;
}
