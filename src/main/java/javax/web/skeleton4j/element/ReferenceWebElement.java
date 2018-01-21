package javax.web.skeleton4j.element;


import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;

/**
 * Created by devops4j on 2017/12/8.
 */
public interface ReferenceWebElement {
    /**
     * 获取对应的字段
     *
     * @return
     */
    ElementInfo getColumn();

    /**
     * 组件所属页面对象
     *
     * @return 页面对象
     */
    WebPage getWebPage();

    /**
     * 组件注册表
     *
     * @return 组件注册表
     */
    WebComponentRegistry getComponentRegistry();

    /**
     * 组件类型
     *
     * @return 组件类型
     */
    Class getElementClass();

    /**
     * 组件的ID
     */
    String getId();

    /**
     * 获取元素
     *
     * @return
     */
    WebElement get();

    /**
     * 绑定组件
     *
     * @param element 组件类型
     */
    void bind(WebElement element);

    /**
     * 获取组件并钻换位指定的类型
     *
     * @param targetClass 指定的组件类型
     * @param <T>         组件
     * @return 组件
     */
    <T extends WebElement> T as(Class<T> targetClass);
}
