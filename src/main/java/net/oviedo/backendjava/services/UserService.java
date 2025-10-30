package net.oviedo.backendjava.services;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.oviedo.backendjava.entities.UserEntiti;
import net.oviedo.backendjava.repositories.UserRepository;
import net.oviedo.backendjava.shared.dto.UserDto;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDto createUser(UserDto user) {

     if(userRepository.findByEmail(user.getEmail()) != null) 
            throw new RuntimeException("El correo ya existe");
        


        UserEntiti userEntity = new UserEntiti();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        UUID userId = UUID.randomUUID();
        userEntity.setUserId(userId.toString()); 


        UserEntiti storedUserDetails = userRepository.save(userEntity);

        UserDto userToReturn = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, userToReturn);


        return userToReturn; 
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

      UserEntiti userEntiti = userRepository.findByEmail(email);
       if (userEntiti == null) {
        
        throw new UsernameNotFoundException(email);

       }

        return new User(userEntiti.getEmail(), userEntiti.getEncryptedPassword(), new ArrayList<>());

    }


    @Override
    public UserDto getUser(String email) {

        UserEntiti userEntiti = userRepository.findByEmail(email);

       if (userEntiti == null) {
        
        throw new UsernameNotFoundException(email);

       }

       UserDto userToReturn = new UserDto();
       
       BeanUtils.copyProperties(userEntiti, userToReturn);

       return userToReturn;
    }


   
    
    
}
