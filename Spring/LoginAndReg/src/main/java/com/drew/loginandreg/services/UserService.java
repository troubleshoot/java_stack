package com.drew.loginandreg.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;

import org.springframework.stereotype.Service;

import com.drew.loginandreg.models.User;
import com.drew.loginandreg.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        if(findByEmail(user.getEmail()) == null) {
        	return userRepository.save(user);
        }else
        	return null;
    }

	public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

	public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }

	public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }

	public boolean checkUser(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            return false;
        }
        else {
        	return true;
        }
    }
}