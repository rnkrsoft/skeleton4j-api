package javax.web.skeleton4j.element.component;

/**
 * Created by devops4j on 2017/12/7.
 * 定义树图结构
 */
public interface WebTreeComponent extends WebFormableComponent , WebGroupableComponent{
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
