package com.harshet.userprofile.Services;

import com.harshet.userprofile.Models.UserProfile;
import com.harshet.userprofile.Repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl {

    @Autowired
    private UserProfileRepository userProfileRepository;


    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }


    public UserProfile getUserProfileByUsername(String username) {
        Optional<UserProfile>  profile = userProfileRepository.findByUsername(username);
        if(profile.isEmpty()){
            return null;
        }
        return profile.get();
    }


    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }
}
