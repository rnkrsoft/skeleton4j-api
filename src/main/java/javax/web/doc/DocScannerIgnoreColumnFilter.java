package javax.web.doc;

import javax.web.doc.enums.ElementSetType;

/**
 * Created by woate on 2018/7/20.
 */
public interface DocScannerIgnoreColumnFilter {
    /**
     * 过滤器能够处理的类型
     *
     * @return 过滤器类型
     */
    ElementSetType getFilterType();
    /**
     *  检测是否匹配忽略过滤器
     * @param fullColumnName 全字段名
     * @return 是否匹配需要过滤的字段
     */
    boolean match(String fullColumnName);
}
