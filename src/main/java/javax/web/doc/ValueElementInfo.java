/**
 * RNKRSOFT OPEN SOURCE SOFTWARE LICENSE TERMS ver.1
 * - 氡氪网络科技(重庆)有限公司 开源软件许可条款(版本1)
 * 氡氪网络科技(重庆)有限公司 以下简称Rnkrsoft。
 * 这些许可条款是 Rnkrsoft Corporation（或您所在地的其中一个关联公司）与您之间达成的协议。
 * 请阅读本条款。本条款适用于所有Rnkrsoft的开源软件项目，任何个人或企业禁止以下行为：
 * .禁止基于删除开源代码所附带的本协议内容、
 * .以非Rnkrsoft的名义发布Rnkrsoft开源代码或者基于Rnkrsoft开源源代码的二次开发代码到任何公共仓库,
 * 除非上述条款附带有其他条款。如果确实附带其他条款，则附加条款应适用。
 * <p/>
 * 使用该软件，即表示您接受这些条款。如果您不接受这些条款，请不要使用该软件。
 * 如下所述，安装或使用该软件也表示您同意在验证、自动下载和安装某些更新期间传输某些标准计算机信息以便获取基于 Internet 的服务。
 * <p/>
 * 如果您遵守这些许可条款，将拥有以下权利。
 * 1.阅读源代码和文档
 * 如果您是个人用户，则可以在任何个人设备上阅读、分析、研究Rnkrsoft开源源代码。
 * 如果您经营一家企业，则禁止在任何设备上阅读Rnkrsoft开源源代码,禁止分析、禁止研究Rnkrsoft开源源代码。
 * 2.编译源代码
 * 如果您是个人用户，可以对Rnkrsoft开源源代码以及修改后产生的源代码进行编译操作，编译产生的文件依然受本协议约束。
 * 如果您经营一家企业，不可以对Rnkrsoft开源源代码以及修改后产生的源代码进行编译操作。
 * 3.二次开发拓展功能
 * 如果您是个人用户，可以基于Rnkrsoft开源源代码进行二次开发，修改产生的元代码同样受本协议约束。
 * 如果您经营一家企业，不可以对Rnkrsoft开源源代码进行任何二次开发，但是可以通过联系Rnkrsoft进行商业授予权进行修改源代码。
 * 完整协议。本协议以及开源源代码附加协议，共同构成了Rnkrsoft开源软件的完整协议。
 * <p/>
 * 4.免责声明
 * 该软件按“原样”授予许可。 使用本文档的风险由您自己承担。Rnkrsoft 不提供任何明示的担保、保证或条件。
 * 5.版权声明
 * 本协议所对应的软件为 Rnkrsoft 所拥有的自主知识产权，如果基于本软件进行二次开发，在不改变本软件的任何组成部分的情况下的而二次开发源代码所属版权为贵公司所有。
 */
 package javax.web.doc;

import lombok.Getter;

import javax.web.doc.enums.ElementType;
import javax.web.doc.enums.PatternType;
import javax.web.doc.enums.ValueDisplayType;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import java.util.*;

/**
 * Created by rnkrsoft.com on 2017/12/5.
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
     * 级联的菜单
     */
    final List<CascadeMenu> cascadeMenus = new ArrayList();
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
     * 是否能够多选
     */
    boolean multiple;
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
     * @return 是否为枚举
     */
    public boolean isEnum() {
        return !enums.isEmpty();
    }

    /**
     * 当前字段是否为应答码字段
     *
     * @return 是否为应答码字段
     */
    public boolean isRspCode() {
        if (RspCodeReadable.class.isAssignableFrom(getElementSet().getElementClass())) {
            return "rspCode".equals(this.name) || "rspDesc".equals(this.name);
        } else {
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
        final List<CascadeMenu> cascadeMenus = new ArrayList();
        boolean unique = false;
        String name;
        String desc;
        String placeholder;
        ValueDisplayType valueDisplayType;
        boolean multiple = false;
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

        public ValueElementInfoBuilder multiple(boolean multiple) {
            this.multiple = multiple;
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

        public ValueElementInfoBuilder cascadeMenu(CascadeMenu... cascadeMenus) {
            this.cascadeMenus.addAll(Arrays.asList(cascadeMenus));
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
            info.usage = usage == null ? "" : usage;
            info.enums.putAll(enums);
            if (valueDisplayType == null) {
                info.valueDisplayType = ValueDisplayType.STRING;
                info.javaClass = String.class;
            } else {
                info.valueDisplayType = valueDisplayType;
                info.javaClass = javaClass;
            }
            info.multiple = multiple;
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
            info.cascadeMenus.addAll(cascadeMenus);
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
        return interfaceInfo.getFullName() + ":" + columnType.getCode() + ":" + getFullName();
    }
}
