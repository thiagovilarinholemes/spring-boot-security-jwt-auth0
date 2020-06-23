package com.thiago.dto;

import com.thiago.entities.Authorization;
import com.thiago.entities.User;
import com.thiago.repositories.AuthorizationRepository;
import com.thiago.services.AuthorizationService;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserDetailsDTO implements UserDetails {

    @Autowired
    private User user;

    public UserDetailsDTO(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Extract list of authorizations (name)
        for (Authorization a: user.getAuthorizations()){
            try{
                GrantedAuthority authority = new SimpleGrantedAuthority(a.getNameAuthorization());

                authorities.add(authority);
            }
            catch (LazyInitializationException e ){
                e.printStackTrace();
            }
        }
        // Extract list of roles (name)
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + this.user.getRole().getNameRole());
        authorities.add(authority);

        System.out.println(authorities);
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
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
        return this.user.getUserStatus() == 1;
    }

}
