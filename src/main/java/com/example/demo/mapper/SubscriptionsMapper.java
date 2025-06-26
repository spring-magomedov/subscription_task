package com.example.demo.mapper;

import com.example.demo.dto.SubscriptionsDTO;
import com.example.demo.dto.SubscriptionsDTOResponse;
import com.example.demo.entity.Subscriptions;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.time.Clock;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {SubscriptionsMapperUtils.class})
public interface SubscriptionsMapper {
    @Mapping(target = "users", qualifiedByName = {"SubscriptionsMapperUtils", "findUsersById"}, source = "users")
    Subscriptions toSubscriptions(SubscriptionsDTO dto);

    SubscriptionsDTOResponse toSubscriptionsDTO(Subscriptions subscriptions);
}
