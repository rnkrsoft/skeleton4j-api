package javax.web.skeleton4j.style;

import javax.web.skeleton4j.pool.ModulePool;

/**
 * Created by rnkrsoft.com on 2017/11/21.
 * 引用的样式资源
 * 样式名称由主题名:别名:版本号构成
 */
public interface ReferenceWebStyle {
    /**
     * 所属的主题，如果与主题无关返回null
     * @return 主题名
     */
    String getTheme();
    /**
     * 获取别名
     *
     * @return 别名
     */
    String getAlias();

    /**
     * 获取版本号
     *
     * @return 版本号
     */
    String getVersion();

    /**
     * 是否内联
     *
     * @return 内联
     */
    boolean isInline();

    /**
     * 获取存放的模块池对像
     *
     * @return 模块池对像
     */
    ModulePool getModulePool();

    /**
     * 访问样式对象真实对象
     *
     * @return 样式对象
     */
    WebStyle get();
}
