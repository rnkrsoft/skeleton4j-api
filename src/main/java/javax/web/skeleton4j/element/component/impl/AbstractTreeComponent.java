package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebTreeComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;

/**
 * Created by rnkrsoft.com on 2017/12/7.
 */
@ToString(callSuper = true)
@Data
public abstract class AbstractTreeComponent extends AbstractFormableComponent implements WebTreeComponent {
    protected boolean multiple = false;
    protected boolean dropdown;
    protected boolean expand;
    public AbstractTreeComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractTreeComponent(AbstractTreeComponent src) {
        super(src);
        this.multiple = src.multiple;
    }

    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebTreeComponent.class;
    }
}
