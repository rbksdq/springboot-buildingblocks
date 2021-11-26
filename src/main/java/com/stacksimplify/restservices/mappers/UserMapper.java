package com.stacksimplify.restservices.mappers;

import com.stacksimplify.restservices.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.stacksimplify.restservices.dtos.UserMsDto;

import java.util.List;

@Mapper (componentModel = "Spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //User to UserMsDto
    @Mapping(source= "role", target = "rolename") //did this b/c role was defined initially in user class and rolename in Dto class
    UserMsDto userToUserMsDto(User user);


    //List<User> to List<UserMsDtos>
    List<UserMsDto> userToUserDtos(List<User> users);

}
