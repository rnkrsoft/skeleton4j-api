package javax.web.skeleton4j.element.component;

/**
 * Created by rnkrsoft.com on 2017/12/7.
 * 定义树图结构
 */
public interface WebTreeComponent extends WebFormableComponent, WebGroupableComponent {
    /**
     * 设置是否为多选
     *
     * @param multiple
     */
    void setMultiple(boolean multiple);

    /**
     * 是否为多选
     *
     * @return 多选
     */
    boolean isMultiple();

    /**
     * 设置树图展开
     *
     * @param expand
     */
    void setExpand(boolean expand);

    /**
     * 树图是否为展开
     *
     * @return
     */
    boolean isExpand();

    /**
     * 设置为下拉模式,如果不是下拉模式则为ListView
     *
     * @param dropdown 下拉模式
     */
    void setDropdown(boolean dropdown);

    /**
     * 是否为下拉模式,如果不是下拉模式则为ListView
     *
     * @return 下拉模式
     */
    boolean isDropdown();

}
