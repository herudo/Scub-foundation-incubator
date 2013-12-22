/*
    This file is part of Scub Foundation.
    Copyright (C) 2006-2013  SCUB

    Scub Foundation is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Scub Foundation is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Scub Foundation.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.scub.foundation.incubator.framework.core.implementations.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.oval.Check;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.OValContext;
import net.sf.oval.internal.ClassChecks;
import net.sf.oval.internal.ContextCache;
import net.sf.oval.internal.util.Assert;
import net.sf.oval.internal.util.IdentitySet;
import net.sf.oval.internal.util.ReflectionUtils;

import org.scub.foundation.framework.base.dto.AbstractDto;
import org.scub.foundation.framework.base.exception.BusinessException;
import org.scub.foundation.framework.base.exception.TechnicalException;
import org.scub.foundation.framework.base.messagesource.MessageSourceUtil;
import org.scub.foundation.framework.base.oval.constraint.EachObjectValidCheck;
import org.scub.foundation.framework.core.oval.validator.ConstraintViolationInformation;
import org.springframework.context.NoSuchMessageException;

/**
 * Abstract class for validators. Provided some assertion and validation methods.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public abstract class AbstractValidator extends Validator {

    /** Message source util to get message by key. */
    protected MessageSourceUtil messageSourceUtil;

    /** Error when validated object is null. */
    protected static final String ERROR_OBJECT_NULL = "Validated object must not be null.";

    /** Violation informations. */
    protected List<ConstraintViolationInformation> violationsInformations;

    private static final String DOT = ".";

    /**
     * Validates the object parameter.
     * @param object the dto to validate
     * @param <T> .
     */
    public abstract <T extends AbstractDto>void validateDto(T object);

    /**
     * Validates the object parameter.
     * @param object the dto to validate
     * @param profiles the profiles list
     * @param <T> .
     */
    public abstract <T extends AbstractDto>void validateDto(T object, String[] profiles);

    /**
     * Validates all objects in the parameter list.
     * @param object the dto to validate
     */
    public abstract void validateDto(List<? extends AbstractDto> object);

    /**
     * validates all objects in the parameter list.
     * @param object the dto to validate
     * @param profiles the profiles list
     */
    public abstract void validateDto(List<? extends AbstractDto> object, String[] profiles);

    /**
     * Valide the given object.
     * @param object the object to be validate.
     * @return the list of failed constraint violation informations
     */
    public List<ConstraintViolationInformation> validateObject(Object object) {
        return validateObject(object, (String[]) null);
    }

    /**
     * Valide the given object.
     * @param object the object to be validate.
     * @param profiles the profiles list
     * @return the list of failed constraint violation informations
     */
    public List<ConstraintViolationInformation> validateObject(Object object, String[] profiles) {
        Assert.argumentNotNull("validatedObject", object);

        // create required objects for this validation cycle
        violationsInformations = new ArrayList<ConstraintViolationInformation>();
        final List<ConstraintViolation> violations = getCollectionFactory().createList();
        currentViolations.get().add(violations);
        currentlyValidatedObjects.get().add(new IdentitySet<Object>(4));

        try {
            return validateObject(object, object.getClass(), violations, profiles, "", new ArrayList<Class<?>>());
        } finally {
            // remove the validation cycle related objects
            currentViolations.get().removeLast();
            currentlyValidatedObjects.get().removeLast();
        }
    }

    /**
     * validates the field and getter constrains of the given object. if the given object is a class the static fields and getters are validated.
     * @param validatedObject the object to validate, cannot be null
     * @param clazz the class for validateObject
     * @param violations the constraints violations list
     * @param profiles the profiles array
     * @param attributePrefix the attribute prefix for the attribute name constraint failed construction
     * @param clazzHierarchy the class list hierarchy in case of nested Collection validation
     * @return the list of failed constraint violation informations
     */
    protected List<ConstraintViolationInformation> validateObject(final Object validatedObject, final Class<?> clazz,
        final List<ConstraintViolation> violations, final String[] profiles, String attributePrefix, List<Class<?>> clazzHierarchy) {
        assert validatedObject != null;
        assert clazz != null;
        assert violations != null;

        // abort if the root class has been reached
        if (clazz == Object.class) {
            return null;
        }
        currentlyValidatedObjects.get().getLast().add(validatedObject);

        final ClassChecks classCheck = getClassChecks(clazz);

        // validate field constraints
        for (final Field field : classCheck.constrainedFields) {
            final Collection<Check> checks = classCheck.checksForFields.get(field);

            if (checks != null && checks.size() > 0) {
                final Object valueToValidate = ReflectionUtils.getFieldValue(field, validatedObject);
                final OValContext ctx = ContextCache.getFieldContext(field);

                for (final Check check : checks) { // for all field checks
                    if (check instanceof EachObjectValidCheck && valueToValidate instanceof List<?>) {
                        // validate each object in the Collection
                        final List<?> collectionToValidate = (List<?>) valueToValidate;
                        final List<Class<?>> nestedClazzHierarchy = new ArrayList<Class<?>>();
                        nestedClazzHierarchy.addAll(clazzHierarchy);
                        int i = 0;
                        for (Object object : collectionToValidate) {
                            if (i == 0) {
                                nestedClazzHierarchy.add(object.getClass());
                            }
                            // construction of the nested attribut prefix
                            String nestedAttributePrefix = attributePrefix.isEmpty() ? "" : attributePrefix + DOT;
                            nestedAttributePrefix += getAttributName(field) + ".[[" + i + "]]";

                            validateObject(object, object.getClass(), violations, profiles, nestedAttributePrefix, nestedClazzHierarchy);
                            i++;
                        }
                    } else {
                        final List<ConstraintViolation> localViolations = new ArrayList<ConstraintViolation>();
                        checkConstraint(localViolations, check, validatedObject, valueToValidate, ctx, profiles, false, false);
                        constraintViolationsManagement(localViolations, violations, check.getTarget(), attributePrefix, clazzHierarchy);
                    }
                }
            }
        }

        // validate constraints on getter methods
        for (final Method getter : classCheck.constrainedMethods) {
            final Collection<Check> checks = classCheck.checksForMethodReturnValues.get(getter);

            if (checks != null && checks.size() > 0) {
                final Object valueToValidate = ReflectionUtils.invokeMethod(getter, validatedObject);
                final OValContext ctx = ContextCache.getMethodReturnValueContext(getter);

                for (final Check check : checks) {
                    final List<ConstraintViolation> localViolations = new ArrayList<ConstraintViolation>();
                    checkConstraint(localViolations, check, validatedObject, valueToValidate, ctx, profiles, false, false);
                    constraintViolationsManagement(localViolations, violations, check.getTarget(), attributePrefix, clazzHierarchy);
                }
            }
        }

        // validate object constraints
        if (classCheck.checksForObject.size() > 0) {
            final OValContext ctx = ContextCache.getClassContext(clazz);
            for (final Check check : classCheck.checksForObject) {
                final List<ConstraintViolation> localViolations = new ArrayList<ConstraintViolation>();
                checkConstraint(localViolations, check, validatedObject, validatedObject, ctx, profiles, false, false);
                constraintViolationsManagement(localViolations, violations, check.getTarget(), attributePrefix, clazzHierarchy);
            }
        }

        // if the super class is annotated to be validatable also validate it against the object
        validateObject(validatedObject, clazz.getSuperclass(), violations, profiles, attributePrefix, clazzHierarchy);

        return violationsInformations;
    }

    /**
     * Manage the constraints violations for validateObject.
     * @param localViolations the local constrainte violations
     * @param violations the global constraints violations
     * @param target the target for the check constrainte.
     * @param attributePrefix the attribute prefix for the attribute name constraint failed construction
     * @param clazz the class for the attribute name constraint failed construction
     */
    private void constraintViolationsManagement(List<ConstraintViolation> localViolations, List<ConstraintViolation> violations, String target,
        String attributePrefix, List<Class<?>> clazz) {
        String realAttributePrefix = attributePrefix;
        if (!realAttributePrefix.isEmpty()) {
            if (!realAttributePrefix.endsWith(DOT)) {
                realAttributePrefix += DOT;
            }
        }
        if (localViolations.size() > 0) { // if there is constraint violations
            for (ConstraintViolation constraintViolation : localViolations) {
                // create the constraints violations informations
                String attributeName = "";
                String message = "";
                if (realAttributePrefix.isEmpty()) {
                    attributeName = getFailedAttributName(constraintViolation, target, null);
                    message = getMessage(constraintViolation, target, null, null);
                } else {
                    realAttributePrefix = getAttributeWithoutBase(realAttributePrefix, clazz);
                    attributeName = replaceFlag(realAttributePrefix, null) + getFailedAttributName(constraintViolation, target, clazz);
                    message = getMessage(constraintViolation, target, replaceFlag(getAttributeWithoutBase(attributePrefix, clazz), "*"), clazz);
                }
                violationsInformations.add(new ConstraintViolationInformation(attributeName, message));
            }
            violations.addAll(localViolations);
        }
    }

    /**
     * Validate than the object to validate is not null.
     * @param object th object to validate.
     */
    protected void assertObjectToValidateNotNull(Object object) {
        if (object == null) {
            throw new TechnicalException(ERROR_OBJECT_NULL);
        }
    }

    /**
     * Get the message to throw the exception.
     * @param constraintViolation the failed constraint.
     * @param target the target for nested validations
     * @param attributePrefix the attribute prefix if it's a nested collection validation
     * @param clazz the validated object class if it's a nested collection validation
     * @return The message for the exception
     */
    public String getMessage(ConstraintViolation constraintViolation, String target, String attributePrefix, List<Class<?>> clazz) {
        // construction of the message key
        String messageKey = getFailedAttributName(constraintViolation, target, clazz);
        messageKey += constraintViolation.getErrorCode().replaceFirst("net.sf.oval.constraint", "");

        if (attributePrefix != null) {
            messageKey = attributePrefix + DOT + messageKey;
        }

        String message = "";

        try {
            message = messageSourceUtil.get(messageKey);
        } catch (NoSuchMessageException e) {
            try {
                message = messageSourceUtil.get(constraintViolation.getMessage());
            } catch (NoSuchMessageException e2) {
                message = constraintViolation.getMessage();
            }
        }

        return message;
    }

    /**
     * replaces all occurrences of numbers in double brackets by the replacement string if it is not null. If it is null, the occurrences will be replaced by
     * the number without the brackets.
     * @param str the str to replace occurences
     * @param replacement the remplacement string could be null
     * @return the str with all occurences replaced.
     */
    protected String replaceFlag(String str, String replacement) {
        final Pattern patt = Pattern.compile(".*\\[\\[([0-9]+)\\]\\].*");
        String returnValue = str;
        while (true) {
            final Matcher matcher = patt.matcher(returnValue);
            if (matcher.matches()) {
                returnValue = returnValue.replace("[[" + matcher.group(1) + "]]", replacement == null ? matcher.group(1) : replacement);
            } else { // no match, end of loop
                break;
            }
        }
        return returnValue;
    }

    /**
     * Get the attribut name with it's class name and package which failed for the given constraint violation.
     * @param constraintViolation the constraint violation
     * @param target the target for nested validations
     * @param clazz the validated object class if it's a nested collection validation
     * @return the atribut name (package.class.attributName)
     */
    protected String getFailedAttributName(ConstraintViolation constraintViolation, String target, List<Class<?>> clazz) {
        String attributeName = getAttributName(((FieldContext) constraintViolation.getCheckDeclaringContext()).getField());
        attributeName = getAttributeWithoutBase(attributeName, clazz);

        if (target != null && !target.isEmpty()) {
            attributeName += DOT + target;
        }

        return attributeName;
    }

    /**
     * Get the attribut name with it's class name and package for the given field.
     * @param field the field
     * @return the atribut name (package.class.attributName)
     */
    protected String getAttributName(Field field) {
        return field.getDeclaringClass().getSimpleName() + DOT + field.getName();
    }

    /**
     * retrieves the attribute error after removing the package and class name corresponding.
     * @param attribute the attribute in error.
     * @param clazz the class object list of the validated object.
     * @return the attirbute name
     */
    protected String getAttributeWithoutBase(String attribute, List<Class<?>> clazz) {
        String returnedAttribute = attribute;
        if (clazz != null) {
            for (Class<?> classToReplace : clazz) {
                returnedAttribute = getAttributeWithoutBase(returnedAttribute, classToReplace);
            }
        }
        return returnedAttribute;
    }

    /**
     * retrieves the attribute error after removing the package and class name corresponding.
     * @param attribute the attribute in error.
     * @param clazz the class object of the validated object.
     * @return the attirbute name
     */
    protected String getAttributeWithoutBase(String attribute, Class<?> clazz) {
        return attribute.replace(clazz.getSimpleName() + DOT, "");
    }

    /**
     * Asserts that two objects are equal. If they are not, a BusinessException is thrown with the given message. If expected and actual are null, they are
     * considered equal.
     * @param message the identifying message for the BusinessException
     * @param expected expected value
     * @param actual actual value
     */
    public void assertEquals(String message, Object expected, Object actual) {
        if (expected == null && actual == null) {
            return;
        }
        if (expected != null && isEquals(expected, actual)) {
            return;
        }

        fail(message);
    }

    /**
     * Asserts that two objects do not refer to the same object. If they do refer to the same object, a BusinessException is thrown with the given message.
     * @param message the identifying message for the BusinessException
     * @param unexpected the object you don't expect
     * @param actual the object to compare to unexpected
     */
    public void assertNotSame(String message, Object unexpected, Object actual) {
        if (unexpected == actual) {
            fail(message);
        }
    }

    /**
     * Asserts that an object is null. If it is not, a BusinessException is thrown with the given message.
     * @param message the identifying message for the BusinessException
     * @param object Object to check or null
     * @param <Obj> the object to test
     * @return the given object
     */
    public <Obj>Obj assertNull(String message, Obj object) {
        if (object != null) {
            fail(message);
        }
        return object;
    }

    /**
     * Asserts that an object is not null. If it is , a BusinessException is thrown with the given message.
     * @param message the identifying message for the BusinessException
     * @param object Object to check or null
     * @param <Obj> the object to test
     * @return the given object
     */
    public <Obj>Obj assertNotNull(String message, Obj object) {
        if (object == null) {
            fail(message);
        }
        return object;
    }

    /**
     * Asserts that a condition is false. If it isn't it throws a BusinessException with the given message.
     * @param message the identifying message for the BusinessException
     * @param condition condition to be checked
     */
    public void assertTrue(String message, boolean condition) {
        if (!condition) {
            fail(message);
        }
    }

    /**
     * Asserts that a condition is false. If it isn't it throws a BusinessException with the given message.
     * @param message the identifying message for the BusinessException
     * @param condition condition to be checked
     */
    public void assertFalse(final String message, boolean condition) {
        if (condition) {
            fail(message);
        }
    }

    /**
     * Throw a BusinessException.
     * @param message the exception message.
     */
    public void fail(String message) {
        try {
            throw new BusinessException(messageSourceUtil.get(message));
        } catch (NoSuchMessageException e) {
            throw new BusinessException(message);
        }
    }

    /**
     * Test if the two object are equals.
     * @param expected expected value
     * @param actual actual value
     * @return true if two object are equals false overise.
     */
    private boolean isEquals(Object expected, Object actual) {
        return expected.equals(actual);
    }

    /**
     * Set the value of messageSourceUtil.
     * @param messageSourceUtil the messageSourceUtil to set
     */
    public void setMessageSourceUtil(MessageSourceUtil messageSourceUtil) {
        this.messageSourceUtil = messageSourceUtil;
    }
}
