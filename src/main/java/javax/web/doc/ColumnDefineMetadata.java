package javax.web.doc;

import lombok.Data;

import javax.web.doc.enums.DataType;
import javax.web.doc.enums.PatternType;

/**
 * Created by rnkrsoft.com on 2018/1/19.
 * 字段定义元信息，用于约束字段
 */
@Data
public class ColumnDefineMetadata {
    /**
     * 关键词名
     */
    String name;
    /**
     * 描述
     */
    String desc;
    /**
     * 类型 只接受
     * String
     * Integer
     * Decimal
     * Date
     */
    DataType type;
    /**
     * 表达式类型，默认正则表达式
     *
     * @return 表达式类型
     */
    PatternType patternType;
    /**
     * 表达式
     *
     * @return 表达式
     */
    String[] pattern;
}
