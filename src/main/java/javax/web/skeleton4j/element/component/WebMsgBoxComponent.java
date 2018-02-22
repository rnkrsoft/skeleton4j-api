package javax.web.skeleton4j.element.component;

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
     * 超时自动关闭时间秒数
     * @param timeoutSec 秒数
     */
    void setTimeoutSec(int timeoutSec);

    /**
     * 获取超时自动关闭时间秒数
     * @return
     */
    int getTimeoutSec();
}
