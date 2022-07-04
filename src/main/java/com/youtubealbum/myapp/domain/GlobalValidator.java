package com.youtubealbum.myapp.domain;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class GlobalValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // return UserDto.class.equals(clazz);
        return UserDto.class.isAssignableFrom(clazz);
    } // 타입이 올바른지 검사

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto)target; // 타겟을 userDto 타입으로 형변환
        String id = userDto.getId(); // Dto 객체에서 id 가져오기
        String pwd = userDto.getPwd(); // Dto 객체에서 pwd 가져오기

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required"); // id가 비었을 때
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required"); // pwd가 비었을 때

        if(id==null || id.length() < 8 || id.length() > 12) { // id의 길이가 8~12가 아닐 때
            errors.rejectValue("id", "invalidLength");
        }

        if(pwd==null || pwd.length() < 8 || pwd.length() > 12) { // pwd의 길이가 8~12가 아닐 때
            errors.rejectValue("pwd", "invalidLength");
        }


    }
}
