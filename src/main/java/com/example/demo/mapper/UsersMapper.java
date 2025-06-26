package com.example.demo.mapper;

import com.example.demo.dto.UsersDTO;
import com.example.demo.dto.UsersDTOResponse;
import com.example.demo.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsersMapper {

    Users toUsers(UsersDTO usersDTO);
    UsersDTOResponse toUsersDTO(Users users);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Users updateWithNull(UsersDTO usersDTO, @MappingTarget Users users);
}
