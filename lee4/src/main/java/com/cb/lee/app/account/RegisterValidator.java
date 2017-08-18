package com.cb.lee.app.account;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cb.lee.domain.service.account.AccountService;

@Component
public class RegisterValidator implements Validator {
	@Inject 
	protected AccountService accountService;

    @Override
    //TODO
    public boolean supports(Class<?> clazz) {
        return AccountForm.class.isAssignableFrom(clazz);
    }

    @Override
    //验证密码，密码输入为空或密码确认与密码不匹配。用户是否已存在
    public void validate(Object target, Errors errors) {
        AccountForm form = (AccountForm) target;
        String password = form.getPassword();
        String repeatedPassword = form.getRepeatedPassword();
        String username = form.getUsername();
        if (password == null || repeatedPassword == null) {
            return;
        }
        if (!password.equals(repeatedPassword)) {
            errors.rejectValue("repeatedPassword",
                    "RegisterValidator.accountForm.password",
                    "密码不匹配！");
        }
        if (accountService.getAccount(username) != null) {
            errors.rejectValue("username",
                    "RegisterValidator.accountForm.username",
                    "用户名已存在！");
        }
    }

}
