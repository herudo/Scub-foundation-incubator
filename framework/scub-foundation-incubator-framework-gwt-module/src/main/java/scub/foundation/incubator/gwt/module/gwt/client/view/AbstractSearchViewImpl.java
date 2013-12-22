package scub.foundation.incubator.gwt.module.gwt.client.view;

import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.RemotePagingTable;
import scub.foundation.incubator.gwt.module.gwt.client.factory.AppClientFactory;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.InputAddOn;
import com.github.gwtbootstrap.client.ui.base.DivWidget;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Abstract view utilies for search utilisation.
 * @param <ResultType> the type in the results list.
 * @param <RowHandlerType> the returned type for RemotePagingTableRow, used to attach handler to widget displayed in the row. Use Void if you don't need to
 *            attach something.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public abstract class AbstractSearchViewImpl<ResultType, RowHandlerType> extends Composite {

    /** the search button. */
    protected Button searchBtn;

    /** the click button. */
    protected Button clearBtn;

    /** principal container. */
    protected VerticalPanel principalContainer;

    /** Container for the searchs criterions (search form fields). */
    protected FocusPanel searchCriterionContainer;

    /** the buttons container. */
    protected DivWidget buttonsContainer;

    /** the results container. */
    protected RemotePagingTable<ResultType, RowHandlerType> resultsContainer;

    /**
     * Constructor.
     * @param remotePagingTable the results container.
     */
    public AbstractSearchViewImpl(RemotePagingTable<ResultType, RowHandlerType> remotePagingTable) {
        resultsContainer = remotePagingTable;

        // create elements
        principalContainer = new VerticalPanel();
        principalContainer.addStyleName(AppClientFactory.getResources().css().width100Percent());
        searchCriterionContainer = new FocusPanel();
        buttonsContainer = new DivWidget();
        buttonsContainer.addStyleName(AppClientFactory.getResources().css().alignCenter());
        buttonsContainer.addStyleName(AppClientFactory.getResources().css().margin10());
        searchBtn = new Button(AppClientFactory.getMessages().search(), IconType.SEARCH);
        clearBtn = new Button(AppClientFactory.getMessages().clearSearch(), IconType.TRASH);
        final InputAddOn addOn = new InputAddOn();

        searchCriterionContainer.addStyleName(AppClientFactory.getResources().css().outlineNone());

        // add elements in others
        addOn.add(searchBtn);
        addOn.add(clearBtn);
        buttonsContainer.add(addOn);
        principalContainer.add(searchCriterionContainer);
        principalContainer.add(buttonsContainer);
        principalContainer.add(resultsContainer);

        // init view
        initWidget(principalContainer);
        initSearchFormFields(searchCriterionContainer);
    }

    /**
     * init the search for fields and set its in the given container.
     * @param container the container for search form fields.
     */
    public abstract void initSearchFormFields(FocusPanel container);
}
