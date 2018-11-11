package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebButtonComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;


/**
 * Created by rnkrsoft.com on 2017/10/28.
 * 代理按钮组件，提供在线运行时改变主题
 */
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractButtonComponent extends AbstractFormableComponent implements WebButtonComponent {
    /**
     * 图标
     */
    protected String icon;
    /**
     * 按钮标签
     */
    protected String text;

    public AbstractButtonComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractButtonComponent(AbstractButtonComponent src) {
        super(src);
        this.text = src.text;
    }

    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebButtonComponent.class;
    }
}
