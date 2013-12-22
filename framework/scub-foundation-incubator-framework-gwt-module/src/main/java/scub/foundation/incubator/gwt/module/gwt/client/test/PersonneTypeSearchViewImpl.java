package scub.foundation.incubator.gwt.module.gwt.client.test;

import org.scub.foundation.framework.gwt.module.shared.IdLabelModel;

import scub.foundation.incubator.gwt.module.gwt.client.test.PersonneTypeSearchPresenter.PersonneTypeSearchView;
import scub.foundation.incubator.gwt.module.gwt.client.view.IdLabelSearchViewImpl;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.event.dom.client.HasClickHandlers;

/**
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class PersonneTypeSearchViewImpl extends IdLabelSearchViewImpl<IdLabelModel, Void> implements PersonneTypeSearchView {

    private Button btn = new Button("Show/Hide options (example)");

    public PersonneTypeSearchViewImpl() {
        buttonsContainer.add(btn);
    }

    @Override
    public HasClickHandlers getOptionsClick() {
        return btn;
    }
}
