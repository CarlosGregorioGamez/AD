package com.example.Reservas501.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTOUsuarioContrasena implements Serializable {
    private String nombre;
    private String contrasena;
}
