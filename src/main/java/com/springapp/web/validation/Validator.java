package com.springapp.web.validation;

import org.springframework.validation.Errors;

public interface Validator<T> {

    public void validate(T t, Errors errors);

}
