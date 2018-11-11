package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.impl.WebAbstractElement;
import javax.web.skeleton4j.element.component.WebComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/10/10.
 * 抽象的组件基类
 */
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class WebAbstractComponent extends WebAbstractElement implements WebComponent {
    protected boolean readonly = false;
    protected boolean hidden = false;
    protected boolean required = false;
    protected final List<String> defaultValues = new ArrayList();

    public WebAbstractComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected WebAbstractComponent(WebAbstractComponent src) {
        super(src);
        this.readonly = src.readonly;
        this.hidden = src.hidden;
        this.required = src.required;
        this.defaultValues.addAll(src.defaultValues);
    }
}
