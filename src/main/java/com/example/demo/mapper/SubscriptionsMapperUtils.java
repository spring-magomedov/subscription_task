package com.example.demo.mapper;

import com.example.demo.dto.UsersDTO;
import com.example.demo.entity.Users;
import com.example.demo.repository.SubscriptionsRepository;
import com.example.demo.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@Named("SubscriptionsMapperUtils")
@RequiredArgsConstructor
public class SubscriptionsMapperUtils {
    private final SubscriptionsRepository subscriptionsRepository;
    private final UsersRepository usersRepository;
    @Named("findUsersById")
    public Users findUsersById(Long id) {
        if(id == null) {
            return null;
        }
        else {
            return usersRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id: "+id+" not found"));
        }
    }
}
