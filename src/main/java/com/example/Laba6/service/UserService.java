package com.example.Laba6.service;

import com.example.Laba6.dto.UserDto;
import com.example.Laba6.entity.User;
import com.example.Laba6.facade.UserFacade;
import com.example.Laba6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> read() {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : userRepository.findAll())
            userDtos.add(UserFacade.mapToUserDto(user));
        return userDtos;
    }

    public UserDto read(String login) {
        return UserFacade.mapToUserDto(userRepository.findByLogin(login).orElseThrow(RuntimeException::new));
    }

    public UserDto create(UserDto userDto) {
        User user = UserFacade.mapToUser(userDto);
        userRepository.save(user);
        return UserFacade.mapToUserDto(user);
    }

    public Boolean delete(String userLogin) {
        try {
            userRepository.delete(userRepository.findByLogin(userLogin).orElseThrow(RuntimeException::new));
            return true;
        } catch (RuntimeException exception) {
            return false;
        }
    }
}
