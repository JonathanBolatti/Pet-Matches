package com.petmatches.users.security.controller;

import com.petmatches.users.exception.AuthenticationException;
import com.petmatches.users.security.jwt.JwtProvider;
import com.petmatches.users.security.payload.JwtResponse;
import com.petmatches.users.security.payload.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/authenticate")
public class Authenticate {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    JwtProvider jwtProvider;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
            throws AuthenticationException {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtProvider.generateToken(userDetails);
        JwtResponse jwtResponse = new JwtResponse(token, userDetails.getUsername(), userDetails.getAuthorities());
        return ResponseEntity.ok((jwtResponse));
    }

    private void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

    }
}
