package com.complany.accounting.validation;

import com.complany.accounting.enums.EmployeeType;
import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

public class EnumerationMixMaxValidator implements ConstraintValidator<ValidateEnumerationMinMax, Enum<?>> {

    private Integer min;
    private Integer max;

    @Override
    public void initialize(ValidateEnumerationMinMax constraint) {
//        min = constraint.min();
//        max = constraint.max();
    }

    @SneakyThrows
    @Override
    public boolean isValid(Enum<?> obj, ConstraintValidatorContext context) {
        /*if (obj == null) {
            return true;
        }
        Class<? extends Enum> objClass = obj.getClass();
        Method[] methods = objClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals("getId")
                    && method.getReturnType() == Integer.class
                    && method.getParameterCount() == 0) {
                Integer id = (Integer) method.invoke(obj);
                return id >= min && id <= max;
            }
        }
        return false;*/

        return obj != null;
    }
}
