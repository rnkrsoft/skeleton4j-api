package javax.web.skeleton4j.element.container;

import javax.web.skeleton4j.element.component.WebMenuComponent;
import java.util.Collection;

/**
 * Created by devops4j on 2017/10/20.
 * 头部容器接口
 */
public interface WebHeaderContainer extends WebContainer {
    /**
     * 获取容器中的菜单组件列表
     *
     * @return 菜单组件列表
     */
    Collection<WebMenuComponent> getMenus();

    /**
     * 向容器中增加菜单
     *
     * @param menu 菜单组件
     * @return 容器引用
     */
    WebHeaderContainer appendMenu(WebMenuComponent... menu);
}
