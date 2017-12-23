package javax.web.skeleton4j.style;

import javax.web.skeleton4j.pool.ModulePool;

/**
 * Created by devops4j on 2017/11/21.
 * 引用的样式资源
 */
public interface ReferenceWebStyle {
    String getAlias();

    String getVersion();

    boolean isInline();

    ModulePool getModulePool();

    WebStyle get();
}
