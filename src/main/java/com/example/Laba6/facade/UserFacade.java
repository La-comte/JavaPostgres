package com.example.Laba6.facade;

import com.example.Laba6.dto.UserDto;
import com.example.Laba6.entity.User;

public class UserFacade {
    public static User mapToUser(UserDto userDto) {
        return new User(userDto.getId(), userDto.getLogin());
    }

    public static UserDto mapToUserDto(User user) {
        return new UserDto(user.getId(), user.getLogin());
    }
}
