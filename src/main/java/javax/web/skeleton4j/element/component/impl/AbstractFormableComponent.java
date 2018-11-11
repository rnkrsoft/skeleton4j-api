package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.doc.ValueElementInfo;
import javax.web.doc.enums.PatternType;
import javax.web.skeleton4j.element.component.WebFormableComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/12/12.
 */
@ToString(callSuper = true)
@Data
public abstract class AbstractFormableComponent extends WebAbstractComponent implements WebFormableComponent{
    protected String label;
    protected String value;
    protected PatternType patternType = PatternType.REGEX;
    protected final List<String> patterns = new ArrayList();
    protected int maxLen;
    protected int minLen;
    protected String placeholder;
    protected String fontColor;
    protected String backgroundColor;
    public AbstractFormableComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractFormableComponent(AbstractFormableComponent src) {
        super(src);
        this.label = src.label;
        this.value = src.value;
        this.patternType = src.patternType;
        this.patterns.addAll(src.getPatterns());
        this.maxLen = src.maxLen;
        this.minLen = src.minLen;
        this.placeholder = src.placeholder;
        this.fontColor = src.fontColor;
        this.backgroundColor = src.backgroundColor;
    }


    @Override
    public ValueElementInfo getColumnMetadata() {
        return (ValueElementInfo)getColumn();
    }


    protected String cssClass(){
        StringBuilder cssClassBuffer = new StringBuilder();
        for (String cssClass : getCssClasses()){
            cssClassBuffer.append(" ").append(cssClass);
        }
        return cssClassBuffer.toString();
    }
}
