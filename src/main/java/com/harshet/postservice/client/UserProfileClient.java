package com.harshet.postservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "UserProfile")
public interface UserProfileClient {
    @GetMapping("/profiles/check")
    boolean checkUserExists(@RequestParam("userId") Long userId);
}

