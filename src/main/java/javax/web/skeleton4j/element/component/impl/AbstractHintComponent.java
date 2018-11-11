package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebHintComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;

/**
 * Created by rnkrsoft.com on 2017/10/28.
 */
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractHintComponent extends WebAbstractComponent implements WebHintComponent {
    /**
     * 标题
     */
    protected String title;
    /**
     * 消息
     */
    protected String message;

    protected int timeoutSec;

    public AbstractHintComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractHintComponent(AbstractHintComponent src) {
        super(src);
        this.title= src.title;
        this.message= src.message;
    }


    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebHintComponent.class;
    }
}
