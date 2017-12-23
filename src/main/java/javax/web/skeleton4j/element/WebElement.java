package javax.web.skeleton4j.element;


import javax.web.doc.ElementInfo;
import javax.web.doc.enums.WebLayout;
import javax.web.doc.enums.WebTriggerEvent;
import javax.web.skeleton4j.render.Renderable;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.remote.AjaxInterface;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by devops4j on 2017/9/30.
 * Web展示元素付接口
 */
public interface WebElement extends Renderable {
    /**
     * 是否是编辑模式
     * @return
     */
    boolean isEditMode();

    /**
     * 设置为编辑模式
     */
    void setEditMode(boolean editMode);
    /**
     * 获取所属的页面对象
     * @return
     */
    WebPage getWebPage();
    /**
     * Web组件注册表
     * @return 注册表对象
     */
    WebComponentRegistry getComponentRegistry();
    /**
     * 获取值元素的元信息
     *
     * @return
     */
    ElementInfo getColumn();

    /**
     * 构建引用自身的引用对象
     * @return
     */
    ReferenceWebElement makeReference();

    /**
     * 当前组件的命名空间
     * @return
     */
    String getNamespace();

    /**
     * 当前组件的命名空间
     * @param namespace
     */
    void setNamespace(String namespace);

    /**
     * 获取该元素的主题实现名字
     *
     * @return
     */
    String getTheme();

    /**
     * 获取容器内布局
     *
     * @return
     */
    WebLayout getLayout();

    /**
     * 设置布局
     * @param layout
     */
    void setLayout(WebLayout layout);

    /**
     * 获取组件HTML编号
     * @return
     */
    String getId();

    /**
     * 获取组件上一级编号
     * @return
     */
    String getParentId();

    /**
     * 获取组件HTML名称
     * @return
     */
    String getName();

    /**
     * 获取当前组件的样式信息
     * @return
     */
    String getCss();

    /**
     * 设置当前组件的样式信息
     * @param css
     */
    void setCss(String css);

    /**
     * 获取组件的html的class列表
     * @return
     */
    Set<String> getCssClasses();

    /**
     * 获取组件已注册事件
     * @return 事件列表
     */
    Collection<WebTriggerEvent> getEvents();

    /**
     * 根据事件获取已注册的接口列表
     * @param event 事件
     * @return 接口列表
     */
    Collection<AjaxInterface> getAjaxInterfaces(WebTriggerEvent event);

    /**
     * 获取组件定义时的样式表信息
     * @return 样式表信息
     */
    Map<String, WebStyle> getStyles();

    /**
     * 根据主题获取样式表信息
     * @param theme 主题名
     * @param styles1 样式表列表
     */
    void styles(String theme, Collection<WebStyle> styles1);

    /**
     * 获取组件定义时的脚本信息
     * @return 脚本信息
     */
    Map<String, WebScript> getScripts();

    /**
     * 根据主题获取脚本信息
     * @param theme 主题名
     * @param scripts1 脚本信息列表
     */
    void scripts(String theme, Collection<WebScript> scripts1);

    /**
     * 向组件增加脚本
     * @param script 脚本
     * @return 组件引用
     */
    WebElement appendScript(WebScript... script);

    /**
     * 向组件增加样式表
     * @param style 样式表
     * @return 组件引用
     */
    WebElement appendStyle(WebStyle... style);

    /**
     * 向组件增加脚本
     * @param scripts 脚本
     * @return 组件引用
     */
    WebElement appendScript(Collection<WebScript> scripts);
    /**
     * 向组件增加样式表
     * @param styles 样式表
     * @return 组件引用
     */
    WebElement appendStyle(Collection<WebStyle> styles);

    /**
     * 注册事件
     *
     * @param event         事件类型
     * @param ajaxInterface 接口信息
     * @return Web元组件
     */
    WebElement registerEvent(WebTriggerEvent event, AjaxInterface ajaxInterface);
    /**
     * 增加该组件触发源
     *
     * @param event 事件类型
     * @param triggerSource 触发源
     */
    void appendTriggerSource(WebTriggerEvent event, ReferenceWebElement triggerSource);

    /**
     * 获取绑定到当前元素的指定事件的触发源
     * @param event 事件
     * @return
     */
    Collection<ReferenceWebElement> getTriggerSources(WebTriggerEvent event);

    /**
     * 获取所有的触发事件列表
     * @return 事件列表
     */
    Collection<WebTriggerEvent> getTriggerEvents();

    /**
     * 获取元素类型
     * @return
     */
    Class<? extends WebElement> getElementClass();
}
