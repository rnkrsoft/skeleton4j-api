package javax.web.skeleton4j.element.container.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebMenuComponent;
import javax.web.skeleton4j.element.container.WebMenuContainer;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.render.WebContext;
import javax.web.skeleton4j.theme.WebThemePack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by rnkrsoft.com on 2017/10/28.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractMenuContainer extends WebAbstractContainer implements WebMenuContainer {
    Collection<WebMenuComponent> menus = new ArrayList();
    public AbstractMenuContainer(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractMenuContainer(AbstractMenuContainer src) {
        super(src);
        this.menus.addAll(src.menus);
    }
    @Override
    public void getCodes(WebContext ctx) {
        throw new RuntimeException("不支持缓存");
    }

    @Override
    public boolean compile(WebContext ctx) {
        return false;
    }

    @Override
    public WebMenuContainer appendMenu(WebMenuComponent... menu) {
        this.menus.addAll(Arrays.asList(menu));
        return this;
    }

    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebMenuContainer.class;
    }
}
