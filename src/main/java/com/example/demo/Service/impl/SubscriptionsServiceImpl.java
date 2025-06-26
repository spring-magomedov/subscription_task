package com.example.demo.Service.impl;


import com.example.demo.Service.SubscriptionsService;
import com.example.demo.dto.SubscriptionsDTO;
import com.example.demo.dto.SubscriptionsDTOResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.demo.mapper.SubscriptionsMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.repository.SubscriptionsRepository;
import com.example.demo.repository.UsersRepository;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class SubscriptionsServiceImpl implements SubscriptionsService {
    private final SubscriptionsRepository subscriptionsRepository;
    private final UsersRepository usersRepository;
    private final SubscriptionsMapper subscriptionsMapper;

    @Override
    @Transactional(readOnly = true)
    public List<SubscriptionsDTOResponse> getSubscription(Long id) {
        log.info("Find subscription by id: {}", id);
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id must not be null");
        }
        if (!usersRepository.existsById(id)) {
            log.warn("User with id: {} not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        var subscriptions = subscriptionsRepository.findByUsers_Id(id).stream().map(subscriptionsMapper::toSubscriptionsDTO).toList();
        log.info("Subscriptions with user id: {} found", id);
        return subscriptions;
    }

    @Override
    @Transactional
    public SubscriptionsDTOResponse save(Long id, SubscriptionsDTO subscription) {
        log.info("Saving subscription: {}, for user: {}", subscription, id);
        if (subscription.id() == null) {
            var subscriptions = subscriptionsMapper.toSubscriptions(subscription);
            subscriptions.setStartDate(LocalDateTime.now());
            subscriptions.setCreatedAt(Instant.now(Clock.systemUTC()));
            subscriptions.setUpdatedAt(Instant.now(Clock.systemUTC()));
            subscriptions = subscriptionsRepository.save(subscriptions);
            log.info("Subscription with id: {} saved", subscriptions.getId());
            return subscriptionsMapper.toSubscriptionsDTO(subscriptions);
        }
        else{
            log.error("Attempt to save a subscriptions with non-null id: {}", subscription.id());
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Id must be null");
        }
    }

    @Override
    @Transactional
    public void delete(Long id, Long subscriptionId) {
        if(!subscriptionsRepository.existsByUsers_IdAndId(id, subscriptionId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subscription not found");
        }
        subscriptionsRepository.findById(id).ifPresent(subscriptionsRepository::delete);
    }

}
