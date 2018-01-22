package javax.web.skeleton4j.config;

import java.util.Collection;

/**
 * Created by devops4j on 2017/12/16.
 * 配置对象
 */
public interface Skeleton4jConfig {
    /**
     * 临时输出路径
     */
    String TEMP_OUTPUT_PATH = "tempOutputPath";
    /**
     * 系统编号
     */
    String APP = "app";
    /**
     * 系统描述
     */
    String APP_DESC = "appDesc";
    /**
     * 主题包路径，多个;分割
     */
    String THEME_PACKAGES = "themePackages";
    /**
     * 主题包路径，多个;分割
     */
    String PAGE_PACKAGES = "pagePackages";
    /**
     * 是否扫描子包
     */
    String SCAN_SUB_PACKAGE = "scanSubPackage";
    /**
     * 是否使用本地缓存
     */
    String USE_CACHE = "useCache";
    /**
     * 是否使用开发模式
     */
    String DEV_MODE = "devMode";
    /**
     * 默认主题名
     */
    String DEFAULT_THEME = "defaultTheme";
    /**
     * 是否内联脚本
     */
    String INLINE_SCRIPT = "inlineScript";
    /**
     * 是否内联样式
     */
    String INLINE_STYLE = "inlineStyle";
    /**
     * 权限管理器名
     */
    String AUTHORITY = "authority";
    /**
     * 服务器地址,默认为空
     */
    String SERVER_HOST = "serverHost";
    /**
     * 服务器端口，默认为80
     */
    String SERVER_PORT = "serverPort";
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
     * 向字符串型用分号分割的参数追加参数
     * @param paramName  参数名
     * @param paramValue 参数值
     * @return 配置对象
     */
    Skeleton4jConfig appendItem(String paramName, String paramValue);

    /**
     * 获取数组形式的参数值
     * @param paramName 参数名
     * @return 对参数为用;进行分割的进行拆分
     */
    String[] getArray(String paramName);
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
