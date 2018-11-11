package javax.web.skeleton4j.element.component.impl;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebUploadFileComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;

/**
 * Created by rnkrsoft.com on 2018/9/27.
 */
public abstract class AbstractUploadFileComponent extends AbstractFormableComponent implements WebUploadFileComponent{
    public AbstractUploadFileComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractUploadFileComponent(AbstractUploadFileComponent src) {
        super(src);
    }
    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebUploadFileComponent.class;
    }
}
