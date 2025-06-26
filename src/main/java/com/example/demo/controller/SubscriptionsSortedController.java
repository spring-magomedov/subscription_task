package com.example.demo.controller;

import com.example.demo.Service.SubscriptionSortedService;
import com.example.demo.entity.enumSubscriptions.SubscriptionsType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionsSortedController {
    private final SubscriptionSortedService subscriptionsService;
    @GetMapping("/top")
    public ResponseEntity<List<SubscriptionsType>> SubscriptionsTop() {
        return ResponseEntity.ok().body(subscriptionsService.getTopSubscriptions());
    }
}
