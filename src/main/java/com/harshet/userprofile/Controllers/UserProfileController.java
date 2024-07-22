package com.harshet.userprofile.Controllers;

import com.harshet.userprofile.Models.UserProfile;
import com.harshet.userprofile.Services.UserProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class UserProfileController {
    @Autowired
    private UserProfileServiceImpl userProfileService;

    @PostMapping
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.createUserProfile(userProfile);
    }

    @GetMapping("/{username}")
    public UserProfile getUserProfile(@PathVariable String username)  throws Exception{
        return userProfileService.getUserProfileByUsername(username);
    }

    @GetMapping
    public List<UserProfile> getAllUserProfiles() {
        return userProfileService.getAllUserProfiles();
    }
}
