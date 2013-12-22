package org.scub.foundation.incubator.framework.base.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.scub.foundation.incubator.framework.base.utils.ListUtils;
import org.scub.foundation.incubator.framework.test.abstractCase.AbstractSpringBaseTestCase;

/**
 * List utils test.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class ListUtilsTest extends AbstractSpringBaseTestCase {

    @Override
    public List<String> getContextFiles() {
        final List<String> contextFiles = new ArrayList<String>();
        contextFiles.add("testContext.xml");
        return contextFiles;
    }
    /**
     * Test the is empty methods.
     */
    @Test
    public void testIsEmpty() {
        assertTrue("The list is empty.", ListUtils.isEmpty(null));
        assertTrue("The list is empty.", ListUtils.isEmpty(new ArrayList<String>()));
        final List<String> list = new ArrayList<String>();
        list.add("");
        assertFalse("The list is not empty.", ListUtils.isEmpty(list));
    }

    /**
     * Test the is not empty methods.
     */
    @Test
    public void testIsNotEmpty() {
        assertFalse("The list is empty.", ListUtils.isNotEmpty(null));
        assertFalse("The list is empty.", ListUtils.isNotEmpty(new ArrayList<String>()));
        final List<String> list = new ArrayList<String>();
        list.add("");
        assertTrue("The list is not empty.", ListUtils.isNotEmpty(list));
    }

}
