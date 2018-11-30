package javax.web.doc;

import lombok.Getter;

import javax.web.doc.enums.ElementType;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import java.util.*;

/**
 * Created by rnkrsoft.com on 2017/12/5.
 * 列表字段包装对象
 */
@Getter
public class FormElementInfo extends AbstractElementInfo implements ElementInfo {
    /**
     * 要素类型
     */
    final ElementType type = ElementType.FORM;
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
     * 该字段所属的html class值，可以是多个
     */
    final Set<String> cssClasses = new HashSet();
    /**
     * Bean类
     */
    Class<?> beanClass;
    /**
     * 字段描述
     */
    String desc;
    /**
     * 用法
     */
    String usage;
    /**
     * 是否必输
     */
    boolean required;

    private FormElementInfo(WebComponentRegistry componentRegistry, InterfaceInfo interfaceInfo, ElementSet elementSet, String fullName) {
        super(componentRegistry, interfaceInfo, elementSet, fullName);
    }

    public static FormElementInfoBuilder builder(WebComponentRegistry componentRegistry, InterfaceInfo interfaceInfo, ElementSet elementSet, String fullName) {
        return new FormElementInfoBuilder(componentRegistry, interfaceInfo, elementSet, fullName);
    }

    public String getTypeName() {
        return type.getCode();
    }

    public String getJavaClassName() {
        return javaClass.getName();
    }

    public String getBeanClassName() {
        return beanClass.getName();
    }

    @Getter
    public static class FormElementInfoBuilder {
        WebComponentRegistry componentRegistry;
        InterfaceInfo interfaceInfo;
        ElementSet elementSet;
        String fullName;
        final List<ElementInfo> elements = new ArrayList();
        String name;
        Class<?> javaClass;
        Set<String> cssClasses = new HashSet();
        Class<?> beanClass;
        String desc;
        String usage;
        boolean required;

        private FormElementInfoBuilder(WebComponentRegistry componentRegistry, InterfaceInfo interfaceInfo, ElementSet elementSet, String fullName) {
            this.componentRegistry = componentRegistry;
            this.interfaceInfo = interfaceInfo;
            this.elementSet = elementSet;
            this.fullName = fullName;
        }

        public FormElementInfoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public FormElementInfoBuilder cssClass(String... cssClass) {
            this.cssClasses.addAll(Arrays.asList(cssClass));
            return this;
        }

        public FormElementInfoBuilder javaClass(Class<?> javaClass) {
            this.javaClass = javaClass;
            return this;
        }

        public FormElementInfoBuilder beanClass(Class<?> beanClass) {
            this.beanClass = beanClass;
            return this;
        }

        public FormElementInfoBuilder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public FormElementInfoBuilder usage(String usage) {
            this.usage = usage;
            return this;
        }

        public FormElementInfoBuilder required(boolean required) {
            this.required = required;
            return this;
        }

        public FormElementInfoBuilder element(ElementInfo... element) {
            this.elements.addAll(Arrays.asList(element));
            return this;
        }

        public FormElementInfo build() {
            FormElementInfo elementInfo = new FormElementInfo(componentRegistry, interfaceInfo, elementSet, fullName);
            elementInfo.name = name;
            if (desc == null) {
                elementInfo.desc = elementInfo.name;
            } else {
                elementInfo.desc = desc;
            }
            elementInfo.cssClasses.addAll(cssClasses);
            elementInfo.usage = usage == null ? "" : usage;
            elementInfo.javaClass = javaClass;
            elementInfo.required = required;
            elementInfo.beanClass = beanClass;
            elementInfo.elements.addAll(elements);
            return elementInfo;
        }

    }

    @Override
    public String toString() {
        return interfaceInfo.getFullName() + "." + columnType.getCode() + "." + getFullName();
    }
}
