package com.harshet.authentication.authentication.repository;

import com.harshet.authentication.authentication.model.Session;
import com.harshet.authentication.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SessionRepository  extends JpaRepository<Session, Long> {
    List<Session> findByUser(User user);
    Optional<Session> findByToken(String token);

}