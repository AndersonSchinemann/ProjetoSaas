package com.topdata.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.topdata.model.Usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserDetailsAdapter implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Usuario usuario;

    public UserDetailsAdapter(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        // Adicione outras autoridades, se necessário
        return authorities;
    }

    @Override
    public String getPassword() {
        // Retorne a senha do usuário
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        // Retorne o nome de usuário do usuário
        return usuario.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implemente a lógica para verificar se a conta do usuário não está expirada
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implemente a lógica para verificar se a conta do usuário não está bloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implemente a lógica para verificar se as credenciais do usuário não estão expiradas
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Implemente a lógica para verificar se a conta do usuário está habilitada
        return true;
    }
}