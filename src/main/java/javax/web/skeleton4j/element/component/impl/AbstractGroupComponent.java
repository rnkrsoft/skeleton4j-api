package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebGroupComponent;
import javax.web.skeleton4j.element.component.WebGroupableComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by rnkrsoft.com on 2017/12/15.
 */
@ToString(callSuper = true)
@Data
public abstract class AbstractGroupComponent extends AbstractFormableComponent implements WebGroupComponent {
    final Collection<WebGroupableComponent> items = new ArrayList();

    public AbstractGroupComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractGroupComponent(AbstractGroupComponent src) {
        super(src);
        this.items.addAll(src.items);
    }

    @Override
    public WebGroupComponent addItem(WebGroupableComponent item) {
        items.add(item);
        return this;
    }

    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebGroupComponent.class;
    }
}
