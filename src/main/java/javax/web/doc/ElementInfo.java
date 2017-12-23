package javax.web.doc;

import javax.web.doc.enums.ElementType;
import javax.web.doc.enums.ValueDisplayType;
import javax.web.skeleton4j.element.ReferenceWebElement;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.enums.ColumnType;

/**
 * Created by devops4j on 2017/12/5.
 * 字段信息父接口
 */
public interface ElementInfo {
    /**
     * 获取字段的映射组件
     * @param page 映射到页面
     * @return 组件引用
     */
    ReferenceWebElement getMapping(WebPage page);

    /**
     * 字段类型
     * @return
     */
    ColumnType getColumnType();
    /**
     * 获取接口信息
     * @return
     */
    InterfaceInfo getInterfaceInfo();

    /**
     * 获取字段信息所在集合
     * @return
     */
    ElementSet getElementSet();

    /**
     * 字段属于请求对象
     * @return
     */
    boolean isBelongToRequest();

    /**
     * 字段数与应答对象
     * @return
     */
    boolean isBelongToResponse();
    /**
     * 获取WEB组件注册对象
     * @return
     */
    WebComponentRegistry getComponentRegistry();
    /**
     * 要素类型
     *
     * @return
     * @see ValueDisplayType
     */
    String getTypeName();

    /**
     * 要素类型
     *
     * @return
     * @see ValueDisplayType
     */
    ElementType getType();

    /**
     * 如果为ValueElementInfo返回真
     * @return
     */
    boolean isValue();
    /**
     * 如果为FormElementInfo返回真
     * @return
     */
    boolean isForm();
    /**
     * 如果为BeanElementInfo返回真
     * @return
     */
    boolean isBean();

    /**
     * 将字段转换为具体的字段类型
     * @param targetClass 目标类型
     * @param <T>
     * @return 字段
     */
    <T extends ElementInfo> T as(Class<T> targetClass);

    /**
     * 要素名称，通常为英文
     *
     * @return
     */
    String getName();

    /**
     * 获取完整名称
     * @return
     */
    String getFullName();
    /**
     * 要素描述
     * 如果描述为空，则取name的值
     *
     * @return
     */
    String getDesc();

    /**
     * 要素用法
     * 如果用法为空，则取desc的值
     *
     * @return
     */
    String getUsage();
}
