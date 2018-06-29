package javax.web.skeleton4j.element.component;


/**
 * Created by rnkrsoft.com on 2017/10/13.
 */
public interface WebButtonComponent extends WebFormableComponent {
    /**
     * 图标 字体font:xxxx;图片路径classpath*:com.rnkrsoft.xxx.png;class选择器class:fa fa-edit
     * @param icon 图标
     */
    void setIcon(String icon);

    /**
     * 图标 字体font:xxxx;图片路径classpath*:com.rnkrsoft.xxx.png;class选择器class:fa fa-edit
     * @return 图标
     */
    String getIcon();

    /**
     * 获取按钮文字
     *
     * @return 按钮文字
     */
    String getText();

    /**
     * 设置按钮文字
     *
     * @param text 按钮文字
     */
    void setText(String text);
}
