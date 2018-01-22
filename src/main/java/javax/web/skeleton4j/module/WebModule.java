package javax.web.skeleton4j.module;

import javax.web.skeleton4j.menu.WebNode;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.pool.ModulePool;
import javax.web.skeleton4j.remote.InterfaceMetadata;
import java.util.List;

/**
 * Created by devops4j on 2017/10/13.
 * 模块封装
 */
public interface WebModule {
    /**
     * 获取模块类所在的模块池
     * @return 模块池
     */
    ModulePool getModulePool();
    /**
     * 模块描述
     *
     * @return 模块描述
     */
    String getDesc();

    /**
     * 模块名称(英文)
     *
     * @return 模块名称(英文)
     */
    String getName();

    /**
     * 包路径，只要包相同，则是相同的模块
     *
     * @return 包路径
     */
    String getPackagePath();

    /**
     * 子菜单
     *
     * @return 子菜单
     */
    List<WebNode> getNodes();

    /**
     * 页面列表，包含的页面对象，一般为编译好的页面，只需要进行权限渲染
     *
     * @return 页面列表
     */
    List<WebPage> getPages();

    /**
     * 接口列表
     *
     * @return 接口列表
     */
    List<InterfaceMetadata> getInterfaces();

    /**
     * 增加接口信息
     *
     * @param interfaceMetadata 接口信息
     * @return 模块封装
     */
    WebModule addInterface(InterfaceMetadata interfaceMetadata);

    /**
     * 增加页面
     *
     * @param webPage 页面类
     * @return 模块封装
     */
    WebModule addPage(WebPage webPage);
}
