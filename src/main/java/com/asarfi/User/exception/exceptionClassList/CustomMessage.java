package com.asarfi.User.exception.exceptionClassList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomMessage {
    private int status;
    private String message;
    private long timeStamp;

    public CustomMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public CustomMessage(String message, long timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
