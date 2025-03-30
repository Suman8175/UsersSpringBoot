package com.asarfi.User.exception.exceptionClassList;

public class DateConversionException  extends RuntimeException{

    public DateConversionException(String message) {
        super(message);
    }

    public DateConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DateConversionException(Throwable cause) {
        super(cause);
    }
}
