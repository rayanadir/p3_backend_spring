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

/**
 * Class that handles user methods
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Get user by email
     * @param username email of the user
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        User user = userRepository.findByEmail(username);

        if(user == null)
            throw new UsernameNotFoundException("User doesn't exist by this name");

        return user;
    }


    /**
     * Find user by email
     * @param email of the user
     * @return User
     */
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    /**
     * Find user by id
     * @param id id of the user
     * @return User
     */
    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Error ! User not found"));
    }


    /**
     * Create a user
     * @param user User entity to save into userRepository
     * @return User
     */
    public User createNewUser(User user){
        return userRepository.save(user);
    }

    /**
     * Check if email is available
     * @param user User entity
     * @return boolean
     */
    public boolean isEmailAvailable(User user){
        String email = user.getEmail();
        User newUser =  userRepository.findByEmail(email);
        // if new user email doesn't exist
        return newUser == null;
    }
}
