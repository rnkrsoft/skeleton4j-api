package javax.web.skeleton4j.render;

/**
 * Created by devops4j on 2017/12/16.
 * 可进行渲染接口
 */
public interface Renderable {
    /**
     * 渲染
     *
     * @param ctx          上下文
     * @param renderHtml   渲染HTML
     * @param renderScript 渲染脚本
     */
    void render(WebContext ctx, boolean renderHtml, boolean renderScript);
}
