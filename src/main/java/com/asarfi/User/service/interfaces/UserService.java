package com.asarfi.User.service.interfaces;

import com.asarfi.User.dto.create.CreateUser;
import com.asarfi.User.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(CreateUser user);
    List<UserResponse> getAllUsers();
    void deleteUserById(int userId);
    UserResponse updateUser(CreateUser user,int userId);
    UserResponse getUserById(int userId);

}
