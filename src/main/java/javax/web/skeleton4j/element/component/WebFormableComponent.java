package javax.web.skeleton4j.element.component;


import javax.web.doc.ValueElementInfo;
import javax.web.doc.enums.PatternType;
import javax.web.skeleton4j.script.WebScript;
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
