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
package javax.web.skeleton4j.element;


import javax.web.doc.ElementInfo;
import javax.web.doc.enums.WebLayout;
import javax.web.doc.enums.WebTriggerEvent;
import javax.web.skeleton4j.interfaces.WebInterface;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.render.Renderable;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by rnkrsoft.com on 2017/9/30.
 * Web展示元素付接口
 */
public interface WebElement extends Renderable {
    /**
     * 是否是编辑模式
     *
     * @return 是否是编辑模式
     */
    boolean isEditMode();

    /**
     * 设置为编辑模式
     *
     * @param editMode 是否是编辑模式
     */
    void setEditMode(boolean editMode);

    /**
     * 获取所属的页面对象
     *
     * @return 页面对象
     */
    WebPage getWebPage();

    /**
     * Web组件注册表
     *
     * @return 注册表对象
     */
    WebComponentRegistry getComponentRegistry();

    /**
     * 获取值元素的元信息
     *
     * @return 值元素的元信息
     */
    ElementInfo getColumn();

    /**
     * 构建引用自身的引用对象
     *
     * @return 引用对象
     */
    ReferenceWebElement makeReference();

    /**
     * 当前组件的命名空间
     *
     * @return 命名空间
     */
    String getNamespace();

    /**
     * 当前组件的命名空间
     *
     * @param namespace 命名空间
     */
    void setNamespace(String namespace);

    /**
     * 获取该元素的主题实现名字
     *
     * @return 主题实现名字
     */
    String getTheme();

    /**
     * 获取容器内布局
     *
     * @return 布局
     */
    WebLayout getLayout();

    /**
     * 设置布局
     *
     * @param layout 布局
     */
    void setLayout(WebLayout layout);

    /**
     * 获取组件HTML编号
     *
     * @return 组件HTML编号
     */
    String getId();

    /**
     * 获取组件上一级编号
     *
     * @return 组件上一级编号
     */
    String getParentId();

    /**
     * 获取组件HTML名称
     *
     * @return 组件HTML名称
     */
    String getName();

    /**
     * 获取当前组件的样式信息
     *
     * @return 样式信息
     */
    String getCss();

    /**
     * 设置当前组件的样式信息
     *
     * @param css 样式信息
     */
    void setCss(String css);

    /**
     * 获取组件的html的class列表
     *
     * @return 组件的html的class列表
     */
    Set<String> getCssClasses();

    /**
     * 获取组件已注册事件
     *
     * @return 事件列表
     */
    Collection<WebTriggerEvent> getEvents();

    /**
     * 根据事件获取已注册的接口列表
     *
     * @param event 事件
     * @return 接口列表
     */
    Collection<WebInterface> getInterfaces(WebTriggerEvent event);

    /**
     * 获取组件定义时的样式表信息
     *
     * @return 样式表信息
     */
    Map<String, WebStyle> getStyles();

    /**
     * 根据主题获取样式表信息
     *
     * @param theme   主题名
     * @param styles1 样式表列表
     */
    void styles(String theme, Collection<WebStyle> styles1);

    /**
     * 获取组件定义时的脚本信息
     *
     * @return 脚本信息
     */
    Map<String, WebScript> getScripts();

    /**
     * 根据主题获取脚本信息
     *
     * @param theme    主题名
     * @param scripts1 脚本信息列表
     */
    void scripts(String theme, Collection<WebScript> scripts1);

    /**
     * 向组件增加脚本
     *
     * @param script 脚本
     * @return 组件引用
     */
    WebElement appendScript(WebScript... script);

    /**
     * 向组件增加样式表
     *
     * @param style 样式表
     * @return 组件引用
     */
    WebElement appendStyle(WebStyle... style);

    /**
     * 向组件增加脚本
     *
     * @param scripts 脚本
     * @return 组件引用
     */
    WebElement appendScript(Collection<WebScript> scripts);

    /**
     * 向组件增加样式表
     *
     * @param styles 样式表
     * @return 组件引用
     */
    WebElement appendStyle(Collection<WebStyle> styles);

    /**
     * 注册事件
     *
     * @param event         事件类型
     * @param webInterface 接口信息
     * @return Web元组件
     */
    WebElement registerEvent(WebTriggerEvent event, WebInterface webInterface);

    /**
     * 增加该组件触发源
     *
     * @param event         事件类型
     * @param triggerSource 触发源
     */
    void appendTriggerSource(WebTriggerEvent event, ReferenceWebElement triggerSource);

    /**
     * 获取绑定到当前元素的指定事件的触发源
     *
     * @param event 事件
     * @return 触发源列表
     */
    Collection<ReferenceWebElement> getTriggerSources(WebTriggerEvent event);

    /**
     * 获取所有的触发事件列表
     *
     * @return 事件列表
     */
    Collection<WebTriggerEvent> getTriggerEvents();

    /**
     * 获取元素类型
     *
     * @return 元素类型
     */
    Class<? extends WebElement> getElementClass();

    /**
     * 将元素转换为组件
     * @param targetClass 元素类型
     * @param <T> 元素类型
     * @return 组件
     */
    <T extends WebElement> T as(Class<T> targetClass);

    /**
     * 将元素转换getElementClass指定的组件
     * @param <T> 元素类型
     * @return 组件
     */
    <T extends WebElement> T as();
}
