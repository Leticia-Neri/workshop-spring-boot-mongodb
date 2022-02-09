package com.leticialima.workshopmongo.service;

import com.leticialima.workshopmongo.domain.UsuarioModel;
import com.leticialima.workshopmongo.jwt.data.DetalheUsuarioData;
import com.leticialima.workshopmongo.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

//    @Autowired
//    UsuarioRepository usuarioRepository;

    private final UsuarioRepository repository;

    public DetalheUsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioModel> usuario = repository.findByLogin(username);
        if(username.isEmpty()){
            throw new UsernameNotFoundException("Usuario ["+ username + "] não encontrado");
        }

        return new DetalheUsuarioData(usuario);
    }
}
