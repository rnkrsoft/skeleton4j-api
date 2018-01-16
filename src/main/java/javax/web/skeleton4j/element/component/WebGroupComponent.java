package javax.web.skeleton4j.element.component;

import java.util.Collection;

/**
 * Created by devops4j on 2017/10/18.
 * 分组组件
 */
public interface WebGroupComponent extends WebFormableComponent, WebGroupableComponent {
    /**
     * 获取选项
     *
     * @return
     */
    Collection<WebGroupableComponent> getItems();

    /**
     * 增加项
     *
     * @param item
     * @return
     */
    WebGroupComponent addItem(WebGroupableComponent item);
}
