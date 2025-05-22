package com.example.Usuarios501.Controllers;

import com.example.Usuarios501.Entities.Usuario;
import com.example.Usuarios501.Services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private UsuariosService usuariosService;

    @Autowired
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("TODO BON");
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
        String response = usuariosService.crearUsuario(usuario.getNombre(), usuario.getCorreo_electronico(), usuario.getDireccion(), usuario.getContrasena());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/registrar")
    public ResponseEntity<String> actualizarUsuario(@RequestBody Usuario usuario){
        String response = usuariosService.actualizarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("")
    public ResponseEntity<String> eliminarUsuario(@RequestBody Usuario usuario){
        String response = usuariosService.eliminarUsuario(usuario.getNombre(), usuario.getContrasena());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/validar")
    public ResponseEntity<Boolean> validarUsuario(@RequestBody Usuario usuario){
        boolean response = usuariosService.validarUsuario(usuario.getNombre(), usuario.getContrasena());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/info/id/{id}")
    public ResponseEntity<String> obtenerInfoUsuarioPorId(@PathVariable int id){
        String response = usuariosService.obtenerInfoUsuarioPorId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/info/nombre/{nombre}")
    public ResponseEntity<String> obtenerInfoUsuarioPorNombre(@PathVariable String nombre){
        String response = usuariosService.obtenerInfoUsuarioPorNombre(nombre);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/checkIfExists/{id}")
    public ResponseEntity<Boolean> usuarioExiste(@PathVariable int id){
        boolean response = usuariosService.checkIfExists(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
