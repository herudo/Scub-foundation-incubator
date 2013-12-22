package org.scub.foundation.incubator.framework.base.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.scub.foundation.incubator.framework.base.utils.SetUtils;
import org.scub.foundation.incubator.framework.test.abstractCase.AbstractSpringBaseTestCase;

/**
 * Set utils test.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class SetUtilsTest extends AbstractSpringBaseTestCase {

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
        assertTrue("The set is empty.", SetUtils.isEmpty(null));
        assertTrue("The set is empty.", SetUtils.isEmpty(new HashSet<String>()));
        final Set<String> set = new HashSet<String>();
        set.add("");
        assertFalse("The set is not empty.", SetUtils.isEmpty(set));
    }

    /**
     * Test the is not empty methods.
     */
    @Test
    public void testIsNotEmpty() {
        assertFalse("The set is empty.", SetUtils.isNotEmpty(null));
        assertFalse("The set is empty.", SetUtils.isNotEmpty(new HashSet<String>()));
        final Set<String> set = new HashSet<String>();
        set.add("");
        assertTrue("The set is not empty.", SetUtils.isNotEmpty(set));
    }

}
