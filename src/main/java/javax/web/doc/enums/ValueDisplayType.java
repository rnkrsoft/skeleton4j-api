package javax.web.doc.enums;

/**
 * Created by devops4j on 2017/12/5.
 * 字段值展示类型，用于将数据转换为可见的形式
 */
public enum ValueDisplayType {
    Auto,
    /**
     * 字符串
     */
    String,
    /**
     * 整数
     */
    Integer,
    /**
     * 浮点数
     */
    Decimal,
    /**
     * 列表
     */
    List,
    /**
     * 日期
     */
    Date,
    /**
     * 图片
     */
    Image,
    /**
     * 树
     */
    Tree,
    /**
     * Markdown文本
     */
    Markdown,
    /**
     * 富文本
     */
    RichText,
    /**
     * 可供选择的类型，多选或者单选
     */
    Selection
}
