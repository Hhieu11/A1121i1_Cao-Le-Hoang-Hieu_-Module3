package com.codegym.demo.Valid;

import com.codegym.demo.entity.Login;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValid implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Login.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Login login=(Login) target ;
        ValidationUtils.rejectIfEmpty(errors,"phoneNumber","number.empty");
        if(login.getPhoneNumber().length()>11||login.getPhoneNumber().length()<10){
            errors.rejectValue("phoneNumber","number.length",new String[]{"10"} ,"Dinh dang khong dung");
        }
        if(!login.getPhoneNumber().startsWith("0")){
            errors.rejectValue("phoneNumber","number.startsWith",new String[]{"10"} ,"Dinh dang khong dung");
        }
        if(!login.getPhoneNumber().matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "number.matches",new String[]{"10"} ,"Dinh dang khong dung");
        }


    }

    }

