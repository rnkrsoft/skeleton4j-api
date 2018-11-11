package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebMsgBoxComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;

/**
 * Created by rnkrsoft.com on 2017/10/28.
 */
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractMsgBoxComponent extends WebAbstractComponent implements WebMsgBoxComponent {
    protected String title;
    protected String message;

    protected int timeoutSec;

    public AbstractMsgBoxComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractMsgBoxComponent(AbstractMsgBoxComponent src) {
        super(src);
        this.title = src.title;
        this.message = src.message;
    }

    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebMsgBoxComponent.class;
    }
}
