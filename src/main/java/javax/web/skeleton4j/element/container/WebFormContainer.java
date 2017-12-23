package javax.web.skeleton4j.element.container;

import javax.web.skeleton4j.element.component.*;
import java.util.Collection;

/**
 * Created by devops4j on 2017/10/20.
 */
public interface WebFormContainer extends WebContentContainer {
    /**
     * 火气容器标题
     *
     * @return
     */
    String getTitle();

    /**
     * 设置容器标题
     *
     * @param title
     */
    void setTitle(String title);

    /**
     * 增加条件栏元素定义
     *
     * @param components
     * @return
     */
    WebFormContainer appendCondition(WebFormableComponent... components);

    /**
     * 获取条件栏元素
     *
     * @return
     */
    Collection<WebFormableComponent> getConditions();

    /**
     * 增加消息框
     *
     * @param components
     * @return
     */
    WebFormContainer appendMsgBox(WebMsgBoxComponent... components);

    /**
     * 获取消息框
     * @return
     */
    Collection<WebMsgBoxComponent> getMsgBoxes();
    /**
     *
     * @param components
     * @return
     */
    WebFormContainer appendHint(WebHintComponent... components);

    /**
     * 获取提示栏元素
     *
     * @return
     */
    Collection<WebHintComponent> getHints();

    /**
     * 向容器中增加对话框组件
     *
     * @param components
     * @return
     */
    WebFormContainer appendDialogBox(WebDialogBoxComponent... components);

    /**
     * 获取确认对话框
     *
     * @return
     */
    Collection<WebConfirmBoxComponent> getConfirmBoxes();
    /**
     * 向容器中增加确认对话框
     *
     * @param components
     * @return
     */
    WebFormContainer appendConfirmBox(WebConfirmBoxComponent... components);

    /**
     * 获取对话框
     *
     * @return
     */
    Collection<WebDialogBoxComponent> getDialogBoxes();
    /**
     * 增加对话框
     * @param components
     * @return
     */
    WebFormContainer appendTable(WebTableComponent... components);

    /**
     * 获取表格区元素
     *
     * @return
     */
    Collection<WebTableComponent> getTables();

    /**
     * 向工具栏注册按钮元素
     *
     * @param components
     * @return
     */
    WebFormContainer appendToolbar(WebFormableComponent... components);

    /**
     * 获取工具栏元素
     *
     * @return
     */
    Collection<WebFormableComponent> getToolbar();

}
