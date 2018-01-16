package javax.web.skeleton4j.element.component;


/**
 * Created by devops4j on 2017/10/13.
 */
public interface WebButtonComponent extends WebFormableComponent {
    /**
     * 获取按钮文字
     * @return 按钮文字
     */
    String getText();

    /**
     * 设置按钮文字
     * @param text 按钮文字
     */
    void setText(String text);
}
