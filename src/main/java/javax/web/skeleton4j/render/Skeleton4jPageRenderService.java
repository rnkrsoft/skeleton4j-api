package javax.web.skeleton4j.render;

import com.rnkrsoft.interfaces.EnumStringCode;
import com.rnkrsoft.logtrace4j.ErrorContext;

import javax.web.doc.RspCodeReadable;
import javax.web.skeleton4j.config.Skeleton4jConfig;
import javax.web.skeleton4j.pool.ModulePool;

/**
 * Created by rnkrsoft.com on 2017/10/13.
 * 页面渲染服务
 */
public interface Skeleton4jPageRenderService {
    /**
     * 主题名称
     * @return 主题名称
     */
    String getTheme();
    /**
     * 获取模块池
     * @param modulePool 模块池
     */
    void setModulePool(ModulePool modulePool);

    /**
     * 获取模块池
     * @return 模块池
     */
    ModulePool getModulePool();

    /**
     * 设置配置对象
     * @param config 配置对象
     */
    void setConfig(Skeleton4jConfig config);

    /**
     * 获取配置对象
     * @return 配置对象
     */
    Skeleton4jConfig getConfig();

    /**
     * 将错误信息渲染成页面
     * @param enumStringCode 错误码
     * @return 渲染结果
     */
    WebRenderedResult renderPage(EnumStringCode enumStringCode);

    /**
     * 将错误信息渲染成页面
     * @param json JSON
     * @return 渲染结果
     */
    WebRenderedResult renderPage(String json);

    /**
     * 将错误信息渲染成页面
     * @param rspCodeReadable 错误上下文
     * @return 渲染结果
     */
    WebRenderedResult renderPage(RspCodeReadable rspCodeReadable);

    /**
     * 将错误信息渲染成页面
     * @param context 错误上下文
     * @return 渲染结果
     */
    WebRenderedResult renderPage(ErrorContext context);

    /**
     * 渲染页面，将预编译好的页面对象，进行最终的渲染（主要是根据输入的用户进行菜单的渲染）,菜单对应的页面只要有一个接口有权限，都暂时该界面出来
     * @param context 渲染上下文
     * @return 渲染结果
     */
    WebRenderedResult renderPage(RenderContext context);

    /**
     * 渲染菜单
     * @param context 渲染上下文
     * @return
     */
    WebRenderedResult renderMenu(RenderContext context);

    /**
     * 渲染头部
     * @param context 渲染上下文
     * @return
     */
    WebRenderedResult renderHead(RenderContext context);

    /**
     * 渲染尾部
     * @param context 渲染上下文
     * @return
     */
    WebRenderedResult renderFoot(RenderContext context);
}
