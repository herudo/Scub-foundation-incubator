package scub.foundation.incubator.gwt.module.gwt.client.test;

import java.util.ArrayList;
import java.util.List;

import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.RemotePagingTable;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.RemotePagingTableCell;
import scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging.RemotePagingTableRow;
import scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.IntegerSearchCriterionBox;
import scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.handlers.HasIntegerSearchCriterion;
import scub.foundation.incubator.gwt.module.gwt.client.test.NumberSearchPresenter.NumberValueSearchView;
import scub.foundation.incubator.gwt.module.gwt.client.view.AbstractSearchViewImpl;
import scub.foundation.incubator.gwt.module.gwt.shared.test.NumberValueModel;

import com.github.gwtbootstrap.client.ui.base.InlineLabel;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * NumberSearchViewImpl
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class NumberSearchViewImpl extends AbstractSearchViewImpl<NumberValueModel, Void> implements NumberValueSearchView {

    private IntegerSearchCriterionBox integerSearchCriterion = new IntegerSearchCriterionBox();

    /**
     * Constructor.
     * @param remotePagingTable
     */
    public NumberSearchViewImpl() {
        super(new RemotePagingTable<NumberValueModel, Void>(10) {
            @Override
            public RemotePagingTableRow<Void> rowRender(NumberValueModel rowData, int rowNumber) {
                final List<RemotePagingTableCell> cells = new ArrayList<RemotePagingTableCell>();
                if (rowData != null) {
                    cells.add(new RemotePagingTableCell(true, new InlineLabel(rowData.getIntValue() != null ? rowData.getIntValue().toString() : "")));
                }

                return new RemotePagingTableRow<Void>(cells);
            }
        });
    }

    @Override
    public void clearSearch() {
        integerSearchCriterion.clear();
    }

    @Override
    public HasIntegerSearchCriterion getIntegerSearchCriterion() {
        return integerSearchCriterion;
    }

    @Override
    public void initSearchFormFields(FocusPanel container) {
        if (container != null) {
            container.add(integerSearchCriterion);
        }
    }

}
