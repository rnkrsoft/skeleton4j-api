package javax.web.skeleton4j.render;

import com.rnkrsoft.io.buffer.ByteBuf;
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
    ByteBuf codes;

    public WebRenderedResult(String product, String action, String version) {
        this.product = product;
        this.action = action;
        this.version = version;
        this.codes = ByteBuf.allocate(1024).autoExpand(true);
    }

    public WebRenderedResult codes(byte[] data) {
        this.codes.put(data);
        return this;
    }

    public WebRenderedResult codes(String... lines) {
        this.codes.put("UTF-8", lines);
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
            if (devMode) {
                pageFile = new File("target/" + product + "/" + action + ".html");
                if (!pageFile.exists()) {
                    pageFile.getParentFile().mkdirs();
                }
                fos = new FileOutputStream(pageFile);
            }
            os = response.getOutputStream();
            while (codes.readableLength() > 0) {
                byte[] bytes = new byte[Math.min(bufferSize, codes.readableLength() % bufferSize)];
                codes.get(bytes);
                os.write(bytes);
                if (devMode) {
                    fos.write(bytes);
                }
            }
        } catch (IOException e) {
            log.error("输出页面发生异常", e);
        } finally {
            IOUtils.closeQuietly(os);
            if (devMode) {
                IOUtils.closeQuietly(fos);
                log.debug("输出页面{}", pageFile);
            }
        }

    }
}
