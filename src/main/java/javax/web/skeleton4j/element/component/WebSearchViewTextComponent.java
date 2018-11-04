package javax.web.skeleton4j.element.component;

import javax.web.doc.ReferenceInterface;

/**
 * Created by rnkrsoft.com on 2018/11/4.
 * 搜索联想文本框
 */
public interface WebSearchViewTextComponent extends WebFormableComponent, WebGroupableComponent {
    /**
     * 获取文本格式
     *
     * @return
     */
    String getFormat();

    /**
     * 设置文本格式
     *
     * @param format
     */
    void setFormat(String format);

    /**
     * 获取搜索接口
     * @return
     */
    ReferenceInterface getSearchInterface();

    /**
     * 设置搜索接口
     * @param referenceInterface 搜索接口
     */
    void setSearchInterface(ReferenceInterface referenceInterface);
}
