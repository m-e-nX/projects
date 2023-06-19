package com.project.Horizon.usernameGenerator;

import org.springframework.stereotype.Component;

@Component
public class userNameGenerator {
    public String generateUsername(String username){
        
        return "@h_" + username.toLowerCase().replaceAll(" ", "_");
    }
}
