package javax.web.doc.enums;

/**
 * Created by rnkrsoft.com on 2017/12/5.
 * 字段值展示类型，用于将数据转换为可见的形式
 */
public enum ValueDisplayType {
    /**
     * 自动识别
     * java.lang.String映射到String
     * java.lang.Integer映射到Integer
     * java.lang.Long映射到Integer
     * java.lang.Boolean映射到Selection
     * java.util.Collection<String>映射到Selection
     * java.util.Collection<Integer>映射到Selection
     * java.util.Collection<Serialize>映射到Form
     */
    AUTO,
    /**
     * 字符串
     */
    STRING,
    /**
     * 整数
     */
    INTEGER,
    /**
     * 浮点数
     */
    DECIMAL,
    /**
     * 搜索控件
     */
    SEARCH_VIEW,
    /**
     * 列表
     */
    LIST,
    /**
     * 日期
     */
    DATE,
    /**
     * 图片
     */
    IMAGE,
    /**
     * 树
     */
    TREE,
    /**
     * 可供选择的类型，多选或者单选
     */
    SELECTION,
    /**
     * Markdown文本
     */
    MARKDOWN,
    /**
     * 富文本
     */
    RICH_TEXT,
    /**
     * JSON数据
     */
    JSON,
    /**
     * 源代码数据
     */
    SOURCE,
    /**
     * 地图区域
     */
    MAP_REGION
}
