package com.asarfi.User.controller;


import com.asarfi.User.dto.CustomResponse;
import com.asarfi.User.dto.create.CreateUser;
import com.asarfi.User.dto.response.UserResponse;
import com.asarfi.User.service.interfaces.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asarfi/v1")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> addUserToDB(@RequestBody @Valid CreateUser createUser){
        UserResponse user = userService.createUser(createUser);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        CustomResponse getAllUser =new CustomResponse();
        getAllUser.setStatusCode(200);
        getAllUser.setTimeStamp(System.currentTimeMillis());
        getAllUser.setObjects(userService.getAllUsers());
        return  new ResponseEntity<>(getAllUser,HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUserByUserId(@PathVariable int userId){
        userService.deleteUserById(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody @Valid CreateUser user , @PathVariable int userId){
        return new ResponseEntity<>(userService.updateUser(user,userId),HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?>getUserById(@PathVariable int userId){
        return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.OK);
    }

}
