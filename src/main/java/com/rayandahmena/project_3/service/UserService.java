package com.rayandahmena.project_3.service;

import com.rayandahmena.project_3.entity.User;
import com.rayandahmena.project_3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        User user = userRepository.findByEmail(username);

        if(user == null)
            throw new UsernameNotFoundException("User doesn't exist by this name");

        return user;
    }

    public Optional<User> getUser(int id){
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email){
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Integer getUserId(Authentication auth){
        return getUserByEmail(auth.getName()).get().getId();
    }

    public User createNewUser(User user){
        if(!checkExistingEmail(user)){
            return userRepository.save(user);
        }
        return null;
    }

    public boolean checkExistingEmail(User user){
        String email = user.getEmail();
        User newUser =  userRepository.findByEmail(email);
        // if new user email already exists
        return newUser != null;
    }
}
