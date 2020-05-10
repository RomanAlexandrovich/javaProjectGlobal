package by.global.auth.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import by.global.model.UserMY;
import by.global.service.UserService;
@Component
public class UserValidator implements Validator{
	@Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserMY.class.equals(aClass);
    }
    @Override
    public void validate(Object o, Errors errors) {
        UserMY user = (UserMY) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameUser", "NotEmpty");
        if (user.getNameUser().length() < 6 || user.getNameUser().length() > 32) {
            errors.rejectValue("nameUser", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getNameUser()) != null) {
            errors.rejectValue("nameUser", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordUser", "NotEmpty");
        if (user.getPasswordUser().length() < 8 || user.getPasswordUser().length() > 32) {
            errors.rejectValue("passwordUser", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPasswordUser())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
