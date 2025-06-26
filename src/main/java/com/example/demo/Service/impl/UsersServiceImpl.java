package com.example.demo.Service.impl;

import com.example.demo.Service.UsersService;
import com.example.demo.dto.UsersDTO;
import com.example.demo.dto.UsersDTOResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.demo.mapper.UsersMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.repository.UsersRepository;

import java.time.Clock;
import java.time.Instant;

@RequiredArgsConstructor
@Service
@Slf4j
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;


    @Override
    @Transactional(readOnly = true)
    public UsersDTOResponse getOneUser(Long id) {
        log.info("Find user by id: {}", id);
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id must not be null");
        }
        var user = usersRepository.findById(id).orElse(null);
        if (user == null) {
            log.warn("User with id: {} not found", id);
        }
        else {
            log.info("User with id: {} found", id);
        }
        return usersMapper.toUsersDTO(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usersRepository.findById(id).ifPresent(usersRepository::delete);
    }

    @Override
    @Transactional
    public UsersDTOResponse save(UsersDTO usersDTO) {
        if(usersDTO.id() == null) {
            log.info("Saving user: {}", usersDTO);
            var users = usersMapper.toUsers(usersDTO);
            users.setCreatedAt(Instant.now(Clock.systemUTC()));
            var savedUsers = usersRepository.save(users);
            log.info("User saved successfully: {}", savedUsers);
            return usersMapper.toUsersDTO(savedUsers);
        }
        else{
            log.error("Attempt to save a user with non-null id: {}", usersDTO.id());
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Id must be null");
        }
    }

    @Override
    @Transactional
    public UsersDTOResponse update(Long id, UsersDTO usersDTO) {
        log.info("Updating users with id: {} using data {}", id, usersDTO);
        var users = usersRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id "+id+" not found"));
        usersMapper.updateWithNull(usersDTO, users);
        var resultUsers = usersRepository.save(users);
        log.info("User updated successfully: {}", resultUsers);
        return usersMapper.toUsersDTO(resultUsers);
    }
}
