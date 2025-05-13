package Services;

import Entities.Usuario;
import Repositories.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepo;

    public String crearUsuario(Usuario usuario) {
        try {
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
            return "Se ha actualizado al usuario correectamente";
        } catch (Exception e) {
            return "Ha habido un fallo a la hora de actualizar el usuario";
        }
    }

    public String eliminarUsuario(String nombre, String contrasena) {
        try {
            List<Usuario> listaUsuarios = usuariosRepo.findAll();
            for (int i = 0; i < listaUsuarios.size(); i++) {
                if (listaUsuarios.get(i).getNombre().equalsIgnoreCase(nombre) && listaUsuarios.get(i).getContrasena().equalsIgnoreCase(contrasena)) {
                    usuariosRepo.delete(listaUsuarios.get(i));
                    break;
                }
            }
            return "Se ha eliminado al usuario correctamente";
        } catch (Exception e) {
            return "Ha habido un fallo y no se ha podido eliminar al usuario";
        }
    }

    public boolean validarUsuario(String nombre, String contrasena) {
        boolean comprobar = false;
        try {
            List<Usuario> listaUsuarios = usuariosRepo.findAll();
            for (int i = 0; i < listaUsuarios.size(); i++) {
                if (listaUsuarios.get(i).getNombre().equalsIgnoreCase(nombre) && listaUsuarios.get(i).getContrasena().equalsIgnoreCase(contrasena)) {
                    comprobar = true;
                    break;
                }
            }
            return comprobar;
        } catch (Exception e) {
            return false;
        }
    }

    public String obtenerInfoUsuarioPorId(int id) {
        try {
            return "Nombre del usuario: " + usuariosRepo.findById(id).get().getNombre();
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

