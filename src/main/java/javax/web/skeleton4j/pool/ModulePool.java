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
package javax.web.skeleton4j.pool;

import javax.web.doc.DocScanner;
import javax.web.doc.InterfaceInfo;
import javax.web.skeleton4j.config.Skeleton4jConfig;
import javax.web.skeleton4j.enums.InterfaceCall;
import javax.web.skeleton4j.menu.WebMenu;
import javax.web.skeleton4j.menu.WebNode;
import javax.web.skeleton4j.module.WebModule;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.remote.InterfaceMetadata;
import javax.web.skeleton4j.render.Skeleton4jPageRenderService;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import java.util.List;
import java.util.Map;

/**
 * 模块池
 */
public interface ModulePool {
    ModulePool config(Skeleton4jConfig config);

    /**
     * 获取模块池
     * @return 模块池
     */
    DocScanner getDocScanner();

    /**
     * 设置扫描器
     * @param docScanner 扫描器
     * @return 模块池
     */
    ModulePool docScanner(DocScanner docScanner);

    /**
     * 创建一个接口
     * @param product 产品代码
     * @param action 功能代码
     * @param name 接口名
     * @param page 页面
     * @param call 调用方式
     * @param interfaceInfo 接口信息
     * @return 接口元信息
     */
    InterfaceMetadata createInterface(String product, String action, String name, WebPage page, InterfaceCall call, InterfaceInfo interfaceInfo);

    /**
     * 创建一个页面对象
     * @param webPageClass 页面类
     * @param title 标题
     * @param product 产品代码
     * @param action 功能代码
     * @param version 版本号
     * @param node 菜单节点
     * @param author 作者
     * @return 页面类
     */
    WebPage createPage(Class webPageClass, String title, String product, String action, String version, WebNode node, String author);

    /**
     * 创建一个模块
     * @param packagePath 包路径
     * @param name 模块名
     * @param desc 模块描述
     * @return 模块
     */
    WebModule createModule(String packagePath, String name, String desc);

    /**
     * 船建一个样式对象
     * @param theme 主题名
     * @param alias 别名
     * @param version 版本号
     * @return 样式对象
     */
    WebStyle createStyle(String theme, String alias, String version);

    /**
     * 船建一个脚本对象
     * @param theme 主题名
     * @param alias 别名
     * @param version 版本号
     * @return 脚本对象
     */
    WebScript createScript(String theme, String alias, String version);

    /**
     * 查询页面类
     *
     * @param product               产品编号
     * @param action                功能编号
     * @param version               版本号
     * @param ifNotExistsReturnNull 不存在是否返回null
     * @return 页面类
     */
    WebPage lookupPage(String product, String action, String version, boolean ifNotExistsReturnNull);

    /**
     * 获取所有页面类
     *
     * @return 页面类
     */
    List<WebPage> pages();

    /**
     * 增加页面类
     *
     * @param webPage 页面类
     * @return 页面池
     */
    ModulePool addPage(WebPage webPage);

    /**
     * 查找脚本
     *
     * @param theme   主题名
     * @param alias   别名
     * @param version 版本号
     * @return 脚本对象
     */
    WebScript lookupScript(String theme, String alias, String version);

    /**
     * 增加一个脚本到模块池
     * @param script 脚本对象
     * @return 模块池
     */
    ModulePool addScript(WebScript script);

    /**
     * 获取名称能够匹配的脚本对象，版本号根据字典排列取最大
     * @param theme 主题名
     * @param names 脚本名称数组
     * @return 脚本列表
     */
    List<WebScript> scripts(String theme, String... names);

    /**
     * 增加一个样式到模块池
     * @param style 样式对象
     * @return 模块池
     */
    ModulePool addStyle(WebStyle style);

    /**
     * 查找指定别名和版本号的样式对象
     * @param theme   主题名
     * @param alias 别名
     * @param version 版本号
     * @return 样式对象
     */
    WebStyle lookupStyle(String theme, String alias, String version);

    /**
     * 获取名称能够匹配的样式对象，版本号根据字典排列取最大
     * @param theme 主题名
     * @param names 样式名称数组
     * @return 样式列表
     */
    List<WebStyle> styles(String theme, String... names);

    /**
     * 查找菜单节点
     * @param name 节点名
     * @return 菜单节点
     */
    WebNode lookupNode(String name);

    /**
     * 获取菜单节点列表
     * @return 菜单节点列表
     */
    List<WebNode> nodes();

    /**
     * 增加菜单节点
     * @param node 节点
     * @return 模块池
     */
    ModulePool addNode(WebNode node);

    /**
     * 查找菜单
     * @param name 菜单名
     * @return 菜单项
     */
    WebMenu lookupMenu(String name);

    /**
     * 菜单列表
     * @return 菜单列表
     */
    List<WebMenu> menus();

    /**
     * 增加菜单项
     * @param menu 菜单项
     * @return 模块池
     */
    ModulePool addMenu(WebMenu menu);

    /**
     * 根据模块名查找模块
     * @param name 模块名
     * @return 模块对象
     */
    WebModule lookupModule(String name);

    /**
     * 模块列表
     * @return 模块列表
     */
    List<WebModule> modules();

    /**
     * 增加模块
     * @param module 模块对象
     * @return 模块池
     */
    ModulePool addModule(WebModule module);

    /**
     * 通过坐标查找接口元信息
     * @param product 产品名
     * @param action 功能名
     * @param subAction 操作名
     * @param ifNotExistsReturnNull 如果不存在是否返回null，否则抛出异常
     * @return 接口元信息
     */
    InterfaceMetadata lookupInterface(String product, String action, String subAction, boolean ifNotExistsReturnNull);

    /**
     * 获取导入的接口元信息列表
     * @return 列表
     */
    List<InterfaceMetadata> importInterfaces();

    /**
     * 增加接口元信息对象
     * @param interfaceMetadata 接口元信息
     * @return 增加接口元信息
     */
    ModulePool addInterface(InterfaceMetadata interfaceMetadata);

    /**
     * 列出所有导入的接口元信息
     * @return 接口元信息
     */
    Map<InterfaceInfo, List<InterfaceMetadata>> listImportInterfaces();

    /**
     * 全部清理
     *
     * @return 模块池
     */
    ModulePool clean();

    /**
     * 根据别名和版本号移除脚本对象
     * @param theme 主题名
     * @param alias 别名
     * @param version 版本号
     * @return 模块池
     */
    ModulePool removeScript(String theme, String alias, String version);

    /**
     * 根据别名和版本号移除
     * @param theme 主题名
     * @param alias 别名
     * @param version 版本号
     * @return 模块池
     */
    ModulePool removeStyle(String theme, String alias, String version);

    /**
     * 根据产品名，功能名和版本号进行节点移除
     * @param product 产品名
     * @param action 功能名
     * @param version 版本号
     * @return 模块池
     */
    ModulePool removeNode(String product, String action, String version);

    /**
     * 根据模块键值进行移除
     * @param key 模块键值
     * @return 模块池
     */
    ModulePool removeModule(String key);

    /**
     * 根据菜单键值进行移除
     * @param key 菜单键值
     * @return 模块池
     */
    ModulePool removeMenu(String key);

    /**
     * 根据菜单节点键值进行移除
     * @param key 菜单节点键值
     * @return 模块池
     */
    ModulePool removeNode(String key);

    /**
     * 根据产品名，功能名和操作名移除接口
     * @param product 产品名
     * @param action 功能名
     * @param subAction 操作名
     * @return 模块池
     */
    ModulePool removeInterface(String product, String action, String subAction);

    /**
     * 移除指定的页面
     *
     * @param product 产品编号
     * @param action  功能编号
     * @param version 版本号
     * @return 页面池
     */
    ModulePool removePage(String product, String action, String version);

    /**
     * 注册
     * @param theme 主题
     * @param pageRenderServiceClass 页面渲染类
     * @return 莫块池
     */
    ModulePool registerPageRenderServiceClass(String theme, Class<? extends Skeleton4jPageRenderService> pageRenderServiceClass);

    /**
     * 获取主题对应的页面渲染服务
     * @param theme 主题名
     * @return 渲染服务
     */
    Skeleton4jPageRenderService getPageRenderService(String theme);
}
