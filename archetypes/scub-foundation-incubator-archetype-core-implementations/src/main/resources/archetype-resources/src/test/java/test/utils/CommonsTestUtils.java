package ${package}.test.utils;

import org.junit.Before;
import org.scub.foundation.incubator.framework.test.abstractCase.AbstractDbunitBaseTestCase;

import ${package}.utils.ErrorMessages;

/**
 * Commons utils for tests.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class CommonsTestUtils extends AbstractDbunitBaseTestCase {
    /** error messages. */
    protected ErrorMessages errorMessages;

    /** init. */
    @Before
    public void initCommons() {
        errorMessages = (ErrorMessages) getBeanSpring("errorMessages");
    }

    /**
     * Constants.
     * @author Adrien HAUTOT (contact@adrienhautot.fr)
     */
    public static class Const extends org.scub.foundation.incubator.framework.test.Constants {

    }

    @Override
    public String[] getContextFiles() {
        return new String[] {"applicationContext.xml", "securiteServiceContext.xml", "securiteServiceSpecContext.xml", "rmiServiceImporterMockContext.xml",
            "attributesMappingContext.xml"};

    }
}
