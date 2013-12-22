package ${package}.gwt.client.layout;

import ${package}.gwt.client.controller.AppLayout;
import ${package}.gwt.client.i18n.AppMessages;
import org.scub.foundation.framework.gwt.module.client.util.composants.layout.ConfigurableLayout;
import org.scub.foundation.framework.gwt.module.client.util.composants.layout.ConfigurableLayout.DynamicLayoutBreadcrumbs;
import org.scub.foundation.framework.gwt.module.client.util.composants.layout.ConfigurableLayout.DynamicLayoutContainer;
import org.scub.foundation.framework.gwt.module.client.util.composants.layout.ConfigurableLayout.DynamicLayoutMenu;

import ${package}.gwt.client.factory.AppClientFactory;

import com.github.gwtbootstrap.client.ui.Brand;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.Nav;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.Navbar;
import com.github.gwtbootstrap.client.ui.constants.Alignment;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Widget;

/**
 * Implementation of AppLayout.
 * @author Anthony GUILLEMETTE (anthony.guillemette@scub.net)
 */
public class AppLayoutImpl extends ConfigurableLayout implements AppLayout {

    private AppMessages messages = AppClientFactory.getMessages();

    /**
     * Default constructor.
     */
    public AppLayoutImpl() {
        super(Unit.EM, DynamicLayoutContainer.TABPANEL, DynamicLayoutMenu.LEFT, DynamicLayoutBreadcrumbs.TOP);
        this.setHeader(initHeader());

        initMenu();

        // tBreadcrumbs
        for (int i = 0; i < 5; i++) {
            this.getBreadcrumbs().add(new NavLink("Breadcrumbs " + i));
        }
        this.onResize();
    }

    private void initMenu() {
        final NavLink menuExample = new NavLink(messages.menu(), "#default");
        menuExample.setIcon(IconType.SEARCH);

        this.getMenu().add(menuExample);
    }

    private Widget initHeader() {
        final Brand brand = new Brand(messages.applicationTitle());
        final Button deconnexionButton = new Button(messages.logout(), IconType.SIGNOUT);
        deconnexionButton.setType(ButtonType.INVERSE);
        deconnexionButton.setHref(GWT.getModuleBaseURL() + "j_spring_security_logout");

        final Nav navDeconnexion = new Nav();
        navDeconnexion.add(deconnexionButton);
        navDeconnexion.setAlignment(Alignment.RIGHT);

        final Navbar navbar = new Navbar();
        navbar.add(brand);
        navbar.add(navDeconnexion);
        return navbar;
    }

    @Override
    public Widget asWidget() {
        return super.asWidget();
    }

    @Override
    public Widget getPrincipalContainer() {
        return super.asWidget();
    }
}
