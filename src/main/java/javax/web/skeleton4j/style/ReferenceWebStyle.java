package javax.web.skeleton4j.style;

import javax.web.skeleton4j.pool.ModulePool;

/**
 * Created by devops4j on 2017/11/21.
 * 引用的样式资源
 */
public interface ReferenceWebStyle {
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
