package org.scub.foundation.incubator.framework.core.implementations.utils;

import org.scub.foundation.framework.base.messagesource.MessageSourceUtil;

/**
 * Utils class to give error messages.
 * @author Adrien HAUTOT (contact@adrienhautot.fr)
 */
public class ErrorMessages {

    /** . */
    protected MessageSourceUtil messageSourceUtil;

    /** filterNull. @return le message */
    public String filterNull() {
        return messageSourceUtil.get("error.filter.null");
    }

    /** idNull. @return le message */
    public String idNull() {
        return messageSourceUtil.get("error.id.null");
    }

    /** search criteria null. @return le message */
    public String searchCriteriaNull() {
        return messageSourceUtil.get("error.search.criteria.null");
    }

    /** label Null. @return le message */
    public String idLabelDtolabelRequired() {
        return messageSourceUtil.get("IdLabelDto.label.NotNull");
    }

    /** objet non trouvé en base. @return le message */
    public String objectNotFound() {
        return messageSourceUtil.get("error.object.not.found");
    }

    /** objet non trouvé en base. @return le message */
    public String validatedObjectNull() {
        return messageSourceUtil.get("error.validated.object.null");
    }

    /**
     * Set the value of messageSourceUtil.
     * @param messageSourceUtil the messageSourceUtil to set
     */
    public void setMessageSourceUtil(MessageSourceUtil messageSourceUtil) {
        this.messageSourceUtil = messageSourceUtil;
    }
}
