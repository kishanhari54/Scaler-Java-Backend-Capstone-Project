package com.harshet.authentication.authentication.services;

import com.harshet.authentication.authentication.dto.UserDTO;
import com.harshet.authentication.authentication.exceptions.*;
import com.harshet.authentication.authentication.interfaces.AuthService;
import com.harshet.authentication.authentication.model.Session;
import com.harshet.authentication.authentication.model.User;
import com.harshet.authentication.authentication.repository.SessionRepository;
import com.harshet.authentication.authentication.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public void register(UserDTO userDTO) {
        if (userRepository.findByMobileNumber(userDTO.getMobileNumber()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        User user = new User();
        user.setMobileNumber(userDTO.getMobileNumber());
        user.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        userRepository.save(user);
    }

    @Override
    public String login(UserDTO userDTO) {
        User user = userRepository.findByMobileNumber(userDTO.getMobileNumber())
                .orElseThrow(UserNotFoundException::new);

        if (!new BCryptPasswordEncoder().matches(userDTO.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        if (sessionRepository.findByUser(user).size() >= 5) {
            throw new SessionsExceededException();
        }

        String token = Jwts.builder()
                .setSubject(user.getMobileNumber())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secret")
                .compact();

        Session session = new Session();
        session.setUser(user);
        session.setToken(token);
        session.setCreatedAt(LocalDateTime.now());
        sessionRepository.save(session);

        return token;
    }

    @Override
    public void logout(String token) {
        Session session = sessionRepository.findByToken(token)
                .orElseThrow(SessionNotFoundException::new);
        sessionRepository.delete(session);
    }
}
