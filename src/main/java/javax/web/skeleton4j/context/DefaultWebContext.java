package javax.web.skeleton4j.context;

import com.rnkrsoft.io.buffer.ByteBuf;
import com.rnkrsoft.logtrace4j.ErrorContextFactory;
import com.rnkrsoft.utils.StringUtils;
import lombok.Data;

import javax.web.skeleton4j.authority.AuthorityService;
import javax.web.skeleton4j.config.Skeleton4jConfig;
import javax.web.skeleton4j.element.container.WebContainer;
import javax.web.skeleton4j.menu.WebMenu;
import javax.web.skeleton4j.pool.ModulePool;
import javax.web.skeleton4j.render.WebContext;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import java.nio.ByteBuffer;
import java.util.*;

/**
 * Created by rnkrsoft.com on 2017/9/30.
 * 上下文
 */
@Data
public class DefaultWebContext implements WebContext{
    ModulePool modulePool;
    AuthorityService authorityService;
    /**
     * 配置
     */
    Skeleton4jConfig config;

    final Map<String, Object> params = new HashMap();
    /**
     * 进行操作的模块，例如system
     */
    String app;
    /**
     * 产品代码
     */
    String product;
    /**
     * 产品描述
     */
    String productDesc;
    /**
     * 功能代码
     */
    String action;
    /**
     * 功能描述
     */
    String actionDesc;
    /**
     * 操作代码
     */
    String subAction;
    /**
     * 操作描述
     */
    String subActionDesc;
    /**
     * 主题
     */
    String theme;
    /**
     * 是否显示侧边栏
     */
    boolean sidebar = false;
    /**
     * 服务器地址
     * http://localhost:80/
     */
    String serverRootPath;
    /**
     * 系统描述
     */
    String appDesc;
    /**
     * 用户号
     */
    String userId;
    /**
     * 用户名
     */
    String userName;
    /**
     * 昵称
     */
    String nickName;
    String userBranchId;
    String userBranchName;
    String userCityId;
    String userCityName;
    String logoutUrl;
    String fileStoreUrl;
    /**
     * 用户头像
     */
    String userAvatar;
    /**
     * 脚本队列
     */
    final Queue<WebScript> scripts = new LinkedList();
    /**
     * 样式队列
     */
    final Queue<WebStyle> styles = new LinkedList();
    /**
     * 菜单
     */
    final Queue<WebMenu> menus = new LinkedList();
    /**
     * 进行操作的容器
     */
    final Queue<WebContainer> containers = new LinkedList();

    ByteBuf codes;

    public DefaultWebContext(WebContext ctx){
        this();
        config = ctx.getConfig();
        app = ctx.getApp();
        product = ctx.getProduct();
        action = ctx.getAction();
        subAction = ctx.getSubAction();
        theme = ctx.getTheme();
        serverRootPath = ctx.getServerRootPath();
        appDesc = ctx.getAppDesc();
        scripts.addAll(ctx.getScripts());
        styles.addAll(ctx.getStyles());
        menus.addAll(ctx.getMenus());
        containers.addAll(ctx.getContainers());
        nickName = ctx.getNickName();
    }

    public DefaultWebContext() {
        this.codes = ByteBuf.allocate(1024).autoExpand(true);
    }


    public WebContext codes(byte[] data) {
        codes.put(data);
        return this;
    }


    public WebContext codes(ByteBuffer newBuffer) {
        codes.put(newBuffer);
        return this;
    }
    public WebContext codes(String... lines) {
        return codes(0, lines);
    }

    @Override
    public WebContext codes(int indent, String... lines) {
        String space = StringUtils.fill("", true, ' ', indent);
        for (String line : lines){
            codes.put("UTF-8", line == null ? space : (space +line));
        }
        return this;
    }

    @Override
    public WebContext append(int indent, String... lines) {
        String space = StringUtils.fill("", true, ' ', indent);
        for (String line : lines){
            codes.put("UTF-8", line == null ? space : (space +line), "\n");
        }
        return this;
    }

    @Override
    public WebContext enqueueScript(String theme, String alias) {
        return null;
    }

    @Override
    public WebContext enqueueStyle(String theme, String alias) {
        return null;
    }

    public WebContext enqueueScript(String alias) {
        return enqueueScript(alias, "1.0.0");
    }

    public WebContext enqueueStyle(String alias) {
        return enqueueStyle(alias, "1.0.0");
    }

    public WebContext enqueueScript(String theme, String alias, String version) {
        if(modulePool == null){
            return this;
        }
        WebScript script = modulePool.lookupScript(theme, alias, version);
        if(script == null){
            throw ErrorContextFactory.instance().message("引用脚本{}:{}不存在", alias, version).runtimeException();
        }
        return enqueueScript(script);
    }

    public WebContext enqueueStyle(String theme, String alias, String version) {
        if(modulePool == null){
            return this;
        }
        WebStyle style = modulePool.lookupStyle(theme, alias, version);
        if(style == null){
            throw ErrorContextFactory.instance().message("引用样式{}:{}不存在", alias, version).runtimeException();
        }
        return enqueueStyle(style);
    }
    public WebContext enqueueScript(WebScript script){
        scripts.add(script);
        return this;
    }

    public WebContext enqueueStyle(WebStyle style){
        styles.add(style);
        return this;
    }

    /**
     * 设置展示的容器
     *
     * @param container 容器
     * @return
     */
    public WebContext containers(WebContainer ... container) {
        this.containers.addAll(Arrays.asList(container));
        return this;
    }
}
