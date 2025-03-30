package com.asarfi.User.mapper;

import com.asarfi.User.dto.create.CreateUser;
import com.asarfi.User.dto.response.UserResponse;
import com.asarfi.User.entity.User;
import com.asarfi.User.exception.exceptionClassList.DateConversionException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class UserMapper {


    public User mapToEntity(CreateUser createUser){
        User user =new User();
        user.setUserName(createUser.user_name());
        user.setUserAddress(createUser.user_address());
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        user.setUserDOB(LocalDate.parse(createUser.user_dob(),formatter));
        }
        catch (DateTimeParseException exception){
            throw new DateConversionException("Invalid date format. Should be YYYY/MM/DD");
        }
        user.setUserEmail(createUser.user_email());
        user.setUserGender(createUser.user_gender());
        return user;
    }

    public UserResponse mapToResponse(User user){
        UserResponse userResponse=new UserResponse(user.getUserId(), user.getUserName(), user.getUserDOB().toString(), user.getUserAddress(), user.getUserEmail(),user.getUserGender());
        return userResponse;
    }

}
