package com.asarfi.User.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomResponse {
    private int statusCode;
    private long timeStamp;
    List<?> objects;
}
