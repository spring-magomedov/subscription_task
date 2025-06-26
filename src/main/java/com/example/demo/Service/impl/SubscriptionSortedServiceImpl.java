package com.example.demo.Service.impl;

import com.example.demo.Service.SubscriptionSortedService;
import com.example.demo.entity.enumSubscriptions.SubscriptionsType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.repository.SubscriptionsRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class SubscriptionSortedServiceImpl implements SubscriptionSortedService {
    private final SubscriptionsRepository subscriptionsRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SubscriptionsType> getTopSubscriptions() {
        return subscriptionsRepository.findTopSubscriptions();
    }
}
