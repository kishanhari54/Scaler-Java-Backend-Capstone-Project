package com.harshet.userprofile.Controllers;

import com.harshet.userprofile.Models.UserConnections;
import com.harshet.userprofile.Services.ConnectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connections")
public class ConnectionController {
    @Autowired
    private ConnectionServiceImpl connectionService;

    @PostMapping("/{username}/{friendUsername}")
    public UserConnections addConnection(@PathVariable String username, @PathVariable String friendUsername) {
        return connectionService.addConnection(username, friendUsername);
    }

    @GetMapping("/{username}")
    public List<UserConnections> getUserConnections(@PathVariable String username) {
        return connectionService.getUserConnections(username);
    }

    @PutMapping("/{connectionId}")
    public void updateConnectionStatus(@PathVariable Long connectionId, @RequestBody String status) {
        connectionService.updateConnectionStatus(connectionId, status);
    }
}
