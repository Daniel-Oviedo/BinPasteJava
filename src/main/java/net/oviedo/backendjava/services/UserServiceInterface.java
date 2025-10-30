package net.oviedo.backendjava.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.oviedo.backendjava.shared.dto.UserDto;

public interface UserServiceInterface extends UserDetailsService {

    public UserDto createUser(UserDto user);
    public UserDto getUser(String email);
    

    
}
