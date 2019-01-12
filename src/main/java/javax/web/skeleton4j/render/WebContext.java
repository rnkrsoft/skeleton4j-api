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
     * @return 配置
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
     * @return 侧边栏
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

    WebContext append(int indent, String... lines);

    /**
     * 使用模块池中已注册的脚本
     *
     * @param theme 主题
     * @param alias 别名
     * @return 上下文
     */
    WebContext enqueueScript(String theme, String alias);

    /**
     * 使用模块池中已注册的样式
     * @param theme 主题
     * @param alias 别名
     * @return 上下文
     */
    WebContext enqueueStyle(String theme, String alias);

    /**
     * 使用模块池中已注册的脚本
     * @param theme 主题
     * @param alias   别名
     * @param version 版本号
     * @return 上下文
     */
    WebContext enqueueScript(String theme, String alias, String version);

    /**
     * 使用模块池中已注册的样式
     * @param theme 主题
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
     * @return 上下文
     */
    WebContext containers(WebContainer... container);
}
