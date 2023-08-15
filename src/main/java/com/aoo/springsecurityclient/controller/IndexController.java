package com.aoo.springsecurityclient.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class IndexController {
    @GetMapping(path = "/hello")
    public String index(){
        return "hello every body";
    }
    @GetMapping(path = "/unauthenticated")
    public String non(){
        return "hello every body non authentifier";
    }
    @GetMapping(path = "/autre")
    public String autre(){
        return "hello every body non autre";
    }
    @GetMapping(path = "/home")
    public String home(){
        return "home";
    }
}
