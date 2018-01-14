package javax.web.skeleton4j.element.component;


import javax.web.doc.ValueElementInfo;
import javax.web.doc.enums.PatternType;
import java.util.List;

/**
 * Created by devops4j on 2017/10/13.
 * 能够放入表单的组件
 */
public interface WebFormableComponent extends WebComponent {
    /**
     * 表单中元素的标签
     * @return
     */
    String getLabel();

    /**
     * 表单中元素的标签
     * @param label
     */
    void setLabel(String label);
    /**
     * 背景颜色
     * @param color
     */
    void setBackgroundColor(String color);

    /**
     * 背景颜色
     * @return
     */
    String getBackgroundColor();

    /**
     * 字体颜色
     * @param color
     */
    void setFontColor(String color);

    /**
     * 字体颜色
     * @return
     */
    String getFontColor();
    /**
     * 表单中元素的值
     * @return
     */
    String getValue();

    /**
     * 表单中元素的值
     * @param value
     */
    void setValue(String value);

    /**
     * 允许最大长度
     * @return
     */
    int getMaxLen();

    /**
     * 允许最大长度
     * @param maxLen
     */
    void setMaxLen(int maxLen);

    /**
     * 允许最小长度
     * @return
     */
    int getMinLen();

    /**
     * 允许最小长度
     */
    void setMinLen(int minLen);
    /**
     * 获取默认值
     *
     * @return
     */
    List<String> getDefaultValues();

    /**
     * 是否为唯一键
     *
     * @return
     */
    boolean isHidden();

    /**
     * 设置是否为唯一键
     *
     * @param hidden
     */
    void setHidden(boolean hidden);

    /**
     * 获取文本框是否为只读
     *
     * @return
     */
    boolean isReadonly();

    /**
     * 设置文本框是否为只读
     *
     * @param readonly
     */
    void setReadonly(boolean readonly);

    /**
     * 获取文本框是否为必输
     *
     * @return
     */
    boolean isRequired();

    /**
     * 设置文本框是否为必输
     *
     * @param required
     */
    void setRequired(boolean required);

    /**
     * 校验表达式
     *
     * @return
     */
    List<String> getPatterns();

    /**
     * 表达式类型
     * @return
     */
    PatternType getPatternType();

    /**
     * 设置表达式类型
     * @param patternType
     */
    void setPatternType(PatternType patternType);

    /**
     * 获取字段元信息
     * @return  字段信息
     */
    ValueElementInfo getColumnMetadata();

    /**
     * 获取占位文本
     * @return
     */
    String getPlaceholder();

    /**
     * 设置占位文本
     * @param placeholder 占位文本
     */
    void setPlaceholder(String placeholder);
}
