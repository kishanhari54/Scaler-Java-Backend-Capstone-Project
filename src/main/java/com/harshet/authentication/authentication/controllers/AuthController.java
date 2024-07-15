package com.harshet.authentication.authentication.controllers;

import com.harshet.authentication.authentication.dto.SessionDTO;
import com.harshet.authentication.authentication.dto.UserDTO;
import com.harshet.authentication.authentication.interfaces.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @GetMapping()
    public String dummy(){
        return "DUMMY";
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody  UserDTO userDTO) {
        authService.register(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<SessionDTO> login(@RequestBody  UserDTO userDTO) {
        String token = authService.login(userDTO);
        SessionDTO sessionDTO = new SessionDTO();
        sessionDTO.setToken(token);
        return ResponseEntity.ok(sessionDTO);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String token) {
        authService.logout(token);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
