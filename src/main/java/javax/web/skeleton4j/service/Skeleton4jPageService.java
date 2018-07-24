package javax.web.skeleton4j.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by rnkrsoft.com on 2018/6/30.
 */
public interface Skeleton4jPageService {
    /**
     * @param devMode  是否为开发模式
     * @param product  模块名称 模块名即权限中的product
     * @param action   页面名称 模块名即权限中的action
     *                 ，例如com.rnkrsoft.page.demo.TestPlugin
     *                 modelName = 包名(product)
     *                 pageName = 类名缩写(action)
     *                 usbAction(page)//固定写法
     * @param version  版本号
     * @param theme    主题
     * @param sidebar  是否显示侧边栏
     * @param request  HTTP请求对象
     * @param response HTTP应答对象
     */
    void page(boolean devMode, String product, String action, String version, String theme, Boolean sidebar, HttpServletRequest request, HttpServletResponse response);
}
