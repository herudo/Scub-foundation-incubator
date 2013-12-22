package scub.foundation.incubator.gwt.module.gwt.client.aop;

import org.scub.foundation.framework.base.exception.BusinessException;
import org.scub.foundation.framework.base.exception.CoreRunTimeException;
import org.scub.foundation.framework.base.exception.IntegrityControlException;
import org.scub.foundation.framework.base.exception.PermissionException;
import org.scub.foundation.framework.base.exception.TechnicalException;
import org.scub.foundation.framework.gwt.module.client.exception.BusinessExceptionGwt;
import org.scub.foundation.framework.gwt.module.client.exception.IntegrityControlExceptionGWT;
import org.scub.foundation.framework.gwt.module.client.exception.PermissionExceptionGwt;
import org.scub.foundation.framework.gwt.module.client.exception.TechnicalExceptionGwt;
import org.scub.foundation.framework.gwt.module.shared.ReportModel;
import org.scub.foundation.incubator.framework.base.utils.mapper.MapperDozerBean;

/**
* Advisor to intercept the exception of the core and transform into GWT exception.
* @author Goumard stephane (stephane.goumard@scub.net)
* @author Adrien HAUTOT (adrien.hautot@scub.net)
*/
public class AfterThrowingAdvice {
private MapperDozerBean mapperDozerBean;

/**
 * Method that catches the exception if the type CoreRunTimeException.
 * @param ex the exception.
 */
public void afterThrowing(CoreRunTimeException ex) {
    if (ex instanceof BusinessException) {
        throw new BusinessExceptionGwt(ex.getMessage());
    } else if (ex instanceof PermissionException) {
        throw new PermissionExceptionGwt(ex.getMessage());
    } else if (ex instanceof TechnicalException) {
        throw new TechnicalExceptionGwt(ex.getMessage());
    } else if (ex instanceof IntegrityControlException) {
        throw new IntegrityControlExceptionGWT((ReportModel) mapperDozerBean.map(((IntegrityControlException) ex).getReport(), ReportModel.class));
    }
}

/**
 * Set the value of mapperDozerBean.
 * @param mapperDozerBean the mapperDozerBean to set
 */
public void setMapperDozerBean(MapperDozerBean mapperDozerBean) {
    this.mapperDozerBean = mapperDozerBean;
}
}
