package javax.web.skeleton4j.page;

import javax.web.doc.DocScanner;
import javax.web.skeleton4j.compile.WebCompilable;
import javax.web.skeleton4j.compile.WebCompile;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.container.WebContainer;
import javax.web.skeleton4j.menu.WebNode;
import javax.web.skeleton4j.pool.ModulePool;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.remote.WebInterface;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by devops4j on 2017/10/13.
 * 用于包装HTML页面
 */

public interface WebPage extends WebCompilable, WebCompile {
    /**
     * 获取页面类所在的模块池
     * @return 模块池
     */
    ModulePool getModulePool();
    /**
     * 获取这个页面类可以访问的URL地址
     * 一般为product=xxxx&action=xxxx&version=1.0.0
     *
     * @return URL地址
     */
    String getUrl();

    /**
     * Web组件注册表
     *
     * @return 注册表对象
     */
    WebComponentRegistry getComponentRegistry();

    /**
     * 获取当前页面关联的文档扫描器
     *
     * @return 文档扫描器
     */
    DocScanner getDocScanner();

    /**
     * 获取页面上注册的所有接口
     *
     * @return 接口列表
     */
    List<WebInterface> getAjaxInterfaces();

    /**
     * 获取当前页面所有的web元素引用，通过ID查询引用时
     *
     * @return 所有的web元素引用
     */
    Map<String, WebElement> getElements();

    /**
     * 包路径，如果非WebPage类生成，则该包名为服务类所在包路径
     *
     * @return 包路径
     */
    String getPackagePath();

    /**
     * 标注@WebPage注解的类名
     *
     * @return 类名
     */
    String getWebPageClassName();

    /**
     * 标注@WebPage注解的类
     *
     * @return 类
     */
    Class getWebPageClass();

    /**
     * 产品代码
     *
     * @return 产品代码
     */
    String getProduct();

    /**
     * 产品描述
     * 通常代理给菜单
     * @return 产品描述
     */
    String getProductDesc();

    /**
     * 功能代码
     *
     * @return 功能代码
     */
    String getAction();
    /**
     * 功能描述
     *
     * @return 功能描述
     */
    String getActionDesc();
    /**
     * 页面版本号,如果存在多个版本号，则会生成多个菜单；页面name的唯一标识为name + ":" + version,展示菜单名称为name(version)
     *
     * @return 版本号
     */
    String getVersion();

    /**
     * 页面对应的子菜单
     *
     * @return 子菜单
     */
    WebNode getNode();

    /**
     * 作者
     *
     * @return 作者
     */
    String getAuthor();

    /**
     * 页面显示在浏览器栏的标题
     *
     * @return 浏览器栏的标题
     */
    String getTitle();

    /**
     * 页面中引用的样式,分别来自两部分，组件导入的样式和组件渲染生成的样式
     *
     * @return 样式
     */
    Collection<WebStyle> getStyles();

    /**
     * 页面中引用的脚本,分别来自两部分，组件导入的脚本和组件渲染生成的脚本
     *
     * @return 脚本
     */
    Collection<WebScript> getScripts();

    /**
     * 增加脚本
     * @param script 脚本
     * @return 页面类
     */
    WebPage append(WebScript script);
    /**
     * 增加样式
     * @param style 样式
     * @return 页面类
     */
    WebPage append(WebStyle style);
    /**
     * 增加容器
     * @param container 容器
     * @return 页面类
     */
    WebPage append(WebContainer container);
    /**
     * 增加接口元信息
     * @param metadata 接口元信息
     * @return 页面类
     */
    WebPage append(NamespaceInterfaceMetadata metadata);
    /**
     * 页面中引用的脚本,分别来自两部分，组件导入的脚本和组件渲染生成的脚本，所有脚本都是与主题有关的
     *
     * @param theme 主题名
     * @return 脚本
     */
    Collection<WebScript> getScripts(String theme);

    /**
     * 页面中引用的样式,分别来自两部分，组件导入的样式和组件渲染生成的样式，所有样式都是与主题有关的
     *
     * @param theme 主题名
     * @return 样式
     */
    Collection<WebStyle> getStyles(String theme);

    /**
     * 页面中的容器
     *
     * @return 容器
     */
    Collection<WebContainer> getContainers();

    /**
     * 导入的接口
     *
     * @return 接口列表
     */
    Collection<NamespaceInterfaceMetadata> getImports();

    /**
     * 获取渲染生成的HTML代码
     *
     * @return ByteBuffer对象
     */
    ByteBuffer getCodes();

    /**
     * 通过HTML ID或者字段ID查询组件
     *
     * @param id           HTML ID或者字段ID
     * @param elementClass 组件类型
     * @param <T>          组件类型
     * @return 组件
     */
    <T extends WebElement> T lookup(String id, Class<T> elementClass);

    /**
     * 通过HTML ID或者字段ID查询组件,查询从source开始平级查起，组件向外
     *
     * @param source       起点元素
     * @param id           HTML ID或者字段ID
     * @param elementClass 组件类型
     * @param <T>          组件类型
     * @return 组件
     */
    <T extends WebElement> T lookup(WebElement source, String id, Class<T> elementClass);

    /**
     * 是否使用权限访问
     *
     * @return 返回真，则不使用权限校验
     */
    boolean isNotUseAuthority();
}
