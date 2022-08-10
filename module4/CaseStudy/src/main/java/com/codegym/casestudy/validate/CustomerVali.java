package com.codegym.casestudy.validate;

import com.codegym.casestudy.entity.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CustomerVali implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
Customer customer=(Customer) target;
        ValidationUtils.rejectIfEmpty(errors,"customerName","name.empty");
        ValidationUtils.rejectIfEmpty(errors,"customerBirthday","name.empty");
        ValidationUtils.rejectIfEmpty(errors,"customerGender","name.empty");
        ValidationUtils.rejectIfEmpty(errors,"customerIdCard","name.empty");
        ValidationUtils.rejectIfEmpty(errors,"customerPhone","name.empty");
        ValidationUtils.rejectIfEmpty(errors,"customerEmail","name.empty");
        ValidationUtils.rejectIfEmpty(errors,"customerAddress","name.empty");
        ValidationUtils.rejectIfEmpty(errors,"customerType","name.empty");

    }
}
