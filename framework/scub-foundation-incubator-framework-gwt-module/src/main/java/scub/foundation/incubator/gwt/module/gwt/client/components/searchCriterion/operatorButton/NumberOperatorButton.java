package scub.foundation.incubator.gwt.module.gwt.client.components.searchCriterion.operatorButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scub.foundation.incubator.gwt.module.gwt.client.factory.AppClientFactory;
import scub.foundation.incubator.gwt.module.gwt.client.i18n.AppMessages;
import scub.foundation.incubator.gwt.module.gwt.shared.searchCriterion.NumberSearchCriterionModel.NumberOperator;

/**
 * An operator button for the string search criterion.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class NumberOperatorButton extends AbstractOperatorButton<NumberOperator> {

    /**
     * Constructor.
     * @param value the value.
     */
    public NumberOperatorButton(NumberOperator value) {
        final List<NumberOperator> operators = new ArrayList<NumberOperator>();
        operators.add(NumberOperator.EQUALS);
        operators.add(NumberOperator.DIFFERENTS);
        operators.add(NumberOperator.IS_NULL);
        operators.add(NumberOperator.IS_NOT_NULL);
        operators.add(NumberOperator.GREATER_THAN_OR_EQUAL);
        operators.add(NumberOperator.LESS_THAN_OR_EQUAL);
        operators.add(NumberOperator.GREATER_THAN);
        operators.add(NumberOperator.LESS_THAN);
        operators.add(NumberOperator.BETWEEN);
        operators.add(NumberOperator.NOT_BETWEEN);
        operators.add(NumberOperator.STRICTLY_BETWEEN);
        operators.add(NumberOperator.STRICTLY_NOT_BETWEEN);
        setPossibleOperators(operators);
        setValue(value);
    }

    @Override
    Map<NumberOperator, OperatorButtonOption> initOptions() {
        final AppMessages messages = AppClientFactory.getMessages();

        final Map<NumberOperator, OperatorButtonOption> options = new HashMap<NumberOperator, OperatorButtonOption>();
        options.put(NumberOperator.EQUALS, new OperatorButtonOption(IconType.EQUALS, messages.equalsLabel(), messages.equalsNumberDescription()));
        options.put(NumberOperator.DIFFERENTS, new OperatorButtonOption(IconType.DIFFERENT, messages.differentLabel(), messages.differentNumberDescription()));
        options.put(NumberOperator.IS_NULL, new OperatorButtonOption(IconType.IS_NULL, messages.isNullLabel(), messages.isNullDescription()));
        options.put(NumberOperator.IS_NOT_NULL, new OperatorButtonOption(IconType.IS_NOT_NULL, messages.isNotNullLabel(), messages.isNotNullDescription()));
        options.put(NumberOperator.GREATER_THAN_OR_EQUAL, new OperatorButtonOption(IconType.GREATER_THAN_OR_EQUAL, messages.greatherThanOrEqualLabel(),
            messages.greatherThanOrEqualNumberDescription()));
        options.put(NumberOperator.LESS_THAN_OR_EQUAL,
            new OperatorButtonOption(IconType.LESS_THAN_OR_EQUAL, messages.lessThanOrEqualLabel(), messages.lessThanOrEqualNumberDescription()));
        options.put(NumberOperator.GREATER_THAN,
            new OperatorButtonOption(IconType.GREATER_THAN, messages.greatherThanLabel(), messages.greatherThanNumberDescription()));
        options.put(NumberOperator.LESS_THAN, new OperatorButtonOption(IconType.LESS_THAN, messages.lessThanLabel(), messages.lessThanNumberDescription()));
        options.put(NumberOperator.BETWEEN, new OperatorButtonOption(IconType.BETWEEN, messages.betweenLabel(), messages.betweenNumberDescription()));
        options.put(NumberOperator.NOT_BETWEEN,
            new OperatorButtonOption(IconType.NOT_BETWEEN, messages.notBetweenLabel(), messages.notBetweenNumberDescription()));
        options.put(NumberOperator.STRICTLY_BETWEEN,
            new OperatorButtonOption(IconType.STRICTLY_BETWEEN, messages.strictlyBetweenLabel(), messages.strictlyNotBetweenNumberDescription()));
        options.put(NumberOperator.STRICTLY_NOT_BETWEEN,
            new OperatorButtonOption(IconType.STRICTLY_NOT_BETWEEN, messages.strictlyNotBetweenLabel(), messages.strictlyBetweenNumberDescription()));

        return options;
    }
}
