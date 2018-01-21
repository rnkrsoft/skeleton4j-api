package javax.web.skeleton4j.theme;

import lombok.Getter;
import lombok.Setter;

import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by devops4j on 2017/10/27.
 * 主题包
 */
public class WebThemePack {
    /**
     * 主题名称
     */
    @Setter
    @Getter
    String name;
    /**
     * 主题描述
     */
    @Setter
    @Getter
    String desc;
    /**
     * 主题类
     */
    @Setter
    @Getter
    String themeClassName;
    /**
     * 组件
     */
    final Map<Class, Class> components = new ConcurrentHashMap();
    /**
     * 组件依赖的脚本
     */
    final Map<Class, Set<WebScript>> scripts = new ConcurrentHashMap();
    /**
     * 组件依赖的样式
     */
    final Map<Class, Set<WebStyle>> styles = new ConcurrentHashMap();

    /**
     * 主题包
     *
     * @param name           主题名称
     * @param desc           主题描述
     * @param themeClassName 主题类
     */
    public WebThemePack(String name, String desc, String themeClassName) {
        this.name = name;
        this.desc = desc;
        this.themeClassName = themeClassName;
    }

    /**
     * 注册组件
     *
     * @param componentInterface 组件接口
     * @param componentImplement 组件实现类
     */
    public void register(Class componentInterface, Class componentImplement) {
        components.put(componentInterface, componentImplement);
    }

    /**
     * 列出组件包中的组件
     *
     * @return 组件接口列表
     */
    public List<Class> listComponents() {
        return Collections.unmodifiableList(new ArrayList(components.keySet()));
    }

    /**
     * 获取指定组件接口对应的实现类
     *
     * @param componentInterface 组件接口
     * @return 组件实现类
     */
    public Class getComponent(Class componentInterface) {
        return components.get(componentInterface);
    }

    /**
     * 注册脚本
     *
     * @param componentInterface 组件接口
     * @param scripts1           脚本列表
     */
    public void registerScripts(Class componentInterface, Collection<WebScript> scripts1) {
        Set<WebScript> scriptSet = this.scripts.get(componentInterface);
        if (scriptSet == null) {
            scriptSet = new HashSet();
            this.scripts.put(componentInterface, scriptSet);
        }
        for (WebScript script : scripts1) {
            if (script == null) {
                continue;
            }
            scriptSet.add(script);
        }
    }

    /**
     * 获取指定组件注册的脚本
     *
     * @param componentInterface 组件接口
     * @return 脚本列表
     */
    public List<WebScript> getScripts(Class componentInterface) {
        Set<WebScript> result = scripts.get(componentInterface);
        return Collections.unmodifiableList(new ArrayList(result == null ? new HashSet() : result));
    }

    /**
     * 注册样式表
     *
     * @param componentInterface 组件接口
     * @param styles1            样式表列表
     */
    public void registerStyles(Class componentInterface, Collection<WebStyle> styles1) {
        Set<WebStyle> styleSet = this.styles.get(componentInterface);
        if (styleSet == null) {
            styleSet = new HashSet();
            this.styles.put(componentInterface, styleSet);
        }
        for (WebStyle style : styles1) {
            if (style == null) {
                continue;
            }
            styleSet.add(style);
        }
    }

    /**
     * 获取指定组件注册的样式表
     *
     * @param componentInterface 组件接口
     * @return 样式表列表
     */
    public List<WebStyle> getStyles(Class componentInterface) {
        Set<WebStyle> result = styles.get(componentInterface);
        return Collections.unmodifiableList(new ArrayList(result == null ? new HashSet() : result));
    }

    @Override
    public String toString() {
        return name + ":" + desc;
    }

}
