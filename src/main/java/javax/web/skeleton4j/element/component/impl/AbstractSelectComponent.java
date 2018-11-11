package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebComponent;
import javax.web.skeleton4j.element.component.WebSelectComponent;
import javax.web.skeleton4j.element.component.WebSelectableComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import javax.web.skeleton4j.theme.WebThemePack;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by rnkrsoft.com on 2017/10/28.
 */
@ToString(callSuper = true)
@Data
public abstract class AbstractSelectComponent extends AbstractFormableComponent implements WebSelectComponent {
    protected final Collection<WebSelectableComponent> items = new ArrayList();
    protected boolean multiple;
    protected boolean dropdown;

    public AbstractSelectComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractSelectComponent(AbstractSelectComponent src) {
        super(src);
        this.items.addAll(src.items);
        this.multiple = src.multiple;
    }

    @Override
    public WebSelectComponent addItem(WebSelectableComponent item) {
        items.add(item);
        return this;
    }

    @Override
    public WebSelectComponent addItem(String id, String label, String value, Boolean checked) {
        WebSelectableComponent item = getComponentRegistry().newComponent(getWebPage(), getNamespace(), theme, WebSelectableComponent.class, getColumn(), getId(), id);
        item.setLabel(label);
        item.setValue(value);
        if(checked != null){
            item.setChecked(checked);
        }else{
            item.setChecked(defaultValues.contains(value));
        }
        this.appendStyle(item.getStyles().values());
        this.appendScript(item.getScripts().values());
        items.add(item);
        return this;
    }

    @Override
    public WebSelectComponent addItems(String[][] rows) {
        if (rows.length < 1) {
            //TODO 抛异常
        }
        for (String[] row : rows) {
            if (row.length != 4) {
                //TODO 抛异常
            }
        }
        for (String[] row : rows) {
            addItem(row[0], row[1], row[2], Boolean.valueOf(row[3]));
        }
        return this;
    }

    @Override
    public void scripts(String theme, Collection<WebScript> scripts1) {
        super.scripts(theme, scripts1);
        for (WebComponent component : items) {
            component.scripts(theme, scripts1);
        }
    }

    @Override
    public void styles(String theme, Collection<WebStyle> styles1) {
        super.styles(theme, styles1);
        for (WebComponent component : items) {
            component.styles(theme, styles1);
        }
    }

    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebSelectComponent.class;
    }
}
