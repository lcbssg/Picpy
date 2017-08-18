package com.cb.lee.app.account;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cb.lee.domain.model.Account;
import com.cb.lee.domain.model.UserDetails;

@Component
public class EditPswValidator implements Validator {

    @Override
    //TODO
    public boolean supports(Class<?> clazz) {
        return EditPswForm.class.isAssignableFrom(clazz);
    }

    @Override
    //验证密码，旧密码是否正确或密码输入为空或密码确认与密码不匹配
    public void validate(Object target, Errors errors) {
        EditPswForm form = (EditPswForm) target;
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        Account account = userDetails.getAccount();//得到了当前账户
        String oldPassword = form.getOldPassword();
        String password = form.getPassword();
        String repeatedPassword = form.getRepeatedPassword();
        String realPassword = account.getPassword();
        if ( password == null || repeatedPassword == null) {
            return;
        }
        if (!password.equals(repeatedPassword)) {
            errors.rejectValue("repeatedPassword",
                    "EditPswValidator.editPswForm.repeatedPassword",
                    "密码不匹配！");
        }
        if(!oldPassword.equals(realPassword)) {
        	errors.rejectValue("oldPassword",
                    "EditPswValidator.editPswForm.oldPassword",
                    "旧密码输入不正确！");
        }
    }
}
