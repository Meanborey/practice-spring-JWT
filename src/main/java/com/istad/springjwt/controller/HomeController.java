package com.istad.springjwt.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@Slf4j
public class HomeController {

    @GetMapping("/home")
    public String homepage(Authentication authentication){
        var user = authentication.getPrincipal();
        log.info("Here is the user :{}",authentication.getPrincipal());
//        log.info("Here is the user :{}",authentication.getCredentials());
//        log.info("Here is the user :{}",authentication.getDetails());
//        log.info("Here is the user :{}",authentication.getAuthorities());


        return "Hello!!"+authentication.getName();
    }
}
