package javax.web.skeleton4j.render;

import com.rnkrsoft.io.buffer.ByteBuf;

import javax.web.skeleton4j.authority.AuthorityContext;
import javax.web.skeleton4j.authority.AuthorityService;
import javax.web.skeleton4j.menu.WebMenu;
import javax.web.skeleton4j.page.WebPage;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/10/13.
 * 渲染上下文
 */
public interface RenderContext extends AuthorityContext {
    /**
     * 渲染的权限服务
     * @return 权限服务
     */
    AuthorityService getAuthorityService();

    /**
     * 设置权限服务
     * @param authorityService 权限服务
     */
    void setAuthorityService(AuthorityService authorityService);

    /**
     * 设置菜单列表
     * @param menus 菜单列表
     */
    void setMenus(List<WebMenu> menus);

    /**
     * 菜单列表
     * @return 菜单列表
     */
    List<WebMenu> getMenus();

    /**
     * 页面对象
     * @return 页面对象
     */
    WebPage getPage();

    /**
     * 设置菜单栏是否折叠
     * @param sidebar 是否折叠
     */
    void setSidebar(boolean sidebar);

    /**
     * 菜单栏是否折叠
     * @return 是否折叠
     */
    boolean isSidebar();

    /**
     * 获取当前渲染的主题
     * @return 主题名
     */
    String getTheme();

    /**
     * 设置渲染时的主题
     * @param theme 主题名
     */
    void setTheme(String theme);
    /**
     * 添加代码
     * @param lines
     * @return
     */
    RenderContext codes(String... lines);

    /**
     * 获取代码
     * @return
     */
    ByteBuf getCodes();
}
