package ru.netology.springboot_rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.springboot_rest.service.AuthorizationService;
import ru.netology.springboot_rest.user.Authorities;

import java.util.List;

@AllArgsConstructor
@RestController
public class AuthorizationController {
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}