package javax.web.skeleton4j.element.container.impl;

import com.rnkrsoft.message.MessageFormatter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.component.*;
import javax.web.skeleton4j.element.container.WebFormContainer;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.render.WebContext;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import javax.web.skeleton4j.theme.WebThemePack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by rnkrsoft.com on 2017/10/28.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public abstract class AbstractFormContainer extends AbstractContentContainer implements WebFormContainer {
    protected String title;

    protected final Collection<WebFormableComponent> conditions = new ArrayList();
    protected final Collection<WebHintComponent> hints = new ArrayList();
    protected final Collection<WebMsgBoxComponent> msgBoxes = new ArrayList();
    protected final Collection<WebConfirmBoxComponent> confirmBoxes = new ArrayList();
    protected final Collection<WebTableComponent> tables = new ArrayList();
    protected final Collection<WebFormableComponent> toolbar = new ArrayList();
    protected final Collection<WebDialogBoxComponent> dialogBoxes = new ArrayList();

    public AbstractFormContainer(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractFormContainer(AbstractFormContainer src) {
        super(src);
        this.title = src.title;
        this.conditions.addAll(src.conditions);
        this.hints.addAll(src.hints);
        this.msgBoxes.addAll(src.msgBoxes);
        this.confirmBoxes.addAll(src.confirmBoxes);
        this.tables.addAll(src.tables);
        this.toolbar.addAll(src.toolbar);
        this.dialogBoxes.addAll(src.dialogBoxes);
    }

    @Override
    public WebFormContainer appendCondition(WebFormableComponent... components) {
        conditions.addAll(Arrays.asList(components));
        return this;
    }

    @Override
    public WebFormContainer appendHint(WebHintComponent... components) {
        hints.addAll(Arrays.asList(components));
        return this;
    }

    @Override
    public WebFormContainer appendMsgBox(WebMsgBoxComponent... components) {
        msgBoxes.addAll(Arrays.asList(components));
        return this;
    }

    @Override
    public WebFormContainer appendDialogBox(WebDialogBoxComponent... components) {
        dialogBoxes.addAll(Arrays.asList(components));
        return this;
    }

    @Override
    public WebFormContainer appendConfirmBox(WebConfirmBoxComponent... components) {
        confirmBoxes.addAll(Arrays.asList(components));
        return this;
    }

    @Override
    public WebFormContainer appendTable(WebTableComponent... components) {
        tables.addAll(Arrays.asList(components));
        return this;
    }

    @Override
    public WebFormContainer appendToolbar(WebFormableComponent... components) {
        toolbar.addAll(Arrays.asList(components));
        return this;
    }

    @Override
    public void getCodes(WebContext ctx) {
        if (isCompilable()) {
            File bufferFile = new File(getCachedFilePath(WebFormContainer.class.getSimpleName(), ctx.getTheme()));
            if (!bufferFile.exists()) {
                compile(ctx);
                if (!bufferFile.exists()) {
                    throw new RuntimeException("编译缓存文件失败");
                }
                ctx.getCodes().clear();
            }
            try {
                byte[] data = FileUtils.readFileToByteArray(bufferFile);
                ctx.codes(data);
                if (log.isDebugEnabled()) {
                    log.debug(MessageFormatter.format("读取缓存文件{}成功，文件大小{}, 实际读取大小{}", bufferFile, bufferFile.length(), data.length));
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("读取缓存文件失败", e);
            }
        } else {
            render(ctx, true, true);
        }
    }

    @Override
    public boolean compile(WebContext ctx) {
        if (!isCompilable()) {
            return false;
        }
        setProduct(ctx.getProduct());
        setAction(ctx.getAction());
        setSubAction(ctx.getSubAction());
        setVersion("1.0.0");
        File bufferFile = new File(getCachedFilePath(getElementClass().getSimpleName(), ctx.getTheme()));
        if (!bufferFile.getParentFile().exists()) {
            bufferFile.getParentFile().mkdirs();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(bufferFile);
            render(ctx, true, true);
            ctx.getCodes().write(fos);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fos);
        }
        return true;
    }


    @Override
    public void scripts(String theme, Collection<WebScript> scripts1) {
        super.scripts(theme, scripts1);
        for (WebComponent component : conditions) {
            component.scripts(theme, scripts1);
        }
        for (WebComponent component : hints) {
            component.scripts(theme, scripts1);
        }
        for (WebComponent component : toolbar) {
            component.scripts(theme, scripts1);
        }
        for (WebComponent component : tables) {
            component.scripts(theme, scripts1);
        }
        for (WebComponent component : dialogBoxes) {
            component.scripts(theme, scripts1);
        }
    }

    @Override
    public void styles(String theme, Collection<WebStyle> styles1) {
        super.styles(theme, styles1);
        for (WebComponent component : conditions) {
            component.styles(theme, styles1);
        }
        for (WebComponent component : hints) {
            component.styles(theme, styles1);
        }
        for (WebComponent component : toolbar) {
            component.styles(theme, styles1);
        }
        for (WebComponent component : tables) {
            component.styles(theme, styles1);
        }
        for (WebComponent component : dialogBoxes) {
            component.styles(theme, styles1);
        }
    }


    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebFormContainer.class;
    }
}
