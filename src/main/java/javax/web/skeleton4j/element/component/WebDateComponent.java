package javax.web.skeleton4j.element.component;

/**
 * Created by devops4j on 2017/12/7.
 * 日期选择组件
 */
public interface WebDateComponent extends WebFormableComponent , WebGroupableComponent{
    /**
     * 获取文本格式
     *
     * @return
     */
    String getFormat();

    /**
     * 设置日期格式
     *
     * @param format
     */
    void setFormat(String format);
}
