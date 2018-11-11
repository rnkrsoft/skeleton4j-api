package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebRichTextEditorComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;

/**
 * Created by rnkrsoft.com on 2017/10/28.
 */
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractRichTextEditorComponent extends AbstractFormableComponent implements WebRichTextEditorComponent {
    int editorHeight;
    int editorWidth;
    public AbstractRichTextEditorComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractRichTextEditorComponent(AbstractRichTextEditorComponent src) {
        super(src);
    }

    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebRichTextEditorComponent.class;
    }
}
