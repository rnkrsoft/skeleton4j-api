package javax.web.skeleton4j.config;

import java.util.Collection;

/**
 * Created by devops4j on 2017/12/16.
 * 配置对象
 */
public interface Skeleton4jConfig {
    /**
     * 列出所有参数的参数名
     *
     * @return 参数名集合
     */
    Collection<String> listParamNames();

    /**
     * 设置参数值
     *
     * @param paramName  参数名
     * @param paramValue 参数值
     * @return 配置对象
     */
    Skeleton4jConfig param(String paramName, String paramValue);

    /**
     * 获取参数
     *
     * @param paramName  参数名
     * @param paramClass 参数类型
     * @param <T>        参数值
     * @return 参数值
     */
    <T> T getParam(String paramName, Class<T> paramClass);

    /**
     * 获取字符串形式的参数
     *
     * @param paramName    参数名
     * @param defaultValue 如果不存在参数时使用的默认值
     * @return 参数值
     */
    String getString(String paramName, String defaultValue);

    /**
     * 获取整形形式的参数
     *
     * @param paramName    参数名
     * @param defaultValue 如果不存在参数时使用的默认值
     * @return 参数值
     */
    Integer getInteger(String paramName, Integer defaultValue);

    /**
     * 获取布尔值形式的参数
     *
     * @param paramName    参数名
     * @param defaultValue 如果不存在参数时使用的默认值
     * @return 参数值
     */
    Boolean getBoolean(String paramName, Boolean defaultValue);
}
