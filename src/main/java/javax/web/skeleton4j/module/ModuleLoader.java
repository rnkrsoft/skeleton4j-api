package javax.web.skeleton4j.module;

import javax.web.skeleton4j.pool.ModulePool;

/**
 * Created by rnkrsoft.com on 2017/10/9.
 * 模块加载器, 用于完成模块加载和页面类的重组
 * @see WebModule
 * @see ModulePool
 */
public interface ModuleLoader {
    /**
     * 获取模块池
     *
     * @return 模块池
     */
    ModulePool getModulePool();

    /**
     * 进行模块加载
     *
     * @return 模块加载器
     */
    ModuleLoader load();
}
