package org.example.springboot.secure;

import org.example.springboot.db.UserDB;
import org.example.springboot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService  implements UserDetailsService {

    private UserDB UserDB;

    @Autowired
    public CustomUserDetailsService(UserDB userRepository) {
        this.UserDB = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = UserDB.findUserByLogin(login).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return user;
    }
}

