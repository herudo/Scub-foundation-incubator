package scub.foundation.incubator.gwt.module.gwt.client.bundle;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;

/**
 * Interface for the resources.
 * @author Raphaël MARNIER (raphael.marnier@scub.net)
 */
public interface ScubFoundationIncubatorResources extends ClientBundle {

    /**
     * scub foundation incubator global css.
     * @return the css.
     */
    @Source("scub/foundation/incubator/gwt/module/gwt/public/styles/scub-foundation-incubator.css")
    @NotStrict
    ScubFoundationIncubatorCss css();

    /**
     * remote paging Loader.
     * @return l'image
     */
    @Source("scub/foundation/incubator/gwt/module/gwt/public/images/remote-paging-loader.gif")
    ImageResource remotePagingLoader();
}
