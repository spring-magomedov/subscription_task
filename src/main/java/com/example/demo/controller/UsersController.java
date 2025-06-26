package com.example.demo.controller;

import com.example.demo.Service.UsersService;
import com.example.demo.dto.UsersDTO;
import com.example.demo.dto.UsersDTOResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    private final UsersService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTOResponse> getOneUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getOneUser(id));
    }

    @PostMapping
    public ResponseEntity<UsersDTOResponse> createUser(@RequestBody @Valid UsersDTO usersDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(usersDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDTOResponse> updateUser(@PathVariable Long id, @RequestBody @Valid UsersDTO usersDTO) {
        return ResponseEntity.ok().body(userService.update(id, usersDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
