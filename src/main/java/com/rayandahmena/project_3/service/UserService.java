package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.dto.RegisterDTO;
import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        User user = userRepository.findByEmail(username);

        if(user == null)
            throw new UsernameNotFoundException("User doesn't exist by this name");

        return user;
    }

    public User register(RegisterDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        String password = passwordEncoder.encode(dto.getPassword());
        user.setPassword(password);
        return userRepository.save(user);
    }
}
