package com.kodigo.service.impl;

import com.kodigo.model.Cliente;
import com.kodigo.repo.IClienteRepo;
import com.kodigo.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private IClienteRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Cliente usuario = repo.findOneByUsuario(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(String.format(Constantes.USUARIO_NO_EXISTE, username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        UserDetails ud = new User(usuario.getUsuario(), usuario.getClave(), roles);

        return ud;
    }

}
