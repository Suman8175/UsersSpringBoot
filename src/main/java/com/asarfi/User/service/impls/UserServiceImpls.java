package com.asarfi.User.service.impls;

import com.asarfi.User.dto.create.CreateUser;
import com.asarfi.User.dto.response.UserResponse;
import com.asarfi.User.entity.User;
import com.asarfi.User.exception.exceptionClassList.ResourceNotFoundException;
import com.asarfi.User.mapper.UserMapper;
import com.asarfi.User.repository.UserRepository;
import com.asarfi.User.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpls implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(CreateUser user) {
        User user1 = userMapper.mapToEntity(user);
        User savedUser = userRepository.save(user1);
        return  userMapper.mapToResponse(savedUser);
    }

    @Override
    public List<UserResponse> getAllUsers() {
      List<User> allUsers =userRepository.findAll();
        List<UserResponse> collect = allUsers.stream().map((eachUser) -> userMapper.mapToResponse(eachUser)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void deleteUserById(int userId) {
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isEmpty()){
            throw new ResourceNotFoundException("User not found");
        }
        User user = byId.get();
        userRepository.delete(user);
    }

    @Override
    public UserResponse updateUser(CreateUser user, int userId) {
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isEmpty()){
            throw new ResourceNotFoundException("User not found");
        }
        User userById = byId.get();
        User user1 = userMapper.mapToEntity(user);
        userById.setUserDOB(user1.getUserDOB());
        userById.setUserAddress(user1.getUserAddress());
        userById.setUserName(user1.getUserName());
        userById.setUserEmail(user1.getUserEmail());
        userById.setUserGender(user1.getUserGender());

        User savedUser = userRepository.save(userById);
        return userMapper.mapToResponse(savedUser);
    }

    @Override
    public UserResponse getUserById(int userId) {
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isEmpty()){
            throw new ResourceNotFoundException("User not Found");
        }
       return   userMapper.mapToResponse(userRepository.findById(userId).get());
    }
}
