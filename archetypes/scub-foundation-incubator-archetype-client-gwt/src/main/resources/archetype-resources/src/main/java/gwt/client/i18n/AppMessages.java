package ${package}.gwt.client.i18n;

import com.google.gwt.i18n.client.Messages;

/**
 * Messages used throughout the application.
 * @author Anthony GUILLEMETTE (anthony.guillemette@scub.net)
 */
public interface AppMessages extends Messages {

    /**
     * Get the application title.
     * @return the title
     */
    String applicationTitle();

    /**
     * Get the logout message.
     * @return the message
     */
    String logout();

    /**
     * Get the default tab name.
     * @return the title
     */
    String defaultTab();

    /**
     * Get the menu title.
     * @return the title
     */
    String menu();

    /**
     * Get the message of congratulations.
     * @return the message
     */
    String messageCongratulations();

    /**
     * Get the call service text in the button.
     * @return the message.
     */
    String callServiceBtn();

    /**
     * Get the call service message in the result.
     * @return the message.
     */
    String callServiceResult();
}
