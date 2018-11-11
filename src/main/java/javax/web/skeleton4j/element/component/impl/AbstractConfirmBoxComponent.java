package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebConfirmBoxComponent;
import javax.web.skeleton4j.element.component.WebFormableComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import javax.web.skeleton4j.theme.WebThemePack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by rnkrsoft.com on 2017/11/9.
 */
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractConfirmBoxComponent extends WebAbstractComponent implements WebConfirmBoxComponent {
    protected String title;
    protected String message;
    protected final Collection<WebFormableComponent> items = new ArrayList();
    protected final Collection<WebFormableComponent> toolbar = new ArrayList();

    public AbstractConfirmBoxComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }
    protected AbstractConfirmBoxComponent(AbstractConfirmBoxComponent src) {
        super(src);
        this.title = src.title;
        this.message = src.message;
        this.items.addAll(src.items);
        this.toolbar.addAll(src.toolbar);
    }
    @Override
    public WebConfirmBoxComponent appendToolbar(WebFormableComponent... components) {
        toolbar.addAll(Arrays.asList(components));
        return this;
    }

    @Override
    public WebConfirmBoxComponent appendItem(WebFormableComponent... elements) {
        for (WebFormableComponent item : elements){
            items.add(item);
        }
        return this;
    }

    @Override
    public void scripts(String theme, Collection<WebScript> scripts1) {
        super.scripts(theme, scripts1);
        for (WebElement element : items) {
            element.scripts(theme, scripts1);
        }
        for (WebElement element : toolbar) {
            element.scripts(theme, scripts1);
        }
    }

    @Override
    public void styles(String theme, Collection<WebStyle> styles1) {
        super.styles(theme, styles1);
        for (WebElement element : items) {
            element.styles(theme, styles1);
        }
        for (WebElement element : toolbar) {
            element.styles(theme, styles1);
        }
    }


    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebConfirmBoxComponent.class;
    }
}
