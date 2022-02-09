package com.leticialima.workshopmongo.resources;

import com.leticialima.workshopmongo.domain.UsuarioModel;
import com.leticialima.workshopmongo.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

//    @Autowired
//    UsuarioRepository repository;

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;


    public UsuarioController(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }




    @GetMapping("/listarTodos")
    public ResponseEntity<List<UsuarioModel>> listarTodos(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioModel> salvar(@RequestBody UsuarioModel usuarioModel){


        Optional<UsuarioModel> usuarioLogin = repository.findByLogin(usuarioModel.getLogin());
//        if(usuarioLogin.isPresent()){
//            throw new RuntimeException("usuario já tem login");
//
//        }

        usuarioModel.setPassword(encoder.encode(usuarioModel.getPassword()));
        return ResponseEntity.ok(repository.save(usuarioModel));
    }

    @GetMapping(value = "/validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login, @RequestParam String password){


        Optional<UsuarioModel> optUsuario = repository.findByLogin(login);
        //AQUI NO DELE ESTÁ NOTEMPTY
        if(!optUsuario.isPresent()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }



        UsuarioModel usuario = optUsuario.get();
        boolean valid = encoder.matches(password, usuario.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}