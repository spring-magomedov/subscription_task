package com.example.demo.Service;

import com.example.demo.dto.UsersDTO;
import com.example.demo.dto.UsersDTOResponse;


public interface UsersService {

    UsersDTOResponse getOneUser(Long id);
    void delete(Long id);
    UsersDTOResponse save(UsersDTO usersDTO);
    UsersDTOResponse update(Long id, UsersDTO usersDTO);

}
