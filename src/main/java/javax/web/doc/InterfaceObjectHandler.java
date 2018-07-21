package javax.web.doc;

import javax.web.doc.enums.ElementSetType;
import java.lang.reflect.Method;

/**
 * 过滤器
 */
public interface InterfaceObjectHandler {
    /**
     * 过滤器能够处理的类型
     *
     * @return 过滤器类型
     */
    ElementSetType getObjectType();

    /**
     * 判断是否能够使用当前过滤器进行处理
     *
     * @param serviceClass 正在处理@ApidocService服务类
     * @param method       方法对象
     * @param paramClass   参数类对象
     * @return 是否能够处理
     */
    boolean accept(Class serviceClass, Method method, Class paramClass);

    /**
     * 过滤正在处理的对象
     *
     * @param serviceClass 正在处理@ApidocService服务类
     * @param method       方法对象
     * @param paramClass   参数类对象
     * @return 处理完成的参数类对象
     */
    Class handle(Class serviceClass, Method method, Class paramClass);
}