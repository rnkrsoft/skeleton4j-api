package javax.web.skeleton4j.element.component;

import javax.web.skeleton4j.element.ReferenceWebElement;
import java.util.Collection;

/**
 * Created by rnkrsoft.com on 2017/11/9.
 * 对话框组件
 */
public interface WebDialogBoxComponent extends WebComponent {
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
     * @param components 工具栏组件
     * @return 对话框
     */
    WebDialogBoxComponent appendToolbar(WebFormableComponent... components);

    /**
     * 获取工具栏按钮
     *
     * @return 工具栏组件
     */
    Collection<WebFormableComponent> getToolbar();

    /**
     * 向对话框增加引用字段
     * @param items 字段
     * @return 对话框
     */
    WebDialogBoxComponent appendReferenceItem(ReferenceWebElement... items);

    /**
     * 获取对话框中的引用字段，引用字段都为字段值，无组合框和表格类型
     * @return 对话框中的引用字段集合
     */
    Collection<ReferenceWebElement> getReferenceItems();
    /**
     * 向对话框增加组件元素
     *
     * @param items 元素
     * @return 对话框
     */
    WebDialogBoxComponent appendItem(WebFormableComponent... items);

    /**
     * 获取对话框中的元素，可能为容器，也可能为组件元素
     *
     * @return 对话框中的元素
     */
    Collection<WebFormableComponent> getItems();
}
