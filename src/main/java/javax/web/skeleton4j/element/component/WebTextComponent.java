package javax.web.skeleton4j.element.component;


/**
 * Created by rnkrsoft.com on 2017/10/13.
 * 文本框组件
 */
public interface WebTextComponent extends WebFormableComponent, WebGroupableComponent {
    /**
     * 是否为唯一键
     *
     * @return
     */
    boolean isUnique();

    /**
     * 设置是否为唯一键
     *
     * @param unique
     */
    void setUnique(boolean unique);

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
