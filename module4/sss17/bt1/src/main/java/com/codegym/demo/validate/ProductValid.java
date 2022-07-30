package com.codegym.demo.validate;

import com.codegym.demo.entity.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProductValid implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product=(Product) target;
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "price", "price.empty");
        ValidationUtils.rejectIfEmpty(errors, "description", "description.empty");
        ValidationUtils.rejectIfEmpty(errors, "manufacturer", "manufacturer.empty");

    }
}
