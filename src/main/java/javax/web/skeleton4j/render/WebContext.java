package javax.web.skeleton4j.render;

import javax.web.skeleton4j.buffer.ByteBuf;
import javax.web.skeleton4j.element.container.WebContainer;
import javax.web.skeleton4j.menu.WebMenu;
import javax.web.skeleton4j.pool.ModulePool;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import java.nio.ByteBuffer;
import java.util.Collection;

/**
 * Created by devops4j on 2017/9/30.
 * 上下文
 */
public interface WebContext {

    ModulePool getModulePool();

    String getApp();

    String getProduct();

    String getProductDesc();

    String getAction();

    String getActionDesc();

    String getSubAction();

    String getTheme();

    String getAjaxUrl();

    String getPageUrl();

    String getSystemDesc();

    String getUserId();

    String getUserName();

    String getNickName();

    String getGroup();

    String getUserAvatar();

    Collection<WebScript> getScripts();

    Collection<WebStyle> getStyles();

    Collection<WebMenu> getMenus();

    Collection<WebContainer> getContainers();

    ByteBuf getCodes();

    WebContext codes(byte[] data);


    WebContext codes(ByteBuffer newBuffer);

    WebContext codes(String... lines);

    WebContext enqueueScript(String alias);

    WebContext enqueueStyle(String alias);

    WebContext enqueueScript(String alias, String version);

    WebContext enqueueStyle(String alias, String version);

    WebContext enqueueScript(WebScript script);

    WebContext enqueueStyle(WebStyle style);

    /**
     * 设置展示的容器
     *
     * @param container 容器
     * @return
     */
    WebContext containers(WebContainer... container);
}
