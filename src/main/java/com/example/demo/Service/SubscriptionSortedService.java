package com.example.demo.Service;

import com.example.demo.entity.enumSubscriptions.SubscriptionsType;

import java.util.List;

public interface SubscriptionSortedService {
    List<SubscriptionsType> getTopSubscriptions();
}
