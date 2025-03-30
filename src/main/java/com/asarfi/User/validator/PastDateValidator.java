package com.asarfi.User.validator;

import com.asarfi.User.exception.exceptionClassList.DateConversionException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PastDateValidator implements ConstraintValidator<PastDateCheck,String> {

    @Override
    public boolean isValid(String date, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate parsedDate;
        try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        parsedDate= LocalDate.parse(date, formatter);
        }
        catch (DateTimeParseException exception){
            throw new DateConversionException("Invalid date format. Should be YYYY/MM/DD");
        }
        return parsedDate.isBefore(LocalDate.now());
    }
}
