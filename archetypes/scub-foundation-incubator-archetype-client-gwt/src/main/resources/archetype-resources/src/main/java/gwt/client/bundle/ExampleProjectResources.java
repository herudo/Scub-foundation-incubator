package ${package}.gwt.client.bundle;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource.NotStrict;

/**
 * Interface for the resources.
 * @author Raphaël MARNIER (raphael.marnier@scub.net)
 */
public interface ExampleProjectResources extends ClientBundle {

    /**
     * Contact manager's css.
     * @return the css.
     */
    @Source("${publicFolderPathForBundle_This_is_the_package_variable_or_points_are_replaced_by_slash}/gwt/public/styles/style.css")
    @NotStrict
    ExampleProjectCss css();
}
