package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebImageComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;

@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractImageComponent extends AbstractFormableComponent implements WebImageComponent {
    boolean zoom;
    int displayHeight;
    int displayWidth;
    public AbstractImageComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractImageComponent(AbstractImageComponent src) {
        super(src);
        this.zoom = src.zoom;
    }

    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebImageComponent.class;
    }
}
