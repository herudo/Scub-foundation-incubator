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

import java.util.List;
import java.util.Map;

import org.scub.foundation.framework.base.dto.AbstractDto;
import org.scub.foundation.framework.base.dto.report.AttributeReportDto;
import org.scub.foundation.framework.base.dto.report.ReportDto;
import org.scub.foundation.framework.base.exception.IntegrityControlException;
import org.scub.foundation.framework.core.oval.validator.ConstraintViolationInformation;

/**
 * Oval validator which trhows IntegrityControleException when constraints failed.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public class IntegrityValidator extends AbstractValidator {

    /**
     * Validate the given dto. Throw an IntegrityControlException if a constraint failed.
     * @param object the dto to validate
     * @param <T> .
     */
    @Override
    public <T extends AbstractDto>void validateDto(T object) {
        validateDto(object, (String[]) null);
    }

    /**
     * Validate the given dto. Throw an IntegrityControlException if a constraint failed.
     * @param object the dto to validate
     * @param profiles the profiles list
     * @param <T> .
     */
    @Override
    public <T extends AbstractDto>void validateDto(T object, String[] profiles) {
        testReport(getReport(object, profiles));
    }

    /**
     * Validates all objects in the parameter list. Throw an IntegrityControlException if a constraint failed.
     * @param objects the dtos to validate
     */
    @Override
    public void validateDto(List<? extends AbstractDto> objects) {
        validateDto(objects, (String[]) null);
    }

    /**
     * Validates all objects in the parameter list. Throw an IntegrityControlException if a constraint failed.
     * @param objects the dtos to validate
     * @param profiles the profiles list
     */
    @Override
    public void validateDto(List<? extends AbstractDto> objects, String[] profiles) {
        testReport(getReport(objects, profiles));
    }

    /**
     * Test if the report has error. if error is detected, throw Integrity control exception.
     * @param report .
     */
    public void testReport(ReportDto report) {
        if (report.hasError()) {
            throw new IntegrityControlException(report);
        }
    }

    /**
     * Get the report for the given dto.
     * @param object the dto to validate
     * @return the generated report.
     */
    public ReportDto getReport(AbstractDto object) {
        return getReport(object, (String[]) null);
    }

    /**
     * Get the report for the given dto.
     * @param objects the dtos to validate
     * @return the generated report.
     */
    public ReportDto getReport(List<? extends AbstractDto> objects) {
        return getReport(objects, (String[]) null);
    }

    /**
     * Get the report for the given dto.
     * @param objects the dtos to validate
     * @return the generated report.
     */
    public ReportDto getReport(List<? extends AbstractDto> objects, String[] profiles) {
        final ReportDto totalReport = new ReportDto();
        int i = 0;
        for (AbstractDto object : objects) {
            final ReportDto report = getReport(object, profiles);

            // concatenation reports
            final Map<String, AttributeReportDto> attributesReports = report.getAttributesReports();
            for (String key : attributesReports.keySet()) {
                final AttributeReportDto attributeReport = attributesReports.get(key);
                totalReport.addAttributeReport(i + "." + getAttributeWithoutBase(key, object.getClass()), attributeReport);
            }
            i++;
        }
        return totalReport;
    }

    /**
     * Get the report for the given dto.
     * @param object the dto to validate
     * @param profiles the profiles list
     * @return the generated report.
     */
    public ReportDto getReport(AbstractDto object, String[] profiles) {
        assertObjectToValidateNotNull(object);
        final List<ConstraintViolationInformation> violationInformations = validateObject(object, profiles);

        final ReportDto report = new ReportDto();

        // create all subReport
        for (ConstraintViolationInformation constraintViolationInformation : violationInformations) {
            if (!report.hasAttributeReport(constraintViolationInformation.getAttributeName())) {
                report.addAttributeReport(constraintViolationInformation.getAttributeName());
            }
            report.getAttributeReport(constraintViolationInformation.getAttributeName()).addError(constraintViolationInformation.getErrorMessage());
        }

        return report;
    }
}
