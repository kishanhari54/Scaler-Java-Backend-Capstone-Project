package com.harshet.userprofile.Services;

import com.harshet.userprofile.Models.UserConnections;
import com.harshet.userprofile.Models.UserProfile;
import com.harshet.userprofile.Repository.ConnectionRepository;
import com.harshet.userprofile.Repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ConnectionServiceImpl {
    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;


    public UserConnections addConnection(String username, String friendUsername) {
        Optional<UserProfile> user = userProfileRepository.findByUsername(username);
        Optional<UserProfile> friend = userProfileRepository.findByUsername(friendUsername);
        UserConnections connection = new UserConnections();
        connection.setUser(user.get());
        connection.setFriend(friend.get());
        connection.setStatus("Pending");
        return connectionRepository.save(connection);
    }


    public List<UserConnections> getUserConnections(String username) {
        Optional<UserProfile> user = userProfileRepository.findByUsername(username);
        return connectionRepository.findByUser(user.get());
    }


    public void updateConnectionStatus(Long connectionId, String status) {
        UserConnections connection = connectionRepository.findById(connectionId).orElseThrow();
        connection.setStatus(status);
        connectionRepository.save(connection);
    }


}
