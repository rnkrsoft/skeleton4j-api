package javax.web.skeleton4j.style;


import java.util.List;

/**
 * Created by devops4j on 2017/10/12.
 * HTML 样式表封装对象接口
 */
public interface WebStyle {
    /**
     * 获取别名
     * @return 别名
     */
    String getAlias();

    /**
     * 设置别名
     * @param alias 别名
     */
    void setAlias(String alias);
    /**
     * 获取版本号
     * @return 版本号
     */
    String getVersion();

    /**
     * 版本号
     * @param version 版本号
     */
    void setVersion(String version);

    /**
     * 获取文件存放地址
     * 例如classpath*:javax.web.skeleton4j.demo.js或者http://cdn.test.com/demo.js
     * @return 地址
     */
    String getSource();

    /**
     * 设置文件存放地址
     * 例如classpath*:javax.web.skeleton4j.demo.js或者http://cdn.test.com/demo.js
     * @param source 地址
     */
    void setSource(String source);

    /**
     * 获取样式内容
     * @return 样式内容
     */
    String getContent();

    /**
     * 设置样式内容
     * @param content 样式内容
     */
    void setContent(String content);

    /**
     * 是否内联
     * @return 内联
     */
    boolean isInline();

    /**
     * 是否内联
     * @param inline 内联
     */
    void setInline(boolean inline);
    /**
     * 非内联时，转换为服务器访问的地址
     * @return 访问的地址
     */
    String getServerUrl();

    /**
     * 非内联时，转换为服务器访问的地址
     * @param serverUrl 访问的地址
     */
    void setServerUrl(String serverUrl);

    /**
     * 提供此样式的类对象，可能为标注@WebPage的类对象，也可能为标注@WebTheme的类对象
     * @return 提供该样式的类
     */
    String getProviderClass();

    /**
     * 提供此样式的类对象，可能为标注@WebPage的类对象，也可能为标注@WebTheme的类对象
     * @param providerClass 提供该样式的类
     */
    void setProviderClass(String providerClass);

    /**
     * 该样式依赖的其他样式
     * @return 以来样式列表
     */
    List<ReferenceWebStyle> getDependencies();

    /**
     * 是否有内容
     *
     * @return 是否有内容
     */
    boolean hasContent();
}
