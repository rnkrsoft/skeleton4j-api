package javax.web.skeleton4j.element.component;

import javax.web.skeleton4j.element.ReferenceWebElement;
import java.util.Collection;

/**
 * Created by devops4j on 2017/12/15.
 */
public interface WebMenuComponent extends WebComponent, WebFormableComponent {
    void setIcon(String icon);

    /**
     * 图标 字体或者图片路径classpath*:com.devops4j.xxx.png
     */
    String getIcon();

    /**
     * 设置显示名称
     *
     * @param title
     */
    void setText(String title);

    /**
     * 菜单展示名称
     */
    String getText();

    /**
     * 父菜单
     */
    void setParent(ReferenceWebElement Parent);

    /**
     * 父菜单
     */
    ReferenceWebElement getParent();

    /**
     * 子节点
     *
     * @return
     */
    Collection<WebMenuComponent> getNodes();

    /**
     * 增加子节点
     *
     * @param node
     * @return
     */
    WebMenuComponent appendNode(WebMenuComponent... node);
}
