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
package javax.web.skeleton4j.element.component;


import javax.web.doc.ValueElementInfo;
import javax.web.doc.enums.PatternType;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/10/13.
 * 能够放入表单的组件
 */
public interface WebFormableComponent extends WebComponent {
    /**
     * 表单中元素的标签
     *
     * @return 元素的标签
     */
    String getLabel();

    /**
     * 表单中元素的标签
     *
     * @param label 元素的标签
     */
    void setLabel(String label);

    /**
     * 背景颜色
     *
     * @param color 背景颜色
     */
    void setBackgroundColor(String color);

    /**
     * 背景颜色
     *
     * @return 背景颜色
     */
    String getBackgroundColor();

    /**
     * 字体颜色
     *
     * @param color 字体颜色
     */
    void setFontColor(String color);

    /**
     * 字体颜色
     *
     * @return 字体颜色
     */
    String getFontColor();

    /**
     * 表单中元素的值
     *
     * @return 元素的值
     */
    String getValue();

    /**
     * 表单中元素的值
     *
     * @param value 元素的值
     */
    void setValue(String value);

    /**
     * 允许最大长度
     *
     * @return 最大长度
     */
    int getMaxLen();

    /**
     * 允许最大长度
     *
     * @param maxLen 最大长度
     */
    void setMaxLen(int maxLen);

    /**
     * 允许最小长度
     *
     * @return 最小长度
     */
    int getMinLen();

    /**
     * 允许最小长度
     *
     * @param minLen 最小长度
     */
    void setMinLen(int minLen);

    /**
     * 获取默认值
     *
     * @return 默认值
     */
    List<String> getDefaultValues();

    /**
     * 是否为隐藏
     *
     * @return 隐藏
     */
    boolean isHidden();

    /**
     * 设置是否为隐藏
     *
     * @param hidden 隐藏
     */
    void setHidden(boolean hidden);

    /**
     * 获取文本框是否为只读
     *
     * @return 否为只读
     */
    boolean isReadonly();

    /**
     * 设置文本框是否为只读
     *
     * @param readonly 否为只读
     */
    void setReadonly(boolean readonly);

    /**
     * 获取文本框是否为必输
     *
     * @return 否为必输
     */
    boolean isRequired();

    /**
     * 设置文本框是否为必输
     *
     * @param required 否为必输
     */
    void setRequired(boolean required);

    /**
     * 校验表达式
     *
     * @return 表达式
     */
    List<String> getPatterns();

    /**
     * 表达式类型
     *
     * @return 表达式类型
     */
    PatternType getPatternType();

    /**
     * 设置表达式类型
     *
     * @param patternType 表达式类型
     */
    void setPatternType(PatternType patternType);

    /**
     * 获取字段元信息
     *
     * @return 字段信息
     */
    ValueElementInfo getColumnMetadata();

    /**
     * 获取占位文本
     *
     * @return 占位文本
     */
    String getPlaceholder();

    /**
     * 设置占位文本
     *
     * @param placeholder 占位文本
     */
    void setPlaceholder(String placeholder);
}
