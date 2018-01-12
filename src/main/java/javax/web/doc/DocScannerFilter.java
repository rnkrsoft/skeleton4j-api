package javax.web.doc;

import javax.web.doc.enums.FilterType;
import java.lang.reflect.Method;

/**
 * 过滤器
 */
public interface DocScannerFilter {
    /**
     * 过滤器能够处理的类型
     *
     * @return
     */
    FilterType getFilterType();

    /**
     * @param serviceClass
     * @param method
     * @return
     */
    boolean accept(Class serviceClass, Method method, Class paramClass);

    /**
     * 过滤正在处理的对象
     *
     * @param requestClass
     * @param method
     * @return
     */
    Class filter(Class serviceClass, Method method, Class paramClass);
}