package javax.web.doc;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by devops4j on 2018/1/19.
 * 关键词封装
 */
@Getter
public class KeywordResult {
    /**
     * 关键词名
     */
    String name;
    /**
     * 字段定义元信息
     */
    ColumnDefineMetadata metadata;
    /**
     * 使用该关键词的字段
     */
    final Map<String, ElementInfo> columns = new HashMap();

    public KeywordResult(String name, ColumnDefineMetadata metadata) {
        this.name = name;
        this.metadata = metadata;
    }

    /**
     * 增加字段
     *
     * @param column 字段
     * @return 关键词封装
     */
    public KeywordResult addColumn(ElementInfo column) {
        this.columns.put(column.getInterfaceInfo().getFullName() + "." + column.getFullName(), column);
        return this;
    }
}
