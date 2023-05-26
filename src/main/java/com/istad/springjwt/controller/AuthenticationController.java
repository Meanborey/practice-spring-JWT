package com.istad.springjwt.controller;

import com.istad.springjwt.model.request.UserRequest;
import com.istad.springjwt.service.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    TokenService tokenService;
    AuthenticationController (TokenService tokenService){
        this.tokenService=tokenService;
    }
    @PostMapping("/token")
    public String getToken(@RequestBody UserRequest userRequest){
        try {
            System.out.println("here data :"+userRequest);
            Authentication authentication=new UsernamePasswordAuthenticationToken(
                    userRequest.getUsername(),
                    userRequest.getPassword()
            );
            return "successfully";
        }catch (Exception ex){
            return "failed";
        }

    }
}
