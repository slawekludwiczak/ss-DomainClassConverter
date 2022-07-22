package pl.javastart.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javastart.demo.service.UserService;
import pl.javastart.demo.domain.ApplicationUser;

import java.util.List;

@RestController
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    List<ApplicationUser> users() {
        return userService.findAll();
    }

    @PostMapping("/users")
    ResponseEntity<?> save(ApplicationUser user) {
        userService.partialUpdate(user);
        return ResponseEntity.accepted().build();
    }
}
