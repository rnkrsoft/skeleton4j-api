package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.doc.enums.PatternType;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebDateComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;

/**
 * Created by rnkrsoft.com on 2017/10/28.
 */
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractDateComponent extends AbstractFormableComponent implements WebDateComponent {

    public AbstractDateComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
        patternType = PatternType.FORMAT;
    }
    protected AbstractDateComponent(AbstractDateComponent src) {
        super(src);
    }
    @Override
    public void setFormat(String format) {
        getPatterns().clear();
        setMaxLen(format.length());
        setMinLen(format.length());
        getPatterns().add(format);
    }

    @Override
    public String getFormat() {
        if(getPatterns().isEmpty()){
            return "";
        }else{
            return getPatterns().get(0);
        }
    }

    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebDateComponent.class;
    }
}
