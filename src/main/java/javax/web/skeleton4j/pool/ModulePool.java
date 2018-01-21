package javax.web.skeleton4j.pool;

import javax.web.doc.InterfaceInfo;
import javax.web.skeleton4j.menu.WebMenu;
import javax.web.skeleton4j.menu.WebNode;
import javax.web.skeleton4j.module.WebModule;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.remote.WebInterfaceMetadata;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import java.util.List;
import java.util.Map;

/**
 * 模块池
 */
public interface ModulePool {
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
     * @param alias   别名
     * @param version 版本号
     * @return 脚本对象
     */
    WebScript lookupScript(String alias, String version);

    ModulePool addScript(WebScript script);

    List<WebScript> scripts(String... names);

    WebStyle lookupStyle(String alias, String version);

    List<WebStyle> styles(String... names);

    ModulePool addStyle(WebStyle style);

    WebNode lookupNode(String name);

    List<WebNode> nodes();

    ModulePool addNode(WebNode node);


    WebMenu lookupMenu(String name);

    List<WebMenu> menus();

    ModulePool addMenu(WebMenu menu);


    WebModule lookupModule(String name);

    List<WebModule> modules();

    ModulePool addModule(WebModule module);


    WebInterfaceMetadata lookupInterface(String product, String action, String subAction, boolean ifNotExistsReturnNull);

    List<WebInterfaceMetadata> importInterfaces();

    ModulePool addInterface(WebInterfaceMetadata remoteInterfaceMetadata);


    Map<InterfaceInfo, List<WebInterfaceMetadata>> listImportInterfaces();

    /**
     * 全部清理
     *
     * @return
     */
    ModulePool clean();

    ModulePool removeScript(String alias, String version);

    ModulePool removeStyle(String alias, String version);

    ModulePool removeNode(String product, String action, String version);

    ModulePool removeModule(String key);

    ModulePool removeMenu(String key);

    ModulePool removeNode(String key);

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
}
