package scub.foundation.incubator.gwt.module.gwt.client.components.dropDownButton;

import com.google.gwt.user.client.ui.HasText;

//@formatter:off
/**
 * ====> copy of the class in the incubator porject in order to fix the bug in the setCustomIconStyle metho in the IconAnchor class
 * 
 * Link, used in a navigation context.
 * 
 * <p>
 * <h3>UiBinder Usage:</h3>
 * 
 * <pre>
 * {@code
 * <b:NavList>
 *     <b:NavHeader>I'm the Header</b:NavHeader>
 *     <b:NavLink icon="PLANE">I'm a link to nowhere.</b:NavLink>
 * </b:NavList>
 * }
 * </pre>
 * All arguments are optional
 * </p>
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * @author ohashi keisuke
 * 
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navbar">Bootstrap documentation (Navbar)</a>
 * @see <a href="http://twitter.github.com/bootstrap/components.html#navs">Bootstrap documentation (Navs)</a>
 * @see NavList
 * @see WellNavList
 * @see Dropdown
 * @see Navbar
 * @see ResponsiveNavbar
 */
//@formatter:on
public class NavLink extends NavWidget implements HasText {

    /**
     * Creates an empty widget.
     */
    public NavLink() {
        super();
    }

    /**
     * Creates an empty widget of given text.
     * 
     * @param text
     *            text of the widget
     */
    public NavLink(String text) {
        super();
        setText(text);
    }

    /**
     * Creates an empty widget of given text and href.
     * 
     * @param text
     *            text of the widget
     * @param href
     *            URL the link should point to
     */
    public NavLink(String text, String href) {
        super();
        setText(text);
        setHref(href);
    }
}
