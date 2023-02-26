package bg.softuni.moneyApp.validations.matchingPasswordAndConfirmPassword;

import bg.softuni.moneyApp.model.dto.UserRegisterDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordsMatcher implements ConstraintValidator<MatchingPasswordAndConfirmPassword, UserRegisterDTO> {

    @Override
    public void initialize(MatchingPasswordAndConfirmPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRegisterDTO user, ConstraintValidatorContext context) {
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
