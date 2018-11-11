package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.doc.ReferenceInterface;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebSearchViewTextComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;

/**
 * Created by rnkrsoft.com on 2017/10/28.
 */
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractSearchViewTextComponent extends AbstractFormableComponent implements WebSearchViewTextComponent {
    protected String format;
    protected ReferenceInterface searchInterface;

    public AbstractSearchViewTextComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractSearchViewTextComponent(AbstractSearchViewTextComponent src) {
        super(src);
        this.format = src.format;
        this.searchInterface = src.searchInterface;
    }

    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebSearchViewTextComponent.class;
    }
}
