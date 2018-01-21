package javax.web.skeleton4j.element.component;

import javax.web.skeleton4j.script.WebScript;

/**
 * Created by devops4j on 2017/10/13.
 * 定义了提示信息展示的付接口
 */
public interface WebMsgBoxComponent extends WebComponent {
    /**
     * 提示标题
     *
     * @return
     */
    String getTitle();

    /**
     * 提示标题
     *
     * @param title
     */
    void setTitle(String title);

    /**
     * 提示信息
     *
     * @return
     */
    String getMessage();

    /**
     * 设置提示信息
     *
     * @param message
     */
    void setMessage(String message);

    /**
     * 生成基于当前消息框的脚本对象
     *
     * @param title   标题
     * @param message 消息
     * @return
     */
    WebScript make(String title, String message);
}
