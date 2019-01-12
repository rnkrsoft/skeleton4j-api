/**
 * RNKRSOFT OPEN SOURCE SOFTWARE LICENSE TERMS ver.1
 * - 氡氪网络科技(重庆)有限公司 开源软件许可条款(版本1)
 * 氡氪网络科技(重庆)有限公司 以下简称Rnkrsoft。
 * 这些许可条款是 Rnkrsoft Corporation（或您所在地的其中一个关联公司）与您之间达成的协议。
 * 请阅读本条款。本条款适用于所有Rnkrsoft的开源软件项目，任何个人或企业禁止以下行为：
 * .禁止基于删除开源代码所附带的本协议内容、
 * .以非Rnkrsoft的名义发布Rnkrsoft开源代码或者基于Rnkrsoft开源源代码的二次开发代码到任何公共仓库,
 * 除非上述条款附带有其他条款。如果确实附带其他条款，则附加条款应适用。
 * <p/>
 * 使用该软件，即表示您接受这些条款。如果您不接受这些条款，请不要使用该软件。
 * 如下所述，安装或使用该软件也表示您同意在验证、自动下载和安装某些更新期间传输某些标准计算机信息以便获取基于 Internet 的服务。
 * <p/>
 * 如果您遵守这些许可条款，将拥有以下权利。
 * 1.阅读源代码和文档
 * 如果您是个人用户，则可以在任何个人设备上阅读、分析、研究Rnkrsoft开源源代码。
 * 如果您经营一家企业，则禁止在任何设备上阅读Rnkrsoft开源源代码,禁止分析、禁止研究Rnkrsoft开源源代码。
 * 2.编译源代码
 * 如果您是个人用户，可以对Rnkrsoft开源源代码以及修改后产生的源代码进行编译操作，编译产生的文件依然受本协议约束。
 * 如果您经营一家企业，不可以对Rnkrsoft开源源代码以及修改后产生的源代码进行编译操作。
 * 3.二次开发拓展功能
 * 如果您是个人用户，可以基于Rnkrsoft开源源代码进行二次开发，修改产生的元代码同样受本协议约束。
 * 如果您经营一家企业，不可以对Rnkrsoft开源源代码进行任何二次开发，但是可以通过联系Rnkrsoft进行商业授予权进行修改源代码。
 * 完整协议。本协议以及开源源代码附加协议，共同构成了Rnkrsoft开源软件的完整协议。
 * <p/>
 * 4.免责声明
 * 该软件按“原样”授予许可。 使用本文档的风险由您自己承担。Rnkrsoft 不提供任何明示的担保、保证或条件。
 * 5.版权声明
 * 本协议所对应的软件为 Rnkrsoft 所拥有的自主知识产权，如果基于本软件进行二次开发，在不改变本软件的任何组成部分的情况下的而二次开发源代码所属版权为贵公司所有。
 */
package javax.web.skeleton4j.page;

import javax.web.doc.DocScanner;
import javax.web.skeleton4j.compile.WebCompilable;
import javax.web.skeleton4j.compile.WebCompile;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.container.WebContainer;
import javax.web.skeleton4j.interfaces.WebInterface;
import javax.web.skeleton4j.menu.WebNode;
import javax.web.skeleton4j.pool.ModulePool;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by rnkrsoft.com on 2017/10/13.
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
     * 一般为product=xxxx&amp;action=xxxx&amp;version=1.0.0
     *
     * @return URL地址
     */
    String getUrl();

    /**
     * 当前页面是否使用权限，包含该页面导入的接口
     * @return 是否使用权限
     */
    boolean isUseAuthority();

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
    List<WebInterface> getInterfaces();

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
}
