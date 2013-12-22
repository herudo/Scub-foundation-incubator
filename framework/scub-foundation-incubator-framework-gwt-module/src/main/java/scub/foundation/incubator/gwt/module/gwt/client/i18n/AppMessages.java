package scub.foundation.incubator.gwt.module.gwt.client.i18n;

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

    /* ############################ search view ########################### */

    /**
     * the clear saerch label.
     * @return the label.
     */
    String clearSearch();

    /**
     * the search label.
     * @return the label.
     */
    String search();

    /**
     * the search placeholder.
     * @return the placeholder.
     */
    String yourSearch();

    /* ############################ search criterion ########################### */

    /* ####### String search criterion ####### */
    /**
     * Description for case sensitive button.
     * @return the label.
     */
    String caseSensitiveDescription();

    /**
     * Description for case insensitive button.
     * @return the label.
     */
    String caseInsensitiveDescription();

    /* ===== operators ===== */
    /**
     * label for equals operator.
     * @return the label.
     */
    String equalsLabel();

    /**
     * label for different operator.
     * @return the label.
     */
    String differentLabel();

    /**
     * label for startsWith operator.
     * @return the label.
     */
    String startsWithLabel();

    /**
     * label for endsWidth operator.
     * @return the label.
     */
    String endsWidthLabel();

    /**
     * label for notStartsWith operator.
     * @return the label.
     */
    String notStartsWithLabel();

    /**
     * label for notEndsWith operator.
     * @return the label.
     */
    String notEndsWithLabel();

    /**
     * label for contains operator.
     * @return the label.
     */
    String containsLabel();

    /**
     * label for notContains operator.
     * @return the label.
     */
    String notContainsLabel();

    /**
     * label for isNull operator.
     * @return the label.
     */
    String isNullLabel();

    /**
     * label for isNotNull operator.
     * @return the label.
     */
    String isNotNullLabel();

    /* ===== descriptions ===== */
    /**
     * description for equals operator.
     * @return the description.
     */
    String equalsStringDescription();

    /**
     * description for different operator.
     * @return the description.
     */
    String differentStringDescription();

    /**
     * description for startsWith operator.
     * @return the description.
     */
    String startsWithStringDescription();

    /**
     * description for endsWidth operator.
     * @return the description.
     */
    String endsWidthStringDescription();

    /**
     * description for notStartsWith operator.
     * @return the description.
     */
    String notStartsWithStringDescription();

    /**
     * description for notEndsWith operator.
     * @return the description.
     */
    String notEndsWithStringDescription();

    /**
     * description for contains operator.
     * @return the description.
     */
    String containsStringDescription();

    /**
     * description for notContains operator.
     * @return the description.
     */
    String notContainsStringDescription();

    /**
     * description for isNull operator.
     * @return the description.
     */
    String isNullStringDescription();

    /**
     * description for isNotNull operator.
     * @return the description.
     */
    String isNotNullStringDescription();
}
