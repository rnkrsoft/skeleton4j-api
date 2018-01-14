package javax.web.skeleton4j.element.component;

/**
 * Created by devops4j on 2018/1/14.
 * 图片组件
 */
public interface WebImageComponent extends WebFormableComponent , WebGroupableComponent{
    /**
     * 图片是否支持缩放
     * @param zoom 是否支持缩放
     */
    void setZoom(boolean zoom);

    /**
     * 是否支持缩放
     * @return 是否支持缩放
     */
    boolean isZoom();

    /**
     * 设置图片展示高度
     * @param displayHeight
     */
    void setDisplayHeight(int displayHeight);

    /**
     * 获取图片展示高度
     * @return
     */
    int getDisplayHeight();

    /**
     * 设置图片展示宽度
     * @param displayWidth
     */
    void setDisplayWidth(int displayWidth);

    /**
     * 获取图片展示宽度
     * @return
     */
    int getDisplayWidth();
}
