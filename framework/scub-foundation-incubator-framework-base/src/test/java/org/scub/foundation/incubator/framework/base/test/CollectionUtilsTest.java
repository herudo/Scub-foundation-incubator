package org.scub.foundation.incubator.framework.base.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.scub.foundation.incubator.framework.base.utils.ListUtils;
import org.scub.foundation.incubator.framework.base.utils.SetUtils;
import org.scub.foundation.incubator.framework.test.abstractCase.AbstractSpringBaseTestCase;

/**
 * List utils test.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class CollectionUtilsTest extends AbstractSpringBaseTestCase {

    private static final String COLLECTION_IS_EMPTY = "The collection is empty.";

    private static final String COLLECTION_IS_NOT_EMPTY = "The collection is not empty.";

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
        assertTrue(COLLECTION_IS_EMPTY, ListUtils.isEmpty(null));
        assertTrue(COLLECTION_IS_EMPTY, ListUtils.isEmpty(new ArrayList<String>()));
        final List<String> list = new ArrayList<String>();
        list.add("");
        assertFalse(COLLECTION_IS_NOT_EMPTY, ListUtils.isEmpty(list));

        assertTrue(COLLECTION_IS_EMPTY, SetUtils.isEmpty(null));
        assertTrue(COLLECTION_IS_EMPTY, SetUtils.isEmpty(new HashSet<String>()));
        final Set<String> set = new HashSet<String>();
        set.add("");
        assertFalse(COLLECTION_IS_NOT_EMPTY, SetUtils.isEmpty(set));
    }

    /**
     * Test the is not empty methods.
     */
    @Test
    public void testIsNotEmpty() {
        assertFalse(COLLECTION_IS_EMPTY, ListUtils.isNotEmpty(null));
        assertFalse(COLLECTION_IS_EMPTY, ListUtils.isNotEmpty(new ArrayList<String>()));
        final List<String> collection = new ArrayList<String>();
        collection.add("");
        assertTrue(COLLECTION_IS_NOT_EMPTY, ListUtils.isNotEmpty(collection));

        assertFalse(COLLECTION_IS_EMPTY, SetUtils.isNotEmpty(null));
        assertFalse(COLLECTION_IS_EMPTY, SetUtils.isNotEmpty(new HashSet<String>()));
        final Set<String> set = new HashSet<String>();
        set.add("");
        assertTrue(COLLECTION_IS_NOT_EMPTY, SetUtils.isNotEmpty(set));
    }

}
