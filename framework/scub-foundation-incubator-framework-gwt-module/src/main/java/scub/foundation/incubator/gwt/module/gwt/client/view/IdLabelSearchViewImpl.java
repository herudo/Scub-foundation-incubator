package scub.foundation.incubator.gwt.module.gwt.client.view;

import java.util.ArrayList;
import java.util.List;

import org.scub.foundation.framework.gwt.module.shared.IdLabelModel;

import scub.foundation.incubator.gwt.module.gwt.client.components.handlers.HasCalculatedWidth.Width;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.HasRemotePagingTableHandlers;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.RemotePagingTable;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.RemotePagingTableCell;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.RemotePagingTableRow;
import scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.StringSearchCriterionBox;
import scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.handlers.HasStringSearchCriterion;
import scub.foundation.incubator.gwt.module.gwt.client.factory.AppClientFactory;
import scub.foundation.incubator.gwt.module.gwt.client.presenter.AbstractIdLabelSearchPresenter.IdLabelSearchView;

import com.github.gwtbootstrap.client.ui.base.InlineLabel;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyPressHandlers;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RequiresResize;

/**
 * Implementation of an idLabel search view.
 * @param <ResultType> the type in the results list.
 * @param <RowHandlerType> the returned type for RemotePagingTableRow, used to attach handler to widget displayed in the row. Use Void if you don't need to
 *            attach something.²
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class IdLabelSearchViewImpl<ResultType extends IdLabelModel, RowHandlerType> extends AbstractSearchViewImpl<ResultType, RowHandlerType> implements
        IdLabelSearchView<ResultType, RowHandlerType>, RequiresResize {

    private StringSearchCriterionBox labelCriterion;

    /**
     * Constructor.
     * @param remotePagingTable
     */
    public IdLabelSearchViewImpl() {
        super(new RemotePagingTable<ResultType, RowHandlerType>(10) { // TODO taille du remote pagging

                @Override
                public RemotePagingTableRow<RowHandlerType> rowRender(ResultType rowData, int rowNumber) {
                    final List<RemotePagingTableCell> cells = new ArrayList<RemotePagingTableCell>();
                    if (rowData != null) {
                        cells.add(new RemotePagingTableCell(true, new InlineLabel(rowData.getLabel() != null ? rowData.getLabel() : "")));
                    }

                    return new RemotePagingTableRow<RowHandlerType>(cells);
                }
            });
    }

    @Override
    public void initSearchFormFields(FocusPanel container) {
        if (container != null) {
            labelCriterion = new StringSearchCriterionBox();
            labelCriterion.setPlaceHolder(AppClientFactory.getMessages().yourSearch());
            container.add(labelCriterion);
            container.addStyleName(AppClientFactory.getResources().css().alignCenter());
        }
    }

    @Override
    public void clearSearch() {
        labelCriterion.clear();
    }

    @Override
    public HasStringSearchCriterion getLabel() {
        return labelCriterion;
    }

    @Override
    public void onResize() {
        // TODO regarder pour providesResize
        resize();
    }

    @Override
    public void resize() {
        labelCriterion.setCalculatedWidth(Width.CENT_PERCENT);
    }
}
