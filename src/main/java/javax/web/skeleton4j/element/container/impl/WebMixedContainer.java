package javax.web.skeleton4j.element.container.impl;

import lombok.Getter;

import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.container.WebContainer;
import javax.web.skeleton4j.render.WebContext;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/9/30.
 * 混合的容器
 */
public class WebMixedContainer extends WebAbstractContainer implements WebContainer {
    final List<WebContainer> containers = new ArrayList();
    /**
     * 用于缓存生成的HTML代码，将直接缓存在直接内存中
     */
    @Getter
    ByteBuffer codes;

    protected WebMixedContainer(WebMixedContainer src) {
        super(src);
    }


    @Override
    public boolean isCompilable() {
        return false;
    }

    @Override
    public void render(WebContext ctx, boolean renderHtml, boolean renderScript){
        for (WebContainer container : containers){
            container.render(ctx, renderHtml, renderScript);
        }
    }

    @Override
    public boolean compile(WebContext ctx) {
        for (WebContainer container : containers){
            if(container.isCompilable()){
                container.render(ctx, true, true);
            }
        }
        return true;
    }

    @Override
    public void getCodes(WebContext ctx) {

    }


    @Override
    public Class<? extends WebElement> getElementClass() {
        return WebContainer.class;
    }
}
