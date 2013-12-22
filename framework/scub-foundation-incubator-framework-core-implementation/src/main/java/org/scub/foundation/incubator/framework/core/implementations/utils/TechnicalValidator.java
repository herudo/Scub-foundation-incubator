package org.scub.foundation.incubator.framework.core.implementations.utils;

import java.util.List;

import org.scub.foundation.framework.base.dto.AbstractDto;
import org.scub.foundation.framework.base.exception.TechnicalException;
import org.scub.foundation.framework.core.oval.validator.AbstractValidator;
import org.scub.foundation.framework.core.oval.validator.ConstraintViolationInformation;
import org.springframework.context.NoSuchMessageException;

/**
 * Oval validator which trhows TechnicalException when constraints failed.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public class TechnicalValidator extends AbstractValidator {

    /**
     * Validate the given dto. Throw a BusinessException if a constraint failed.
     * @param object the dto to validate
     * @param <T> .
     */
    @Override
    public <T extends AbstractDto>void validateDto(T object) {
        validateDto(object, (String[]) null);
    }

    /**
     * Validate the given dto. Throw a BusinessException if a constraint failed.
     * @param object the dto to validate
     * @param profiles the profiles list
     * @param <T> .
     */
    @Override
    public <T extends AbstractDto>void validateDto(T object, String[] profiles) {
        assertObjectToValidateNotNull(object);
        final List<ConstraintViolationInformation> violations = validateObject(object);

        if (violations.size() > 0) {
            throw new TechnicalException(violations.get(0).getErrorMessage());
        }
    }

    /**
     * Validate the given dto. Throw a BusinessException if a constraint failed.
     * @param objects the dtos to validate
     */
    @Override
    public void validateDto(List<? extends AbstractDto> objects) {
        validateDto(objects, (String[]) null);
    }

    /**
     * Validate the given dto. Throw a BusinessException if a constraint failed.
     * @param objects the dtos to validate
     * @param profiles the profiles list
     */
    @Override
    public void validateDto(List<? extends AbstractDto> objects, String[] profiles) {
        for (AbstractDto object : objects) {
            validateDto(object);
        }
    }

    /**
     * Throw a TechnicalException.
     * @param message the exception message.
     */
    public void fail(String message) {
        try {
            throw new TechnicalException(messageSourceUtil.get(message));
        } catch (NoSuchMessageException e) {
            throw new TechnicalException(message);
        }
    }

}
