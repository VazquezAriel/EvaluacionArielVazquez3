package com.evaluacion.app.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.evaluacion.app.models.Usuario;

@Service
public class UserDetailServiceImpl implements UserDetailsService{


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        /**Este usuario se debera obtener de la base de datos pero 
            por motivos de prueba y ya que en la base no tenemos 
            registros de usuarios lo cargamos desde memoria **/
        Usuario user = new Usuario(
            "admin",
            "Ariel Vazquez",
            new BCryptPasswordEncoder().encode("admin")
        );

        if (!user.getEmail().equals(email)) {
            throw new UsernameNotFoundException("No existe un usuario con ese email: " + email);
        }

        return new UserDetailsImpl(user);
    }

    
}
