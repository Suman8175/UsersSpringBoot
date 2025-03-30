package com.asarfi.User.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Documented
@Constraint(validatedBy = GenderValidatorClass.class)
public @interface GenderValidator {
    public String message() default "Gender should be either M or F";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
