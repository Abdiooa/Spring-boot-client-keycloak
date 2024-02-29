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
        return "this is an unauthenticated endpoint";
    }
    @GetMapping(path = "/")
    public HashMap indexe() {
        // get a successful user login
        OAuth2User user = ((OAuth2User)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return new HashMap(){{
            put("hello", user.getAttribute("name"));
            put("your email is", user.getAttribute("email"));
        }};
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
