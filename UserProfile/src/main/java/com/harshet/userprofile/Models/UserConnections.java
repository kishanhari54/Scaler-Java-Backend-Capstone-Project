package com.harshet.userprofile.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserConnections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile user;

    @ManyToOne
    @JoinColumn(name = "friend_id", nullable = false)
    private UserProfile friend;

    // Connection status: Pending, Accepted, Blocked
    @Column(nullable = false)
    private String status;
}
