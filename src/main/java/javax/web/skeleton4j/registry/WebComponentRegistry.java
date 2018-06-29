package javax.web.skeleton4j.registry;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import javax.web.skeleton4j.theme.WebThemePack;
import java.util.List;
import java.util.Set;

/**
 * Created by rnkrsoft.com on 2017/12/12.
 * web组件注册表
 */
public interface WebComponentRegistry {
    /**
     * 获取支持的组件列表
     *
     * @return 组件列表
     */
    Set<Class> getSupportedComponents();

    /**
     * 获取指定主题对象
     *
     * @param theme 主题名
     * @return 主题对象
     */
    WebThemePack getThemePack(String theme);

    /**
     * 列出所有主题对象
     *
     * @return 主题对象列表
     */
    List<WebThemePack> listThemePacks();

    /**
     * 注册组件
     *
     * @param theme
     * @param desc
     * @param webThemeClassName
     * @param componentImplement
     */
    void register(String theme, String desc, String webThemeClassName, Class componentImplement);

    /**
     * 注册组件
     *
     * @param theme
     * @param desc
     * @param webThemeClassName
     * @param componentInterface
     * @param componentImplement
     */
    void register(String theme, String desc, String webThemeClassName, Class componentInterface, Class componentImplement);

    /**
     * 注册组件
     *
     * @param theme
     * @param componentInterface
     * @param scripts
     * @param styles
     */
    void register(String theme, Class componentInterface, Set<WebScript> scripts, Set<WebStyle> styles);

    /**
     * @param namespace
     * @param theme
     * @param componentInterface
     * @param column
     * @param parentID
     * @param name
     * @param <T>
     * @return
     */
    <T extends WebElement> T newComponent(WebPage webPage, String namespace, String theme, Class<T> componentInterface, ElementInfo column, String parentID, String name);

    /**
     * 根据字段定义创建Web组件对象
     *
     * @param namespace          命名空间
     * @param theme              主题名
     * @param componentInterface 组件接口
     * @param column             字段对象
     * @param parentID           上一级ID
     * @param <T>
     * @return
     */
    <T extends WebElement> T newComponent(WebPage webPage, String namespace, String theme, Class<T> componentInterface, ElementInfo column, String parentID);

    /**
     * 根据输入的组件元素构建出一个新的组件
     *
     * @param theme     主题名
     * @param component 组件
     * @param <T>       组件
     * @return 组件
     */
    <T extends WebElement> T newComponent(String theme, T component);


}
