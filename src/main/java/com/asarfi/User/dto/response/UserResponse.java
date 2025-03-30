package com.asarfi.User.dto.response;



public record UserResponse(
        Integer user_id,
        String user_name,
        String user_dob,
        String user_address,
        String user_email,
        Character user_gender
) {
}
