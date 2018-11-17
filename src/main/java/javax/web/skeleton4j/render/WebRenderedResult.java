package javax.web.skeleton4j.render;

import com.rnkrsoft.io.buffer.ByteBuf;
import com.rnkrsoft.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by rnkrsoft.com on 2017/10/13.
 * 渲染好的页面
 */
@Slf4j
public class WebRenderedResult {
    /**
     * 产品
     */
    String product;
    /**
     * 功能（页面）
     */
    String action;
    /**
     * 页面版本号
     */
    String version;
    /**
     * 缓冲区
     */
    final ByteBuf codes = ByteBuf.allocate(1024).autoExpand(true);

    public WebRenderedResult() {

    }

    public WebRenderedResult(String product, String action, String version) {
        this.product = product;
        this.action = action;
        this.version = version;
    }

    public WebRenderedResult codes(byte[] data) {
        this.codes.put(data);
        return this;
    }

    public WebRenderedResult codes(String... lines) {
        return codes(0, lines);
    }

    public WebRenderedResult codes(int indent, String... lines) {
        String space = StringUtils.fill("", true, ' ', indent);
        for (String line : lines) {
            codes.put("UTF-8", line == null ? space : (space + line), "\n");
        }
        return this;
    }

    /**
     * 将页面按照字节数组缓存输出
     *
     * @return 字节数组缓存
     */
    public ByteBuf getCodes() {
        return codes;
    }

    /**
     * 将渲染结果写入应答中
     *
     * @param request
     * @param response
     */
    public void write(HttpServletRequest request, HttpServletResponse response) {
        write(request, response, false);
    }

    /**
     * 将渲染好的页面写入到页面流
     *
     * @param request
     * @param response
     */
    public void write(HttpServletRequest request, HttpServletResponse response, boolean devMode) {
        OutputStream os = null;
        int bufferSize = Integer.MAX_VALUE / 2;
        FileOutputStream fos = null;
        File pageFile = null;
        try {
            if (devMode && product != null && action != null && version != null) {
                pageFile = new File("target/" + product + "/" + action + "/" + version + ".html");
                if (!pageFile.exists()) {
                    pageFile.getParentFile().mkdirs();
                }
                fos = new FileOutputStream(pageFile);
            }
            os = response.getOutputStream();
            codes.write(os);
        } catch (IOException e) {
            log.error("output page happens error", e);
        } finally {
            IOUtils.closeQuietly(os);
            if (devMode) {
                IOUtils.closeQuietly(fos);
                log.debug("output page '{}'", pageFile);
            }
        }

    }
}
