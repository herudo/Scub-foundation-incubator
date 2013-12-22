package scub.foundation.incubator.gwt.module.selenium.test;

import org.junit.Test;
import org.scub.foundation.framework.client.test.SeleniumTestCase;

/**
 * This is a simple test which will connect to the application.
 * @author Clément Lavaud (clement.lavaud@scub.net)
 */
public class ExampleIT extends SeleniumTestCase {

    @Test
    public void testExample() throws Exception {
        selenium.setSpeed("1500"); // the speed between each instruction in the test (in milliseconds)
        selenium.type("name=j_username", "user");
        selenium.type("name=j_password", "user");
        selenium.click("name=submit");
        selenium.waitForPageToLoad("30000");

        assertTrue(selenium.isTextPresent("Bravo"));
    }

}
