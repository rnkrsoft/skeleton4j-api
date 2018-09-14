package javax.web.skeleton4j.element.component;

import java.util.Collection;

/**
 * Created by rnkrsoft.com on 2017/11/9.
 * 确认框组件
 */
public interface WebConfirmBoxComponent extends WebComponent {
    /**
     * 对话框标题
     *
     * @return 对话框标题
     */
    String getTitle();

    /**
     * 对话框标题
     *
     * @param title 对话框标题
     */
    void setTitle(String title);

    /**
     *
     * @return
     */
    String getMessage();

    /**
     *
     * @param message
     */
    void setMessage(String message);
    /**
     * 对话框中的内容是否为只读
     *
     * @return 是否为只读
     */
    boolean isReadonly();

    /**
     * 设置对话框为只读
     *
     * @param readonly 是否为只读
     */
    void setReadonly(boolean readonly);

    /**
     * 增加工具栏
     *
     * @param components 组件
     * @return 对话框
     */
    WebConfirmBoxComponent appendToolbar(WebFormableComponent... components);

    /**
     * 获取工具栏按钮
     *
     * @return 工具栏按钮
     */
    Collection<WebFormableComponent> getToolbar();

    /**
     * 向对话框增加组件元素
     *
     * @param items 元素
     * @return 对话框
     */
    WebConfirmBoxComponent appendItem(WebFormableComponent... items);

    /**
     * 获取对话框中的元素，可能为容器，也可能为组件元素
     *
     * @return 对话框中的元素
     */
    Collection<WebFormableComponent> getItems();
}
