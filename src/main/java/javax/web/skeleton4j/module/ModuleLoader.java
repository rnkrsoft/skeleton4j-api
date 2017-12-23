package javax.web.skeleton4j.module;

import javax.web.skeleton4j.pool.ModulePool;

/**
 * 模块加载器
 */
public interface ModuleLoader {
    /**
     * 获取模块池
     * @return 模块池
     */
    ModulePool getModulePool();

    /**
     * 进行模块加载
     * @return 模块加载器
     */
    ModuleLoader load();
}
