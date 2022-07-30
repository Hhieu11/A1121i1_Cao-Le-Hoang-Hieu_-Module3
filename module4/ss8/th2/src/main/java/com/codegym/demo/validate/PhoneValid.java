package com.codegym.demo.validate;

import com.codegym.demo.entity.Phone;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PhoneValid implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Phone phone=(Phone) target;
        ValidationUtils.rejectIfEmpty(errors,"number","number.empty");
        if(phone.getNumber().length()>11||phone.getNumber().length()<10){
            errors.rejectValue("number","number.length",new String[]{"10"} ,"Dinh dang khong dung");
        }
        if(!phone.getNumber().startsWith("0")){
            errors.rejectValue("number","number.startsWith",new String[]{"10"} ,"Dinh dang khong dung");
        }
        if(!phone.getNumber().matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.matches",new String[]{"10"} ,"Dinh dang khong dung");
        }


    }
}
