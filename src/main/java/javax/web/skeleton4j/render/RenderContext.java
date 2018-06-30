package javax.web.skeleton4j.render;

import com.rnkrsoft.io.buffer.ByteBuf;

import javax.web.skeleton4j.authority.AuthorityContext;
import javax.web.skeleton4j.authority.AuthorityService;
import javax.web.skeleton4j.menu.WebMenu;
import javax.web.skeleton4j.page.WebPage;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/10/13.
 */
public interface RenderContext extends AuthorityContext {
    AuthorityService getAuthorityService();
    void setAuthorityService(AuthorityService authorityService);

    void setMenus(List<WebMenu> menus);
    List<WebMenu> getMenus();
    WebPage getPage();
    void setSidebar(boolean sidebar);
    boolean isSidebar();
    String getTheme();
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
