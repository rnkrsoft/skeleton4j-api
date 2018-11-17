package javax.web.skeleton4j.render;

import com.rnkrsoft.io.buffer.ByteBuf;

import javax.web.skeleton4j.config.Skeleton4jConfig;
import javax.web.skeleton4j.element.container.WebContainer;
import javax.web.skeleton4j.menu.WebMenu;
import javax.web.skeleton4j.pool.ModulePool;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Map;

/**
 * Created by rnkrsoft.com on 2017/9/30.
 * 上下文
 */
public interface WebContext {
    /**
     * 获取当前的配置
     * @return
     */
    Skeleton4jConfig getConfig();
    /**
     * 渲染时传入的参数
     *
     * @return 参数
     */
    Map<String, Object> getParams();

    /**
     * 模块池
     *
     * @return 模块池
     */
    ModulePool getModulePool();

    /**
     * 产品编号
     *
     * @return 产品编号
     */
    String getProduct();

    /**
     * 产品描述
     *
     * @return 产品描述
     */
    String getProductDesc();

    /**
     * 功能编号
     *
     * @return 功能编号
     */
    String getAction();

    /**
     * 功能描述
     *
     * @return 功能描述
     */
    String getActionDesc();

    /**
     * 操作编号
     *
     * @return 操作编号
     */
    String getSubAction();

    /**
     * 操作描述
     *
     * @return 操作描述
     */
    String getSubActionDesc();

    /**
     * 主题名
     *
     * @return 主题名
     */
    String getTheme();

    /**
     * 是否显示侧边栏
     * @return
     */
    boolean isSidebar();

    /**
     * 服务器根路径
     *
     * @return 服务器根路径
     */
    String getServerRootPath();

    /**
     * 系统代码
     *
     * @return 系统代码
     */
    String getApp();

    /**
     * 系统描述
     *
     * @return 系统描述
     */
    String getAppDesc();

    /**
     * 用户编号
     *
     * @return 用户编号
     */
    String getUserId();

    /**
     * 用户名
     *
     * @return 用户名
     */
    String getUserName();

    /**
     * 用户昵称
     *
     * @return 用户昵称
     */
    String getNickName();

    /**
     * 用户头像
     *
     * @return 用户头像
     */
    String getUserAvatar();

    String getUserBranchId();
    String getUserBranchName();
    String getUserCityId();
    String getUserCityName();

    String getLogoutUrl();
    /**
     * 渲染产生的脚本对象
     *
     * @return 脚本对象
     */
    Collection<WebScript> getScripts();

    /**
     * 渲染产生的样式对象
     *
     * @return 样式对象
     */
    Collection<WebStyle> getStyles();

    /**
     * 当前菜单
     *
     * @return 当前菜单
     */
    Collection<WebMenu> getMenus();

    /**
     * 容器列表
     *
     * @return 容器列表
     */
    Collection<WebContainer> getContainers();

    /**
     * 渲染产生的代码
     *
     * @return 代码
     */
    ByteBuf getCodes();

    /**
     * 增加代码
     *
     * @param data 代码
     * @return 上下文
     */
    WebContext codes(byte[] data);

    /**
     * 增加代码
     *
     * @param newBuffer 代码
     * @return 上下文
     */
    WebContext codes(ByteBuffer newBuffer);

    /**
     * 增加代码
     *
     * @param lines 代码
     * @return 上下文
     */
    WebContext codes(String... lines);

    /**
     * 增加代码带缩进量
     * @param indent 缩进量
     * @param lines 代码行
     * @return 上下文
     */
    WebContext codes(int indent, String... lines);

    WebContext append(int indent, String ...lines);
    /**
     * 使用模块池中已注册的脚本
     *
     * @param alias 别名
     * @return 上下文
     */
    WebContext enqueueScript(String theme, String alias);

    /**
     * 使用模块池中已注册的样式
     *
     * @param alias 别名
     * @return 上下文
     */
    WebContext enqueueStyle(String theme, String alias);

    /**
     * 使用模块池中已注册的脚本
     *
     * @param alias   别名
     * @param version 版本号
     * @return 上下文
     */
    WebContext enqueueScript(String theme, String alias, String version);

    /**
     * 使用模块池中已注册的样式
     *
     * @param alias   别名
     * @param version 版本号
     * @return 上下文
     */
    WebContext enqueueStyle(String theme, String alias, String version);

    /**
     * 向上下文增加渲染产生的脚本对象，不向模块池注册
     *
     * @param script 脚本对象
     * @return 上下文
     */
    WebContext enqueueScript(WebScript script);

    /**
     * 向上下文增加渲染产生的样式对象，不向模块池注册
     *
     * @param style 样式对象
     * @return 上下文
     */
    WebContext enqueueStyle(WebStyle style);

    /**
     * 设置展示的容器
     *
     * @param container 容器
     * @return
     */
    WebContext containers(WebContainer... container);
}
