package scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.operatorButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scub.foundation.incubator.gwt.module.gwt.client.factory.AppClientFactory;
import scub.foundation.incubator.gwt.module.gwt.client.i18n.AppMessages;
import scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion.StringSearchCriterionModel.StringOperator;

/**
 * An operator button for the string search criterion.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class StringOperatorButton extends AbstractOperatorButton<StringOperator> {

    /**
     * Constructor.
     * @param value the value.
     */
    public StringOperatorButton(StringOperator value) {
        final List<StringOperator> operators = new ArrayList<StringOperator>();
        operators.add(StringOperator.EQUALS);
        operators.add(StringOperator.DIFFERENTS);
        operators.add(StringOperator.STARTS_WITH);
        operators.add(StringOperator.ENDS_WITH);
        operators.add(StringOperator.CONTAINS);
        operators.add(StringOperator.IS_NULL);
        operators.add(StringOperator.NOT_STARTS_WITH);
        operators.add(StringOperator.NOT_ENDS_WITH);
        operators.add(StringOperator.NOT_CONTAINS);
        operators.add(StringOperator.IS_NOT_NULL);
        setPossibleOperators(operators);
        setValue(value);
    }

    @Override
    Map<StringOperator, OperatorButtonOption> initOptions() {
        final AppMessages messages = AppClientFactory.getMessages();

        final Map<StringOperator, OperatorButtonOption> options = new HashMap<StringOperator, OperatorButtonOption>();
        options.put(StringOperator.EQUALS, new OperatorButtonOption(IconType.EQUALS, messages.equalsLabel(), messages.equalsStringDescription()));
        options.put(StringOperator.DIFFERENTS, new OperatorButtonOption(IconType.DIFFERENT, messages.differentLabel(), messages.differentStringDescription()));
        options.put(StringOperator.STARTS_WITH,
            new OperatorButtonOption(IconType.STARTS_WITH, messages.startsWithLabel(), messages.startsWithStringDescription()));
        options.put(StringOperator.ENDS_WITH, new OperatorButtonOption(IconType.ENDS_WITH, messages.endsWidthLabel(), messages.endsWidthStringDescription()));
        options.put(StringOperator.CONTAINS, new OperatorButtonOption(IconType.CONTAINS, messages.containsLabel(), messages.containsStringDescription()));
        options.put(StringOperator.IS_NULL, new OperatorButtonOption(IconType.IS_NULL, messages.isNullLabel(), messages.isNullDescription()));
        options.put(StringOperator.NOT_STARTS_WITH,
            new OperatorButtonOption(IconType.NOT_STARTS_WITH, messages.notStartsWithLabel(), messages.notStartsWithStringDescription()));
        options.put(StringOperator.NOT_ENDS_WITH,
            new OperatorButtonOption(IconType.NOT_ENDS_WITH, messages.notEndsWithLabel(), messages.notEndsWithStringDescription()));
        options.put(StringOperator.NOT_CONTAINS,
            new OperatorButtonOption(IconType.NOT_CONTAINS, messages.containsLabel(), messages.containsStringDescription()));
        options.put(StringOperator.IS_NOT_NULL,
            new OperatorButtonOption(IconType.IS_NOT_NULL, messages.isNotNullLabel(), messages.isNotNullDescription()));
        return options;
    }
}
