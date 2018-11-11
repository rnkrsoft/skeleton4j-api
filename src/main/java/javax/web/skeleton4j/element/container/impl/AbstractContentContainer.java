package javax.web.skeleton4j.element.container.impl;

import lombok.Getter;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.container.WebContentContainer;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2018/1/22.
 */
public abstract class AbstractContentContainer extends WebAbstractContainer implements WebContentContainer{
    @Getter
    final List<String> hintMessages = new ArrayList();

    public AbstractContentContainer(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractContentContainer(AbstractContentContainer src) {
        super(src);
        this.hintMessages.addAll(src.hintMessages);
    }

    @Override
    public void setHintMessages(String... hintMessages) {
        for (String hint : hintMessages){
            this.hintMessages.add(hint);
        }
    }
}
