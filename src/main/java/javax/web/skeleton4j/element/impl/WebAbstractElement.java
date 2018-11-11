package javax.web.skeleton4j.element.impl;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.doc.enums.WebLayout;
import javax.web.doc.enums.WebTriggerEvent;
import javax.web.skeleton4j.element.DefaultReferenceWebElement;
import javax.web.skeleton4j.element.ReferenceWebElement;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.interfaces.WebInterface;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.registry.WebComponentRegistryFactory;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import javax.web.skeleton4j.theme.WebThemePack;
import java.util.*;

/**
 * Created by rnkrsoft.com on 2017/10/20.
 * 抽象的元素基类
 */
@ToString(exclude = {"componentRegistry", "webPage", "themePack"})
@EqualsAndHashCode
public abstract class WebAbstractElement implements WebElement {
    @Getter
    @Setter
    private boolean editMode;
    @Getter
    private WebPage webPage;
    @Getter
    private WebComponentRegistry componentRegistry;
    @Getter
    @Setter
    private WebLayout layout;
    @Getter
    private WebThemePack themePack;
    @Getter
    private ElementInfo column;
    @Getter
    protected String theme;
    @Getter
    @Setter
    private String parentId;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String namespace;
    @Getter
    @Setter
    private String css;
    @Getter
    private final Set<String> cssClasses = new HashSet();
    @Getter
    private final Map<String, WebStyle> styles = new HashMap();
    @Getter
    private final Map<String, WebScript> scripts = new HashMap();
    /**
     * 绑定的事件
     */
    private final Map<WebTriggerEvent, Collection<WebInterface>> events = new HashMap();
    /**
     * 能够对当前组件进行影响的组件和事件注册关系
     */
    private final Map<WebTriggerEvent, Collection<ReferenceWebElement>> triggerSources = new HashMap();

    public WebAbstractElement() {

    }

    protected WebAbstractElement(WebAbstractElement src) {
        this.editMode = src.editMode;
        this.webPage = src.webPage;
        this.componentRegistry = src.componentRegistry;
        this.layout = src.layout;
        this.themePack = src.themePack;
        this.column = src.column;
        this.parentId = src.parentId;
        this.theme = src.theme;
        this.parentId = src.parentId;
        this.name = src.name;
        this.namespace = src.namespace;
        this.css = src.css;
        this.cssClasses.addAll(src.cssClasses);
        this.styles.putAll(src.styles);
        this.scripts.putAll(src.scripts);
        for (WebTriggerEvent event : src.getEvents()) {
            Collection<WebInterface> ajaxInterfaces = src.getInterfaces(event);
            for (WebInterface ajaxInterface : ajaxInterfaces) {
                registerEvent(event, ajaxInterface);
            }
        }
        for (WebTriggerEvent event : src.getTriggerEvents()) {
            Collection<ReferenceWebElement> triggerSources = src.getTriggerSources(event);
            for (ReferenceWebElement triggerSource : triggerSources) {
                appendTriggerSource(event, triggerSource);
            }
        }

    }

    public WebAbstractElement(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        this.webPage = webPage;
        this.themePack = themePack;
        this.column = column;
        this.parentId = parentId;
        this.name = name;
        this.componentRegistry = componentRegistry;
    }

    /**
     * 注册事件
     *
     * @param event         事件类型
     * @param ajaxInterface 接口
     */
    public WebElement registerEvent(WebTriggerEvent event, WebInterface ajaxInterface) {
        Collection<WebInterface> ajaxInterfaces = events.get(event.getCode());
        if (ajaxInterfaces == null) {
            ajaxInterfaces = new LinkedList();
            events.put(event, ajaxInterfaces);
        }
        ajaxInterfaces.add(ajaxInterface);
        webPage.getInterfaces().add(ajaxInterface);
        return this;
    }

    @Override
    public Collection<WebTriggerEvent> getEvents() {
        Collection<WebTriggerEvent> triggerEvents = events.keySet();
        if (triggerEvents == null) {
            triggerEvents = Collections.emptyList();
        } else {
            triggerEvents = Collections.unmodifiableCollection(triggerEvents);
        }
        return triggerEvents;
    }

    @Override
    public Collection<WebInterface> getInterfaces(WebTriggerEvent event) {
        Collection<WebInterface> ajaxInterfaces = events.get(event);
        if (ajaxInterfaces == null) {
            ajaxInterfaces = Collections.emptyList();
        } else {
            ajaxInterfaces = Collections.unmodifiableCollection(ajaxInterfaces);
        }
        return ajaxInterfaces;
    }

    @Override
    public WebElement appendScript(WebScript... script) {
        for (WebScript webScript : script) {
            scripts.put(webScript.getAlias() + "@" + webScript.getVersion(), webScript);
        }
        return this;
    }

    @Override
    public WebElement appendScript(Collection<WebScript> scripts) {
        for (WebScript script : scripts) {
            if (script == null) {
                continue;
            }
            this.scripts.put(script.getAlias() + "@" + script.getVersion(), script);
        }
        return this;
    }

    @Override
    public WebElement appendStyle(WebStyle... styles) {
        for (WebStyle style : styles) {
            if (style == null) {
                continue;
            }
            this.styles.put(style.getAlias() + "@" + style.getVersion(), style);
        }
        return this;
    }

    @Override
    public WebElement appendStyle(Collection<WebStyle> styles) {
        for (WebStyle webStyle : styles) {
            this.styles.put(webStyle.getAlias() + "@" + webStyle.getVersion(), webStyle);
        }
        return this;
    }

    @Override
    public void appendTriggerSource(WebTriggerEvent event, ReferenceWebElement triggerSource) {
        Collection<ReferenceWebElement> soures = triggerSources.get(event);
        if (soures == null) {
            soures = new LinkedList();
            triggerSources.put(event, soures);
        }
        soures.add(triggerSource);
    }

    @Override
    public Collection<WebTriggerEvent> getTriggerEvents() {
        return triggerSources.keySet();
    }

    @Override
    public Collection<ReferenceWebElement> getTriggerSources(WebTriggerEvent event) {
        Collection<ReferenceWebElement> elements = triggerSources.get(event);
        if (elements == null) {
            return new ArrayList();
        } else {
            return elements;
        }
    }

    /**
     * 将ID进行处理
     *
     * @param id
     * @return
     */
    public static String id(String id) {
        return id == null ? null : id.replaceAll("\\.", "_");
    }

    @Override
    public String getId() {
        if (this.getParentId() == null || this.getParentId().isEmpty()) {
            return id(this.name);
        } else {
            return id(this.getParentId() + "__" + getElementClass().getSimpleName() + "_" + this.name);
        }
    }


    @Override
    public void scripts(String theme, Collection<WebScript> scripts1) {
        scripts1.addAll(WebComponentRegistryFactory.getInstance().getThemePack(theme).getScripts(getElementClass()));
    }

    @Override
    public void styles(String theme, Collection<WebStyle> styles1) {
        styles1.addAll(WebComponentRegistryFactory.getInstance().getThemePack(theme).getStyles(getElementClass()));
    }

    @Override
    public ReferenceWebElement makeReference() {
        return new DefaultReferenceWebElement(getComponentRegistry(), getWebPage(), column, getElementClass(), getId());
    }

    @Override
    public <T extends WebElement> T as() {
        return (T) as(getElementClass());
    }

    @Override
    public <T extends WebElement> T as(Class<T> targetClass) {
        if (targetClass.isAssignableFrom(this.getClass())) {
            return (T) this;
        } else {
            throw new ClassCastException("不能将组件对象转换为'" + targetClass + "',因为组件类型为'" + this.getClass() + "'");
        }
    }
}
