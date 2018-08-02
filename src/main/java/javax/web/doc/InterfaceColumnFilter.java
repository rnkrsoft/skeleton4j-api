package javax.web.doc;

import javax.web.doc.enums.ElementSetType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by rnkrsoft.com on 2018/7/20.
 */
public interface InterfaceColumnFilter {
    /**
     * 过滤器能够处理的类型
     *
     * @return 过滤器类型
     */
    ElementSetType getObjectType();

    /**
     * 检测是否匹配忽略过滤器
     *
     * @param interfaceMethod 接口方法
     * @param objectClass     对象类
     * @param column          字段对象
     * @param fullColumnName  全字段名
     * @return 是否匹配需要过滤的字段
     */
    boolean match(Method interfaceMethod, Class objectClass, Field column, String fullColumnName);
}
