package javax.web.skeleton4j.element.component.chart;

import javax.web.skeleton4j.element.component.WebComponent;

/**
 * Created by rnkrsoft.com on 2017/12/15.
 * 图组件
 */
public interface WebChartComponent extends WebComponent {
    /**
     * 设置标题
     *
     * @param title 标题
     */
    void setTitle(String title);

    /**
     * 标题
     *
     * @return 标题
     */
    String getTitle();

    /**
     * 配置项的JSON格式
     *
     * @return 配置项的JSON格式
     */
    String getOption();

    /**
     * 配置项的JSON格式
     *
     * @param option 配置项的JSON格式
     */
    void setOption(String option);
}
