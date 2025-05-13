package Controllers;

import Entities.Usuario;
import Services.UsuariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/registrar")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
        usuariosService.crearUsuario(usuario);
        String response = usuariosService.crearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
