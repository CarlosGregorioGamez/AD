package com.example.Usuarios501.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuario_id;
    private String nombre;
    private String correo_electronico;
    private String direccion;
    private String contrasena;


    public Usuario() {}

    // Constructor sin ID (para crear)
    public Usuario(String nombre, String correo_electronico, String direccion, String contrasena) {
        this.nombre = nombre;
        this.correo_electronico = correo_electronico;
        this.direccion = direccion;
        this.contrasena = contrasena;
    }

    // Constructor con ID (para actualizar)
    public Usuario(int usuario_id, String nombre, String correo_electronico, String direccion, String contrasena) {
        this.usuario_id = usuario_id;
        this.nombre = nombre;
        this.correo_electronico = correo_electronico;
        this.direccion = direccion;
        this.contrasena = contrasena;
    }


    public String getContrasena() {
        return contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public String getNombre() {
        return nombre;
    }

    public int getUsuario_id() {
        return usuario_id;
    }
}
