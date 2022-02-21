package com.leticialima.workshopmongo.jwt.data;

import com.leticialima.workshopmongo.domain.Role;
import com.leticialima.workshopmongo.domain.UsuarioModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class DetalheUsuarioData implements UserDetails {

    private final Optional<UsuarioModel> usuario;
    private Collection<? extends GrantedAuthority> authorities;

    public DetalheUsuarioData(Optional<UsuarioModel> usuario, Set<Role> roles){
        this.usuario = usuario;
        this.authorities = roles.stream().map(x->new SimpleGrantedAuthority(x.getRole())).collect(Collectors.toList());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return usuario.orElse(new UsuarioModel()).getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.orElse(new UsuarioModel()).getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
