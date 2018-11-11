package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebSelectableComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;

/**
 * Created by rnkrsoft.com on 2017/10/28.
 */
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractSelectableComponent extends AbstractFormableComponent implements WebSelectableComponent {
    protected String icon;
    protected boolean checked;
    public AbstractSelectableComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractSelectableComponent(AbstractSelectableComponent src) {
        super(src);
        this.icon = src.icon;
        this.checked = src.checked;
    }

    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebSelectableComponent.class;
    }
}
