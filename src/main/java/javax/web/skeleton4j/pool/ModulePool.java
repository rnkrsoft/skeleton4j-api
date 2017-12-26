package javax.web.skeleton4j.pool;

import javax.web.doc.InterfaceInfo;
import javax.web.skeleton4j.menu.WebMenu;
import javax.web.skeleton4j.menu.WebNode;
import javax.web.skeleton4j.module.WebModule;
import javax.web.skeleton4j.remote.WebInterfaceMetadata;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import java.util.List;
import java.util.Map;


public interface ModulePool {

    WebScript script(String alias, String version);

    WebStyle style(String alias, String version);

    List<WebStyle> styles(String... names);

    ModulePool addStyle(WebStyle style);

    List<WebScript> scripts(String... names);

    ModulePool addScript(WebScript script);

    ModulePool addNode(WebNode node);

    List<WebNode> nodes();

    ModulePool addMenu(WebMenu menu);

    List<WebMenu> menus();

    WebMenu menu(String mark);

    WebNode node(String mark);

    ModulePool addModule(WebModule module);

    WebModule lookupModule(String name);

    ModulePool addInterface(WebInterfaceMetadata remoteInterfaceMetadata);

    WebInterfaceMetadata lookupInterface(String product, String action, String subAction);

    Map<InterfaceInfo, List<WebInterfaceMetadata>> listImportInterfaces();

    List<WebInterfaceMetadata> getImportInterfaces();

    List<WebModule> listModules();

    ModulePool clean();
}
