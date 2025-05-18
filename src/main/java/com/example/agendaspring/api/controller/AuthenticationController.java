package com.example.agendaspring.api.controller;

import com.example.agendaspring.api.dto.authentication.AuthenticationDTO;
import com.example.agendaspring.api.dto.authentication.RegisterDTO;
import com.example.agendaspring.api.mapper.UserMapper;
import com.example.agendaspring.domain.entity.User;
import com.example.agendaspring.domain.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private AuthenticationManager authenticationManager;

    private UserRepository repository;

    private PasswordEncoder passwordEncoder;

    private UserMapper userMapper;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
         var userNamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.login(), authenticationDTO.password());
         var auth = this.authenticationManager.authenticate(userNamePassword);

         return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO) {
        if(repository.existsByLogin(registerDTO.login()))
            return ResponseEntity.badRequest().build();
        String encodedPassword = this.passwordEncoder.encode(registerDTO.password());
        User newUser = userMapper.register(registerDTO);
        this.repository.save(newUser);


        return ResponseEntity.ok().build();


    }
}
