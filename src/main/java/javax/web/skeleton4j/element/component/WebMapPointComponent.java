package javax.web.skeleton4j.element.component;

/**
 * Created by rnkrsoft.com on 2018/11/11.
 * 地图点组件，用于对地图上标注的点进行展示
 */
public interface WebMapPointComponent extends WebFormableComponent{
    /**
     * 高度
     *
     * @return 高度
     */
    int getHeight();

    /**
     * 高度
     *
     * @param height 高度
     */
    void setHeight(int height);

    /**
     * 宽度
     *
     * @return 宽度
     */
    int getWidth();

    /**
     * 设置宽度
     *
     * @param width 宽度
     */
    void setWidth(int width);
}
