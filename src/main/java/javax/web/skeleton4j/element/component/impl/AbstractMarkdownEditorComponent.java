package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebMarkdownEditorComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;

/**
 * Created by rnkrsoft.com on 2017/10/28.
 */
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractMarkdownEditorComponent extends AbstractFormableComponent implements WebMarkdownEditorComponent {
   int editorHeight;
   int editorWidth;
    public AbstractMarkdownEditorComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }
    protected AbstractMarkdownEditorComponent(AbstractMarkdownEditorComponent src) {
        super(src);
    }
    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebMarkdownEditorComponent.class;
    }
}
