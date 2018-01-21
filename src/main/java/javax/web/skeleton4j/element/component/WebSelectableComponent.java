package javax.web.skeleton4j.element.component;

/**
 * Created by devops4j on 2017/10/18.
 * 可选择的组件
 */
public interface WebSelectableComponent extends WebFormableComponent {
    /**
     * 显示的图标
     *
     * @param icon 图标地址
     */
    void setIcon(String icon);

    /**
     * 显示的图标
     *
     * @return
     */
    String getIcon();

    /**
     * 组合框中的单选或则多选是否选中
     *
     * @return
     */
    boolean isChecked();

    /**
     * 组合框中的单选或者多选是否选中
     *
     * @param checked
     */
    void setChecked(boolean checked);
}
