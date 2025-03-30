package com.asarfi.User.dto.create;

import com.asarfi.User.validator.GenderValidator;
import com.asarfi.User.validator.PastDateCheck;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public record CreateUser(

        @NotBlank(message = "UserName cannot be null")
        String user_name,

        @NotBlank(message = "Date cannot be empty")
        @DateTimeFormat(pattern="yyyy-MM-dd")
        @PastDateCheck(message = "Past date should be used")
        String user_dob,

        @NotBlank(message = "User address is required")
        String user_address,

        @Email(message = "Improper email format")
        String user_email,

        @GenderValidator
        Character user_gender
) {
}
