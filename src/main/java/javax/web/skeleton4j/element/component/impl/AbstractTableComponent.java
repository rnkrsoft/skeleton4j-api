package javax.web.skeleton4j.element.component.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.WebComponent;
import javax.web.skeleton4j.element.component.WebDialogBoxComponent;
import javax.web.skeleton4j.element.component.WebFormableComponent;
import javax.web.skeleton4j.element.component.WebTableComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import javax.web.skeleton4j.theme.WebThemePack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/10/28.
 */
@ToString(callSuper = true)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractTableComponent extends WebAbstractComponent implements WebTableComponent {
    protected boolean pageable;
    /**
     * 表格字段
     */
    protected final List<WebFormableComponent> columns = new ArrayList();
    /**
     * 唯一键字段
     */
    protected WebFormableComponent uniqueColumn;
    /**
     * 表格操作
     */
    protected final List<WebFormableComponent> operates = new ArrayList();
    /**
     * 获取对话框
     * @return
     */
    protected final List<WebDialogBoxComponent> dialogBoxes = new ArrayList();
    /**
     * 是否初始化查询数据
     */
    protected boolean initQuery = false;

    public AbstractTableComponent(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractTableComponent(AbstractTableComponent src) {
        super(src);
        this.pageable = src.pageable;
        this.columns.addAll(src.columns);
        this.uniqueColumn = src.uniqueColumn;
        this.operates.addAll(src.operates);
        this.dialogBoxes.addAll(src.dialogBoxes);
    }


    @Override
    public WebTableComponent addColumn(WebFormableComponent ... column) {
        columns.addAll(Arrays.asList(column));
        return this;
    }

    @Override
    public WebTableComponent addOperate(WebFormableComponent ... operate) {
        operates.addAll(Arrays.asList(operate));
        return this;
    }


    @Override
    public WebTableComponent appendDialogBox(WebDialogBoxComponent... components) {
        dialogBoxes.addAll(Arrays.asList(components));
        return this;
    }

    @Override
    public void scripts(String theme, Collection<WebScript> scripts1) {
        super.scripts(theme, scripts1);
        for (WebComponent component : columns) {
            component.scripts(theme, scripts1);
        }
        for (WebComponent component : operates) {
            component.scripts(theme, scripts1);
        }
        for (WebDialogBoxComponent component : dialogBoxes) {
            component.scripts(theme, scripts1);
        }
    }

    @Override
    public void styles(String theme, Collection<WebStyle> styles1) {
        super.styles(theme, styles1);
        for (WebComponent component : columns) {
            component.styles(theme, styles1);
        }
        for (WebComponent component : operates) {
            component.styles(theme, styles1);
        }
        for (WebDialogBoxComponent component : dialogBoxes) {
            component.styles(theme, styles1);
        }
    }

    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebTableComponent.class;
    }
}
