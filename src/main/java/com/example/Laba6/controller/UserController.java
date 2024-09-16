package com.example.Laba6.controller;

import com.example.Laba6.dto.UserDto;
import com.example.Laba6.entity.User;
import com.example.Laba6.facade.UserFacade;
import com.example.Laba6.repository.UserRepository;
import com.example.Laba6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getAllUsers")
    public ResponseEntity<List<UserDto>> read() {
        List<UserDto> users = userService.read();
        if (!users.isEmpty())
            return new ResponseEntity<>(users, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("getUser/{login}")
    public ResponseEntity<UserDto> read(@PathVariable String login) {
        UserDto userDto = userService.read(login);
        if (userDto != null)
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("deleteUser/{login}")
    public ResponseEntity<Boolean> delete(@PathVariable String login){
        Boolean deleteUser = userService.delete(login);
        if (deleteUser){
            return new ResponseEntity<>(deleteUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(deleteUser, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("createUserByLogin")
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        UserDto userDto1 = userService.create(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }
}
