package com.security.applicationsecure.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;


public class CustomUserDetails implements UserDetails {

    private  String username;
    private  String password;
    private  String fullname;


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    private Collection<? extends GrantedAuthority>Authorities;

    public CustomUserDetails(String username, String password, String fullname, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        Authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
