package org.daniel.quickstart;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NotExpiredValidator implements ConstraintValidator<NotExpired, LocalDate> {


    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        if (localDate == null) return true;
        LocalDate now = LocalDate.now();
        return ChronoUnit.YEARS.between(now, localDate) > 0;
    }
}
