package javax.web.doc;

import lombok.Getter;

import javax.web.doc.enums.ElementType;
import javax.web.skeleton4j.element.DefaultReferenceWebElement;
import javax.web.skeleton4j.element.ReferenceWebElement;
import javax.web.skeleton4j.enums.ColumnType;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by devops4j on 2017/12/11.
 */
@Getter
public abstract class AbstractElementInfo implements ElementInfo {
    /**
     * 字段映射到对应页面的引用
     */
    final Map<WebPage, ReferenceWebElement> mappings = new HashMap();

    protected final ColumnType columnType;
    /**
     * 字段的完整名称
     */
    protected final String fullName;
    /**
     * 是否为只读字段
     */
    boolean readonly = false;
    /**
     * 所属接口对象
     */
    protected final InterfaceInfo interfaceInfo;

    final ElementSet elementSet;

    final WebComponentRegistry componentRegistry;

    public AbstractElementInfo(WebComponentRegistry componentRegistry, InterfaceInfo interfaceInfo, ElementSet elementSet, String fullName) {
        this.interfaceInfo = interfaceInfo;
        this.elementSet = elementSet;
        this.fullName = fullName;
        this.columnType = isBelongToRequest() ? ColumnType.REQUEST : ColumnType.RESPONSE;
        this.componentRegistry = componentRegistry;
    }

    @Override
    public ReferenceWebElement getMapping(WebPage page) {
        ReferenceWebElement ref = mappings.get(page);
        if (ref == null) {
            mappings.put(page, new DefaultReferenceWebElement(componentRegistry, page, this, null, null));
            ref = mappings.get(page);
        }
        return ref;
    }

    @Override
    public <T extends ElementInfo> T as(Class<T> targetClass) {
        return (T) this;
    }

    @Override
    public boolean isBelongToRequest() {
        return interfaceInfo.getRequest() == elementSet ? true : false;
    }

    @Override
    public boolean isBelongToResponse() {
        return interfaceInfo.getResponse() == elementSet ? true : false;
    }

    @Override
    public boolean isValue() {
        return getType() == ElementType.VALUE;
    }

    @Override
    public boolean isForm() {
        return getType() == ElementType.FORM;
    }

    @Override
    public boolean isBean() {
        return getType() == ElementType.BEAN;
    }
}
