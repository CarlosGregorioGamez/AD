package com.example.Usuarios501.Services;

import com.example.Usuarios501.Entities.Usuario;
import com.example.Usuarios501.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepo;

    public String crearUsuario(String nombre, String correo, String direccion, String contrasena) {
        try {
            Usuario usuario = new Usuario(nombre, correo, direccion, contrasena);
            usuariosRepo.save(usuario);
            return "Usuario añadido correctamente";
        } catch (Exception e) {
            return "Algo ha fallado en la operación, no se ha podido añadir al usuario";
        }
    }

    public String actualizarUsuario(Usuario usuario) {
        try {
            usuariosRepo.findById(usuario.getUsuario_id());
            usuariosRepo.save(usuario);
            return "Se ha actualizado al usuario correctamente";
        } catch (Exception e) {
            return "Ha habido un fallo a la hora de actualizar el usuario";
        }
    }

    public String eliminarUsuario(String nombre, String contrasena) {
        try {
            int id = usuariosRepo.idEmpleadosPorNombreYContrasena(nombre, contrasena);
            usuariosRepo.deleteById(id);
            return "Se ha eliminado al usuario correctamente";
        } catch (Exception e) {
            return "Ha habido un fallo y no se ha podido eliminar al usuario";
        }
    }

    public boolean validarUsuario(String nombre, String contrasena) {
        boolean comprobar = false;
        try {
            int id = usuariosRepo.idEmpleadosPorNombreYContrasena(nombre, contrasena);
            if (usuariosRepo.findById(id).isPresent()) {
                comprobar = true;
            }

            return comprobar;
        } catch (Exception e) {
            return false;
        }
    }

    public String obtenerInfoUsuarioPorId(int id) {
        try {
            String nombre = usuariosRepo.findById(id).get().getNombre();
            return nombre;
        } catch (Exception e) {
            return "El usuario no se ha validado correctamente o no existe";
        }
    }

    public String obtenerInfoUsuarioPorNombre(String nombre) {
        return usuariosRepo.idEmpleadosPorNombre(nombre);
    }

    public boolean checkIfExists(int id) {
        return usuariosRepo.existsById(id);
    }
}

