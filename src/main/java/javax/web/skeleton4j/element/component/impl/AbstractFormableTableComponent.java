package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.doc.enums.PatternType;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebFormableComponent;
import javax.web.skeleton4j.element.component.WebFormableTableComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by rnkrsoft.com on 2017/10/28.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class AbstractFormableTableComponent extends AbstractFormableComponent implements WebFormableTableComponent {
    protected boolean editable;
    protected boolean creatable;
    protected boolean deletable;
    protected boolean pageable;
    /**
     * 表格字段
     */
    protected final Collection<WebFormableComponent> columns = new ArrayList();
    /**
     * 工具栏按钮
     */
    protected final Collection<WebFormableComponent> toolbar = new ArrayList();

    public AbstractFormableTableComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
        patternType = PatternType.FORMAT;
    }
    protected AbstractFormableTableComponent(AbstractFormableTableComponent src) {
        super(src);
        this.editable = src.editable;
        this.creatable = src.creatable;
        this.deletable = src.deletable;
        this.pageable = src.pageable;
        this.columns.addAll(src.columns);
        this.toolbar.addAll(src.toolbar);
    }

    @Override
    public WebFormableTableComponent addColumn(WebFormableComponent... column) {
        for (WebFormableComponent item : column){
            columns.add(item);
        }
        return this;
    }

    @Override
    public WebFormableTableComponent addToolBar(WebFormableComponent... component) {
        this.toolbar.addAll(Arrays.asList(component));
        return this;
    }


    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebFormableTableComponent.class;
    }

}
