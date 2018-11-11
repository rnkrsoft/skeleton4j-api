package javax.web.skeleton4j.element.component.impl;

import com.rnkrsoft.logtrace4j.ErrorContextFactory;
import lombok.Data;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.ReferenceWebElement;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebButtonComponent;
import javax.web.skeleton4j.element.component.WebFormableComponent;
import javax.web.skeleton4j.element.component.WebMenuComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by rnkrsoft.com on 2017/12/15.
 */
@ToString(callSuper = true)
@Data
public abstract class AbstractMenuComponent extends AbstractFormableComponent implements WebMenuComponent{
    String icon;
    String text;
    int status;
    ReferenceWebElement parent;
    final Collection<WebFormableComponent> nodes = new ArrayList();

    public AbstractMenuComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractMenuComponent(AbstractMenuComponent src) {
        super(src);
        this.icon = src.icon;
        this.text = src.text;
        this.status = src.status;
        this.parent = src.parent;
        this.nodes.addAll(src.nodes);
    }

    @Override
    public WebMenuComponent appendNode(WebFormableComponent... nodes) {
        for (WebFormableComponent node : nodes){
            if (node.getElementClass() != WebButtonComponent.class && node.getElementClass() != WebMenuComponent.class ){
                throw ErrorContextFactory.instance().activity("解析菜单").message("只支持按钮和菜单").runtimeException();
            }
        }
        this.nodes.addAll(Arrays.asList(nodes));
        return this;
    }

    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebMenuComponent.class;
    }
}
