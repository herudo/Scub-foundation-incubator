package scub.foundation.incubator.gwt.module.gwt.client.components.remotePaging;

import com.github.gwtbootstrap.client.ui.Icon;
import com.github.gwtbootstrap.client.ui.base.InlineLabel;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * Header for remote paging table.
 * @author Adrien HAUTOT (adrien.hautot@scub.net)
 */
public class RemotePagingTableHeader extends FocusPanel {

    private boolean isClickedEventAttached;

    private String columnName;

    private Boolean ascending;

    private Icon icon;

    /**
     * Constructor.
     * @param label the header label.
     * @param columnName the column name for sort.
     */
    public RemotePagingTableHeader(String label, String columnName) {
        this(label, columnName, null);
    }

    /**
     * Constructor.
     * @param label the header label.
     * @param columnName the column name for sort.
     * @param defaultSortAscending the sort type. null = no sort; true = ASC, false = DESC
     */
    public RemotePagingTableHeader(String label, String columnName, Boolean defaultSortAscending) {
        super();
        this.columnName = columnName;
        this.ascending = defaultSortAscending;

        addStyleName("remotePagingTableHeader");
        getElement().getStyle().setProperty("outline", "none");

        icon = new Icon(IconType.CHEVRON_DOWN);
        icon.getElement().getStyle().setMarginLeft(5, Unit.PX);
        if (ascending != null) {
            if (!ascending) {
                icon.setType(IconType.CHEVRON_UP);
            }
        } else {
            icon.getElement().getStyle().setVisibility(Visibility.HIDDEN);
        }

        final HorizontalPanel panel = new HorizontalPanel();
        panel.add(new InlineLabel(label));
        panel.add(icon);
        add(panel);

        addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                // refresh sort.
                if (ascending == null || !ascending) {
                    setAscending(true);
                } else {
                    setAscending(false);
                }
            }
        });
    }

    /**
     * Get the value of columnName.
     * @return the columnName
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * Get the value of ascending.
     * @return the ascending
     */
    public Boolean getAscending() {
        return ascending;
    }

    /**
     * Set the value of ascending.
     * @param ascending the ascending to set
     */
    public void setAscending(Boolean ascending) {
        this.ascending = ascending;
        if (ascending == null) {
            icon.getElement().getStyle().setVisibility(Visibility.HIDDEN);
        } else if (ascending) {
            icon.setType(IconType.CHEVRON_DOWN);
            icon.getElement().getStyle().setVisibility(Visibility.VISIBLE);
        } else {
            icon.setType(IconType.CHEVRON_UP);
            icon.getElement().getStyle().setVisibility(Visibility.VISIBLE);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((columnName == null) ? 0 : columnName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RemotePagingTableHeader other = (RemotePagingTableHeader) obj;
        if (columnName == null) {
            if (other.columnName != null) {
                return false;
            }
        } else if (!columnName.equals(other.columnName)) {
            return false;
        }
        return true;
    }

    /**
     * Get the value of isClickedEventAttached.
     * @return the isClickedEventAttached
     */
    public boolean isClickedEventAttached() {
        return isClickedEventAttached;
    }

    /**
     * Set the value of isClickedEventAttached.
     * @param clickedEventAttached the isClickedEventAttached to set
     */
    public void setClickedEventAttached(boolean clickedEventAttached) {
        this.isClickedEventAttached = clickedEventAttached;
    }
}
