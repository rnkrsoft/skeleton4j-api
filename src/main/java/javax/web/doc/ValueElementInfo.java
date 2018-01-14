package javax.web.doc;

import lombok.Getter;
import lombok.Setter;

import javax.web.doc.enums.ElementType;
import javax.web.doc.enums.PatternType;
import javax.web.doc.enums.ValueDisplayType;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import java.util.*;

/**
 * Created by devops4j on 2017/12/5.
 * 原生类型字段的包装
 */
@Getter
public class ValueElementInfo extends AbstractElementInfo implements ElementInfo {
    /**
     * 要素类型
     */
    final ElementType type = ElementType.VALUE;
    /**
     * 字典描述
     */
    final Map<String, String> enums = new HashMap();
    /**
     * 缺省值
     */
    final List<String> defaults = new ArrayList();
    /**
     * 提交表单时，该字段的校验规则
     */
    final List<String> patterns = new ArrayList();
    /**
     * 该字段所属的html class值，可以是多个
     */
    final Set<String> cssClasses = new HashSet();
    /**
     * 级联接口定义
     */
    final List<CascadeInterface> cascadeInterfaces = new ArrayList();
    /**
     * 是否为唯一主键，标记为唯一组件，则可用于管理系统中表格中按钮事件的传值
     */
    boolean unique = false;
    /**
     * 字段名称
     */
    String name;
    /**
     * 字段描述
     */
    String desc;
    /**
     * 占位提示
     */
    String placeholder;
    /**
     * 数据类型
     */
    ValueDisplayType valueDisplayType;
    /**
     * Java类
     */
    Class<?> javaClass;
    /**
     * 是否必输
     */
    boolean required;
    /**
     * 最小长度
     */
    int minLen;
    /**
     * 最大长度
     */
    int maxLen;
    /**
     * 校验规则何种类型，正则表达式、ONGL表达式
     */
    PatternType patternType = PatternType.REGEX;
    /**
     * 在向导方式时，该字段在第几阶段展示
     */
    int stage = 0;
    /**
     * 是否为隐藏字段
     */
    boolean hidden = false;
    /**
     * 字段的用法
     */
    String usage;

    public ValueElementInfo(WebComponentRegistry componentRegistry, InterfaceInfo interfaceInfo, ElementSet elementSet, String fullName) {
        super(componentRegistry, interfaceInfo, elementSet, fullName);
    }

    public static ValueElementInfoBuilder builder(WebComponentRegistry componentRegistry, InterfaceInfo interfaceInfo, ElementSet elementSet, String fullName) {
        return new ValueElementInfoBuilder(componentRegistry, interfaceInfo, elementSet, fullName);
    }

    public String getTypeName() {
        return type.getCode();
    }

    public String getJavaClassName() {
        return javaClass.getName();
    }

    /**
     * 判断该值元素是否为枚举
     *
     * @return
     */
    public boolean isEnum() {
        return !enums.isEmpty();
    }

    /**
     * 当前字段是否为应答码字段
     * @return
     */
    public boolean isRspCode(){
        if(RspCodeReadable.class.isAssignableFrom(getElementSet().getElementClass())){
            return "rspCode".equals(this.name) || "rspDesc".equals(this.name);
        }else{
            return false;
        }
    }
    @Getter
    public static class ValueElementInfoBuilder {
        WebComponentRegistry componentRegistry;
        InterfaceInfo interfaceInfo;
        ElementSet elementSet;
        String fullName;
        final Map<String, String> enums = new HashMap();
        final List<String> defaults = new ArrayList();
        final List<String> patterns = new ArrayList();
        final List<CascadeInterface> cascadeInterfaces = new ArrayList();
        boolean unique = false;
        String name;
        String desc;
        String placeholder;
        ValueDisplayType valueDisplayType;
        Class<?> javaClass;
        boolean required;
        int minLen;
        int maxLen;
        PatternType patternType = PatternType.REGEX;
        int stage = 0;
        Set<String> cssClasses = new HashSet();
        boolean hidden = false;
        boolean readonly = false;
        boolean date = false;
        boolean tree = false;
        String usage;

        private ValueElementInfoBuilder(WebComponentRegistry componentRegistry, InterfaceInfo interfaceInfo, ElementSet elementSet, String fullName) {
            this.componentRegistry = componentRegistry;
            this.interfaceInfo = interfaceInfo;
            this.elementSet = elementSet;
            this.fullName = fullName;
        }

        public ValueElementInfoBuilder unique(boolean unique) {
            this.unique = unique;
            return this;
        }

        public ValueElementInfoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ValueElementInfoBuilder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public ValueElementInfoBuilder placeholder(String placeholder) {
            this.placeholder = placeholder;
            return this;
        }


        public ValueElementInfoBuilder enumDesc(String code, String desc) {
            this.enums.put(code, desc);
            return this;
        }

        public ValueElementInfoBuilder valueDisplayType(ValueDisplayType valueDisplayType) {
            this.valueDisplayType = valueDisplayType;
            return this;
        }

        public ValueElementInfoBuilder javaClass(Class<?> javaClass) {
            this.javaClass = javaClass;
            return this;
        }

        public ValueElementInfoBuilder required(boolean required) {
            this.required = required;
            return this;
        }

        public ValueElementInfoBuilder minLen(int minLen) {
            this.minLen = minLen;
            return this;
        }

        public ValueElementInfoBuilder maxLen(int maxLen) {
            this.maxLen = maxLen;
            return this;
        }

        public ValueElementInfoBuilder defaults(String... defaults) {
            this.defaults.addAll(Arrays.asList(defaults));
            return this;
        }

        public ValueElementInfoBuilder patternType(PatternType patternType) {
            this.patternType = patternType;
            return this;
        }

        public ValueElementInfoBuilder pattern(String... pattern) {
            this.patterns.addAll(Arrays.asList(pattern));
            return this;
        }

        public ValueElementInfoBuilder stage(int stage) {
            this.stage = stage;
            return this;
        }

        public ValueElementInfoBuilder cssClass(String... cssClass) {
            this.cssClasses.addAll(Arrays.asList(cssClass));
            return this;
        }

        public ValueElementInfoBuilder hidden(boolean hidden) {
            this.hidden = hidden;
            return this;
        }

        public ValueElementInfoBuilder readonly(boolean readonly) {
            this.readonly = readonly;
            return this;
        }

        public ValueElementInfoBuilder cascadeInterface(CascadeInterface... cascadeInterface) {
            this.cascadeInterfaces.addAll(Arrays.asList(cascadeInterface));
            return this;
        }

        public ValueElementInfoBuilder usage(String usage) {
            this.usage = usage;
            return this;
        }

        public ValueElementInfo build() {
            ValueElementInfo info = new ValueElementInfo(componentRegistry, interfaceInfo, elementSet, fullName);
            info.unique = unique;
            info.name = name;
            if (desc == null) {
                info.desc = info.name;
            } else {
                info.desc = desc;
            }
            if (placeholder == null) {
                info.placeholder = desc;
            } else {
                info.placeholder = placeholder;
            }
            if (usage == null) {
                info.usage = info.desc;
            } else {
                info.usage = usage;
            }
            info.enums.putAll(enums);
            if (valueDisplayType == null) {
                info.valueDisplayType = ValueDisplayType.String;
                info.javaClass = String.class;
            } else {
                info.valueDisplayType = valueDisplayType;
                info.javaClass = javaClass;
            }
            info.required = required;
            info.minLen = minLen;
            info.maxLen = maxLen;
            info.defaults.addAll(defaults);
            info.patternType = patternType;
            info.patterns.addAll(patterns);
            info.stage = stage;
            info.cssClasses.addAll(cssClasses);
            info.hidden = hidden;
            info.readonly = readonly;
            info.cascadeInterfaces.addAll(cascadeInterfaces);
            return info;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValueElementInfo)) return false;
        ValueElementInfo that = (ValueElementInfo) o;
        return Objects.equals(interfaceInfo, that.interfaceInfo) &&
                Objects.equals(columnType, that.columnType) &&
                Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interfaceInfo, columnType, fullName);
    }

    @Override
    public String toString() {
        return interfaceInfo.getFullName() + "." + columnType.getCode() + "." + getFullName();
    }
}
