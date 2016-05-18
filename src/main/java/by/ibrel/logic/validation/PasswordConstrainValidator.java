package by.ibrel.logic.validation;


import com.google.common.base.Joiner;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Created by ibrel on 12.04.2016.
 */
public class PasswordConstrainValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public void initialize(final ValidPassword validPassword) {

    }

    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext constraintValidatorContext) {

        final PasswordValidator passwordValidator = new PasswordValidator(Arrays.asList(new LengthRule(8,30), new UppercaseCharacterRule(1), new SpecialCharacterRule(1), new WhitespaceRule()));
        final RuleResult result = passwordValidator.validate(new PasswordData(password));

        if (result.isValid()){
            return true;
        }

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(Joiner.on("\n").join(passwordValidator.getMessages(result))).addConstraintViolation();
        return false;
    }
}