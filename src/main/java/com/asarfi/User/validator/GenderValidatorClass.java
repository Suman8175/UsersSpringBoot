package com.asarfi.User.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class GenderValidatorClass implements ConstraintValidator<GenderValidator,Character> {
    @Override
    public boolean isValid(Character character, ConstraintValidatorContext constraintValidatorContext) {
        List<Character> genderList = List.of('m','f');
        return genderList.contains(Character.toLowerCase(character));
    }
}
