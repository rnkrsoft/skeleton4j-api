package javax.web.skeleton4j.script;


import javax.web.skeleton4j.pool.ModulePool;

/**
 * Created by devops4j on 2017/11/21.
 * 引用的脚本资源
 */
public interface ReferenceWebScript {
    String getAlias();

    String getVersion();

    boolean isInline();

    ModulePool getModulePool();

    WebScript get();
}
