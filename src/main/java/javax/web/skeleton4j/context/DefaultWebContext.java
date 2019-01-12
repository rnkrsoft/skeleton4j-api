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
public class DefaultWebContext implements WebContext {
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

    public DefaultWebContext(WebContext ctx) {
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
        for (String line : lines) {
            codes.put("UTF-8", line == null ? space : (space + line));
        }
        return this;
    }

    @Override
    public WebContext append(int indent, String... lines) {
        String space = StringUtils.fill("", true, ' ', indent);
        for (String line : lines) {
            codes.put("UTF-8", line == null ? space : (space + line), "\n");
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
        if (modulePool == null) {
            return this;
        }
        WebScript script = modulePool.lookupScript(theme, alias, version);
        if (script == null) {
            throw ErrorContextFactory.instance().message("引用脚本{}:{}不存在", alias, version).runtimeException();
        }
        return enqueueScript(script);
    }

    public WebContext enqueueStyle(String theme, String alias, String version) {
        if (modulePool == null) {
            return this;
        }
        WebStyle style = modulePool.lookupStyle(theme, alias, version);
        if (style == null) {
            throw ErrorContextFactory.instance().message("引用样式{}:{}不存在", alias, version).runtimeException();
        }
        return enqueueStyle(style);
    }

    public WebContext enqueueScript(WebScript script) {
        scripts.add(script);
        return this;
    }

    public WebContext enqueueStyle(WebStyle style) {
        styles.add(style);
        return this;
    }

    /**
     * 设置展示的容器
     *
     * @param container 容器
     * @return 上下文
     */
    public WebContext containers(WebContainer... container) {
        this.containers.addAll(Arrays.asList(container));
        return this;
    }
}
