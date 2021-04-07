package com.example.demo.Controllers;

import com.example.demo.Entities.JwtRequest;
import com.example.demo.Entities.JwtResponse;
import com.example.demo.Entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.myUserDetailsService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    myUserDetailsService myUserDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @PostMapping("/register")
    public  User SaveUser(@RequestBody User user)
    {
        return this.userRepository.save(user);
    }
    @PostMapping("/get-token")
    public JwtResponse getToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            System.out.println(jwtRequest);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        UserDetails userDetails=this.myUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token= jwtUtil.generateToken(jwtRequest.getUsername());
        return new JwtResponse(token);
    }

}
