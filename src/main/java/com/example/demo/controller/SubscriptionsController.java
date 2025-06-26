package com.example.demo.controller;

import com.example.demo.Service.SubscriptionsService;
import com.example.demo.dto.SubscriptionsDTO;
import com.example.demo.dto.SubscriptionsDTOResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users/{id}/subscriptions")
public class SubscriptionsController {
    private final SubscriptionsService subscriptionsService;

    @GetMapping
    public ResponseEntity<List<SubscriptionsDTOResponse>> getUserSubscriptions(@PathVariable Long id) {
        return ResponseEntity.ok().body(subscriptionsService.getSubscription(id));
    }

    @PostMapping
    public ResponseEntity<SubscriptionsDTOResponse> createUserSubscription(@PathVariable Long id, @RequestBody @Valid SubscriptionsDTO subscription) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionsService.save(id, subscription));
    }

    @DeleteMapping("/{subscriptionId}")
    public ResponseEntity<Void> deleteUserSubscription(@PathVariable Long id, @PathVariable Long subscriptionId) {
        subscriptionsService.delete(id, subscriptionId);
        return ResponseEntity.noContent().build();
    }
}
