package com.istad.springjwt.service.serviceImpl;

import com.istad.springjwt.model.Users;
import com.istad.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Users user = (Users) userRepository.getUserByName(name).stream().findAny().orElse(null);
        System.out.println("here is the authentication : " +user);
        if(user==null){
            throw new UsernameNotFoundException("Authentication User don't exist!");
        }
        org.springframework.security.core.userdetails.User user1= (org.springframework.security.core.userdetails.User) org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole()).build();

        return user1;
    }
}
