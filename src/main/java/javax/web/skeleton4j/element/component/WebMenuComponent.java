package javax.web.skeleton4j.element.component;

import javax.web.skeleton4j.element.ReferenceWebElement;
import java.util.Collection;

/**
 * Created by devops4j on 2017/12/15.
 */
public interface WebMenuComponent extends WebComponent, WebFormableComponent {
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
     * 设置显示名称
     *
     * @param title 显示名称
     */
    void setText(String title);

    /**
     * 菜单展示名称
     * @return 显示名称
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
