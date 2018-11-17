package javax.web.skeleton4j.element.component;


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
}
