package javax.web.skeleton4j.element.component;


/**
 * Created by devops4j on 2017/10/13.
 */
public interface WebButtonComponent extends WebFormableComponent {
    /**
     * 获取按钮文字
     * @return
     */
    String getText();

    /**
     * 设置按钮文字
     * @param text
     */
    void setText(String text);
}
