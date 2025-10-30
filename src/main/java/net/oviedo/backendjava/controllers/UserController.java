package net.oviedo.backendjava.controllers;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.oviedo.backendjava.models.requests.UserDetailsRequestModel;
import net.oviedo.backendjava.models.requests.responses.UserRest;
import net.oviedo.backendjava.services.UserServiceInterface;
import net.oviedo.backendjava.shared.dto.UserDto;  

@RestController
@RequestMapping("/users") //localhost:8080/users
public class UserController {

     @Autowired
     UserServiceInterface userService;
     

    @GetMapping( produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE } )
     public UserRest getUsers() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getPrincipal().toString();

        UserDto userDto = userService.getUser(email);

        UserRest userToReturn = new UserRest();

        BeanUtils.copyProperties(userDto, userToReturn);

        return userToReturn;
    }


     @PostMapping
     public UserRest createUsers(@RequestBody UserDetailsRequestModel userDetails ) {
       
        //Seguridad

        UserRest userToReturn = new UserRest();

        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        
        BeanUtils.copyProperties(createdUser, userToReturn);

        return userToReturn;




    }

    
     
    
}
