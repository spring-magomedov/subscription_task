package com.example.demo.Service;


import com.example.demo.dto.SubscriptionsDTO;
import com.example.demo.dto.SubscriptionsDTOResponse;

import java.util.List;

public interface SubscriptionsService {
    List<SubscriptionsDTOResponse> getSubscription(Long id);
    SubscriptionsDTOResponse save(Long id, SubscriptionsDTO subscription);
    void delete(Long id, Long subscriptionId);
}
