package javax.web.skeleton4j.element.component;

import java.util.Collection;

/**
 * Created by devops4j on 2017/12/15.
 * 表单化的表格组件
 */
public interface WebFormableTableComponent extends WebFormableComponent, WebGroupableComponent {
    /**
     * 获取所有定义的字段
     *
     * @return
     */
    Collection<WebFormableComponent> getColumns();

    /**
     * 工具栏组件
     *
     * @return
     */
    Collection<WebFormableComponent> getToolbar();

    /**
     * 增加字段
     *
     * @param column 组件
     * @return
     */
    WebFormableTableComponent addColumn(WebFormableComponent... column);

    /**
     * 增加工具栏组件
     *
     * @param component
     * @return
     */
    WebFormableTableComponent addToolBar(WebFormableComponent... component);

    /**
     * 是否可以进行分页
     *
     * @return
     */
    boolean isPageable();

    /**
     * 设置是否可以分页
     *
     * @param pageable 分页
     */
    void setPageable(boolean pageable);

    /**
     * 表个中的记录是否可以编辑
     *
     * @return
     */
    boolean isEditable();

    /**
     * 表个中的记录是否可以编辑
     *
     * @param editable
     */
    void setEditable(boolean editable);

    /**
     * 表个中的记录是否可以新增
     *
     * @return
     */
    boolean isCreatable();

    /**
     * 表个中的记录是否可以新增
     *
     * @param creatable
     */
    void setCreatable(boolean creatable);

    /**
     * 表个中的记录是否可以删除
     *
     * @return
     */
    boolean isDeletable();

    /**
     * 表个中的记录是否可以删除
     *
     * @param deletable
     */
    void setDeletable(boolean deletable);
}
