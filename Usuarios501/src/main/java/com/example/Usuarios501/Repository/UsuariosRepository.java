package com.example.Usuarios501.Repository;



import com.example.Usuarios501.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

    @Query("Select u.id from Usuario u where u.nombre = :nombre and u.contrasena = :contrasena")
    int idEmpleadosPorNombreYContrasena(@Param("nombre") String nombre, @Param("contrasena") String contrasena);

    @Query("Select u.id from Usuario u where u.nombre = :nombre")
    String idEmpleadosPorNombre(@Param("nombre") String nombre);
}
