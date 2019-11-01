package com.moshtel.firstbootproject.services;

import com.moshtel.firstbootproject.entities.User;
import com.moshtel.firstbootproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class AppUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user= userRepository.findDistinctByEmail(userEmail);

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getEmail(),
                new ArrayList<GrantedAuthority>()
        );
    }
}
