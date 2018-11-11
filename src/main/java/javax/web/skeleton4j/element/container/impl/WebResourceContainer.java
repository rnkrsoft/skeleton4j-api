package javax.web.skeleton4j.element.container.impl;

import com.rnkrsoft.message.MessageFormatter;
import com.rnkrsoft.skeleton4j.context.DefaultWebContext;
import com.rnkrsoft.skeleton4j.resource.ResourceUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.container.WebContainer;
import javax.web.skeleton4j.enums.ResourceType;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.render.WebContext;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Collection;

/**
 * Created by rnkrsoft.com on 2017/11/16.
 * 用于存放静态资源文件
 */
@Slf4j
public class WebResourceContainer extends AbstractContentContainer implements WebContainer {
    boolean compilable = false;
    ResourceType type;
    String source;
    String fileName;

    public WebResourceContainer(WebPage webPage, ResourceType type, String source) {
        super(null, webPage, null, null, null, null );
        if (type == ResourceType.HTML) {
            compilable = true;
        } else if (type == ResourceType.VELOCITY) {
            compilable = false;
        } else if (type == ResourceType.BEETL) {
            compilable = false;
        } else if (type == ResourceType.JSP) {
            compilable = false;
        } else if (type == ResourceType.AUTO) {
            if (source.endsWith(".html") || source.endsWith(".htm")) {
                compilable = true;
                type = ResourceType.HTML;
            } else if (source.endsWith(".vm")) {
                compilable = false;
                type = ResourceType.VELOCITY;
            } else {
                compilable = false;
                type = ResourceType.AUTO;
            }
        }
        int lastPost = source.lastIndexOf(".");
        String temp = source.substring(0, lastPost);
        int lastPost2 = temp.lastIndexOf(".");
        this.fileName = source.substring(lastPost2 + 1);
        this.source = source;
    }

    @Override
    public void render(WebContext ctx, boolean renderHtml, boolean renderScript){
        try {
            if(type == ResourceType.VELOCITY){
//                Map<String, Object> param = new HashMap();
//                VelocityUtils.parse(source, param);
            }else{
                byte[] data = ResourceUtils.readFileToByteArray(Thread.currentThread().getContextClassLoader(), source);
                ctx.codes(data);
            }
        } catch (IOException e) {
            log.error(MessageFormatter.format("渲染静态资源{}发生异常", source), e);
        }
    }

    @Override
    public boolean isCompilable() {
        return compilable;
    }

    @Override
    public boolean compile(WebContext ctx) {
        if (!isCompilable()) {
            return false;
        }
        File bufferFile = new File(getCachedFilePath(this.fileName, ctx.getTheme()));
        if (!bufferFile.getParentFile().exists()) {
            bufferFile.getParentFile().mkdirs();
        }
        FileChannel channel = null;
        try {
            FileOutputStream fos = new FileOutputStream(bufferFile);
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
    public void getCodes(WebContext ctx) {
        if (isCompilable()) {
            File bufferFile = new File(getCachedFilePath(this.fileName, ctx.getTheme()));
            if (!bufferFile.exists()) {
                compile(new DefaultWebContext(ctx));
                if (!bufferFile.exists()) {
                    throw new RuntimeException("编译缓存文件失败");
                }
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
    public void styles(String theme, Collection<WebStyle> styles1) {

    }

    @Override
    public void scripts(String theme, Collection<WebScript> scripts1) {

    }

    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebContainer.class;
    }
}
