package Controllers;

import Application.Usuarios;
import Repositories.UsuariosRepository;
import Services.UsuariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuariosController {

    private final UsuariosService usuariosService;

    @GetMapping("/usuarios/registrar")
    public String crearUsuario(@RequestBody Usuarios usuario) {
        return usuariosService.crearUsuario(usuario);

    }
}
