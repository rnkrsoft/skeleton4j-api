package javax.web.skeleton4j.element.component;

/**
 * Created by devops4j on 2017/12/7.
 * 日期选择组件
 */
public interface WebDateComponent extends WebFormableComponent, WebGroupableComponent {
    /**
     * 获取日期格式
     *
     * @return 日期格式
     */
    String getFormat();

    /**
     * 设置日期格式
     *
     * @param format 日期格式
     */
    void setFormat(String format);
}
