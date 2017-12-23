package javax.web.skeleton4j.element.component;

import java.util.Collection;

/**
 * Created by devops4j on 2017/11/9.
 * 确认框组件
 */
public interface WebConfirmBoxComponent extends WebComponent {
    /**
     * 对话框标题
     * @return
     */
    String getTitle();

    /**
     * 对话框标题
     * @param title
     */
    void setTitle(String title);

    /**
     * 对话框中的内容是否为只读
     * @return
     */
    boolean isReadonly();

    /**
     * 设置对话框为只读
     * @param readonly
     */
    void setReadonly(boolean readonly);

    /**
     * 增加工具栏
     *
     * @param components
     * @return
     */
    WebConfirmBoxComponent appendToolbar(WebFormableComponent... components);

    /**
     * 获取工具栏按钮
     *
     * @return
     */
    Collection<WebFormableComponent> getToolbar();

    /**
     * 向对话框增加组件元素
     *
     * @param items 元素
     * @return
     */
    WebConfirmBoxComponent appendItem(WebFormableComponent... items);

    /**
     * 获取对话框中的元素，可能为容器，也可能为组件元素
     *
     * @return
     */
    Collection<WebFormableComponent> getItems();
}
