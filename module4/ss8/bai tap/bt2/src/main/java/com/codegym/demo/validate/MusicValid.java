package com.codegym.demo.validate;

import com.codegym.demo.entity.Music;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MusicValid  implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Music.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Music music=(Music) target;
        if(music.getName().matches("^[a-z0-9]$")){
            errors.rejectValue("name","name.valid");
        }
        if(music.getSinger().matches("^[a-z0-9]$")){
            errors.rejectValue("singer","singer.valid");
        }
        if(music.getType().matches("^[a-z0-9]$")){
            errors.rejectValue("type","type.valid");
        }

    }
}
