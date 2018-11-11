package javax.web.skeleton4j.element.container.impl;

import com.rnkrsoft.message.MessageFormatter;
import com.rnkrsoft.skeleton4j.context.DefaultWebContext;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.container.WebGuideContainer;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.registry.WebComponentRegistryFactory;
import javax.web.skeleton4j.render.WebContext;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import javax.web.skeleton4j.theme.WebThemePack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Collection;

/**
 * Created by rnkrsoft.com on 2017/10/28.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public abstract class AbstractGuideContainer extends AbstractContentContainer implements WebGuideContainer {

    public AbstractGuideContainer(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected AbstractGuideContainer(AbstractGuideContainer src) {
        super(src);
    }

    @Override
    public void getCodes(WebContext ctx) {
        if (isCompilable()) {
            File bufferFile = new File(getCachedFilePath(WebGuideContainer.class.getSimpleName(), ctx.getTheme()));
            if (!bufferFile.exists()) {
                compile(new DefaultWebContext(ctx));
                if (!bufferFile.exists()) {
                    throw new RuntimeException("编译缓存文件失败");
                }
            }
            try {
                byte[] data = FileUtils.readFileToByteArray(bufferFile);
                ctx.codes(data);
                if(log.isDebugEnabled()){
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
        File bufferFile = new File(getCachedFilePath(WebGuideContainer.class.getSimpleName(), ctx.getTheme()));
        if (!bufferFile.getParentFile().exists()) {
            bufferFile.getParentFile().mkdirs();
        }
        FileChannel channel = null;
        try {
            FileOutputStream fos = new FileOutputStream(bufferFile);;
            render(ctx, true, true);
            channel = fos.getChannel();
            channel.write(ctx.getCodes().asByteBuffer());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(channel);
        }
        return true;
    }


    @Override
    public void scripts(String theme, Collection<WebScript> scripts1) {
        scripts1.addAll(WebComponentRegistryFactory.getInstance().getThemePack(theme).getScripts(WebGuideContainer.class));
    }

    @Override
    public void styles(String theme, Collection<WebStyle> styles1) {
        styles1.addAll(WebComponentRegistryFactory.getInstance().getThemePack(theme).getStyles(WebGuideContainer.class));
    }

    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebGuideContainer.class;
    }
}
