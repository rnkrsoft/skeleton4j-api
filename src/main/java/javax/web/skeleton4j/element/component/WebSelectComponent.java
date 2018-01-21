package javax.web.skeleton4j.element.component;

import java.util.Collection;

/**
 * Created by devops4j on 2017/12/15.
 * 选择组件，可展示为dropdown的或者平铺的选择组件
 */
public interface WebSelectComponent extends WebFormableComponent, WebGroupableComponent {
    /**
     * 获取选项
     *
     * @return 选项列表
     */
    Collection<WebSelectableComponent> getItems();

    /**
     * 增加选项
     *
     * @param item  选项
     * @return 组件
     */
    WebSelectComponent addItem(WebSelectableComponent item);

    /**
     * 增加项
     *
     * @param id
     * @param label
     * @param value
     * @param checked
     * @return
     */
    WebSelectComponent addItem(String id, String label, String value, Boolean checked);

    /**
     * 增加项
     *
     * @param rows
     * @return
     */
    WebSelectComponent addItems(String[][] rows);

    /**
     * 设置是否为多选
     *
     * @param multiSelect
     */
    void setMultiSelect(boolean multiSelect);

    /**
     * 是否为多选
     *
     * @return 多选
     */
    boolean isMultiSelect();

    /**
     * 设置为下拉模式
     *
     * @param dropdown
     */
    void setDropdown(boolean dropdown);

    /**
     * 是否为下拉模式
     *
     * @return
     */
    boolean isDropdown();
}
