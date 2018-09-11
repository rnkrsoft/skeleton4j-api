package javax.web.skeleton4j.element.component;

import java.util.Collection;

/**
 * Created by rnkrsoft.com on 2017/10/28.
 * 表格组件
 */
public interface WebTableComponent extends WebComponent {
    /**
     * 获取所有定义的字段
     *
     * @return
     */
    Collection<WebFormableComponent> getColumns();

    /**
     * 获取唯一键字段
     *
     * @return
     */
    WebFormableComponent getUniqueColumn();

    /**
     * 操作区组件,operates的实例为WebButtonComponent,WebMenuComponent
     *
     * @return
     */
    Collection<WebFormableComponent> getOperates();

    /**
     * 增加唯一键
     *
     * @param uniqueColumn
     * @return
     */
    void setUniqueColumn(WebFormableComponent uniqueColumn);

    /**
     * 增加字段
     *
     * @param columns 组件
     * @return
     */
    WebTableComponent addColumn(WebFormableComponent... columns);

    /**
     * 操作区组件,operates的实例为WebButtonComponent,WebMenuComponent
     *
     *
     * @param operates
     * @return
     */
    WebTableComponent addOperate(WebFormableComponent... operates);

    /**
     * 向容器中增加对话框组件
     *
     * @param components
     * @return
     */
    WebTableComponent appendDialogBox(WebDialogBoxComponent... components);

    /**
     * 是否可以进行分页
     *
     * @return
     */
    boolean isPageable();

    /**
     * 是否可以进行分页
     *
     * @param pageable
     */
    void setPageable(boolean pageable);


    /**
     * 是否初始化查询数据
     *
     * @return
     */
    boolean isInitQuery();

    /**
     * 是否初始化查询数据
     *
     * @param initQuery
     */
    void setInitQuery(boolean initQuery);
}
