package com.ayman.Honor.Schools.annotation;

import com.ayman.Honor.Schools.validations.FieldsValueMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FieldsValueMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsValueMatch
{
    String message()default "Please choose a strong password";
    Class<?>[] groups()default {};
    Class<? extends Payload>[] payload() default {};
    String field();
    String fieldMatch();
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List
    {
        FieldsValueMatch [] value();
    }
}
