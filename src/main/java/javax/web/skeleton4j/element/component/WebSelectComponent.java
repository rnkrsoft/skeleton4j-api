package javax.web.skeleton4j.element.component;

import java.util.Collection;

/**
 * Created by devops4j on 2017/12/15.
 */
public interface WebSelectComponent extends WebFormableComponent , WebGroupableComponent{
    /**
     * 获取选项
     *
     * @return
     */
    Collection<WebSelectableComponent> getItems();

    /**
     * 增加项
     *
     * @param item
     * @return
     */
    WebSelectComponent addItem(WebSelectableComponent item);

    /**
     * 增加项
     * @param id
     * @param label
     * @param value
     * @param checked
     * @return
     */
    WebSelectComponent addItem(String id, String label, String value, Boolean checked);

    /**
     * 增加项
     * @param rows
     * @return
     */
    WebSelectComponent addItems(String[][] rows);

    /**
     * 设置是否为多选
     * @param multiSelect
     */
    void setMultiSelect(boolean multiSelect);
    /**
     * 是否为多选
     * @return 多选
     */
    boolean isMultiSelect();
}
