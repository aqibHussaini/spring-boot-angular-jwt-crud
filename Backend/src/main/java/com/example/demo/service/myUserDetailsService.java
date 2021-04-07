package com.example.demo.service;

import com.example.demo.Entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.myUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class myUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findByuserName(s);
        myUserDetails myUserDetails = null;
        if (user != null) {
            myUserDetails = new myUserDetails(user);
        }
        return myUserDetails;
    }
}
