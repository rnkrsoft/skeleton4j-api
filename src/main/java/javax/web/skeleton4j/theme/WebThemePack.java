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
package javax.web.skeleton4j.theme;

import lombok.Getter;
import lombok.Setter;

import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by rnkrsoft.com on 2017/10/27.
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
