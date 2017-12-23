package javax.web.skeleton4j.element.component.chart;

import javax.web.skeleton4j.element.component.WebComponent;

/**
 * Created by devops4j on 2017/12/15.
 * 图组件
 */
public interface WebChartComponent extends WebComponent {
    /**
     * 设置标题
     * @param title
     */
    void setTitle(String title);

    /**
     * 标题
     * @return
     */
    String getTitle();

    /**
     * 配置项的JSON格式
     * @return
     */
    String getOption();

    /**
     * 配置项的JSON格式
     * @param option
     */
    void setOption(String option);
}
