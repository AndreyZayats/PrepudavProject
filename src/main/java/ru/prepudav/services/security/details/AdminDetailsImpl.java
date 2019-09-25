package ru.prepudav.services.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.prepudav.services.models.Admin;
import ru.prepudav.services.models.State;

import java.util.Collection;
import java.util.Collections;

public class AdminDetailsImpl implements UserDetails {
        private Admin admin;

    AdminDetailsImpl(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String adminRole = admin.getRole().name();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(adminRole);
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return admin.getHashPassword();
    }

    @Override
    public String getUsername() {
        return admin.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !admin.getState().equals(State.BANNED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return admin.getState().equals(State.ACTIVE);
    }
}
