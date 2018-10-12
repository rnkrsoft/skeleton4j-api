package javax.web.doc;

import lombok.Getter;

import javax.web.doc.enums.ElementType;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/12/5.
 * JavaBean字段对象包装
 */
@Getter
public class BeanElementInfo extends AbstractElementInfo implements ElementInfo {
    /**
     * 要素类型
     */
    final ElementType type = ElementType.BEAN;
    /**
     * 元素
     */
    final List<ElementInfo> elements = new ArrayList();
    /**
     * 字段名称
     */
    String name;
    /**
     * Java类
     */
    Class<?> javaClass;
    /**
     * 字段描述
     */
    String desc;

    String usage;

    private BeanElementInfo(WebComponentRegistry componentRegistry, InterfaceInfo interfaceInfo, ElementSet elementSet, String fullName) {
        super(componentRegistry, interfaceInfo, elementSet, fullName);
    }

    public static BeanElementInfoBuilder buider(WebComponentRegistry componentRegistry, InterfaceInfo interfaceInfo, ElementSet elementSet, String fullName) {
        return new BeanElementInfoBuilder(componentRegistry, interfaceInfo, elementSet, fullName);
    }

    public String getTypeName() {
        return type.getCode();
    }

    public String getJavaClassName() {
        return javaClass.getName();
    }

    @Getter
    public static class BeanElementInfoBuilder {
        WebComponentRegistry componentRegistry;
        InterfaceInfo interfaceInfo;
        ElementSet elementSet;
        String fullName;
        String name;
        Class<?> javaClass;
        String desc;
        String usage;

        private BeanElementInfoBuilder(WebComponentRegistry componentRegistry, InterfaceInfo interfaceInfo, ElementSet elementSet, String fullName) {
            this.componentRegistry = componentRegistry;
            this.interfaceInfo = interfaceInfo;
            this.elementSet = elementSet;
            this.fullName = fullName;
        }

        public BeanElementInfoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BeanElementInfoBuilder javaClass(Class<?> javaClass) {
            this.javaClass = javaClass;
            return this;
        }

        public BeanElementInfoBuilder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public BeanElementInfoBuilder usage(String usage) {
            this.usage = usage;
            return this;
        }

        public BeanElementInfo build() {
            BeanElementInfo elementInfo = new BeanElementInfo(componentRegistry, interfaceInfo, elementSet, fullName);
            elementInfo.name = name;
            elementInfo.javaClass = javaClass;
            if (desc == null) {
                elementInfo.desc = elementInfo.name;
            } else {
                elementInfo.desc = desc;
            }
            elementInfo.usage = usage == null ? "" : usage;
            return elementInfo;
        }
    }

    @Override
    public String toString() {
        return interfaceInfo.getFullName() + "." + columnType.getCode() + "." + getFullName();
    }
}
