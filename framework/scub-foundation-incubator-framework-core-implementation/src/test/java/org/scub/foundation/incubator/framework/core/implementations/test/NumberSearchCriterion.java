package org.scub.foundation.incubator.framework.core.implementations.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.scub.foundation.incubator.framework.core.implementations.test.dao.interfaces.NumberValueDao;
import org.scub.foundation.incubator.framework.test.abstractCase.AbstractDbunitBaseTestCase;

/**
 * Abstract class for Number search criterion tests.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class NumberSearchCriterion extends AbstractDbunitBaseTestCase {
    /** Dao for number value. */
    protected NumberValueDao numberValueDao;

    /** init. */
    @Before
    public void init() {
        numberValueDao = (NumberValueDao) getBeanSpring("numberValueDao");
    }

    @Override
    public String[] getXmlDateSet() {
        return new String[] {"datasets/NumberSearchCriterion.dataset.xml"};
    }

    @Override
    public List<String> getContextFiles() {
        final List<String> contextFiles = new ArrayList<String>();
        contextFiles.add("testContext.xml");
        contextFiles.add("attributesMappingContext.xml");
        return contextFiles;
    }
}
