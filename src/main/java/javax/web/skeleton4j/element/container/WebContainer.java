package javax.web.skeleton4j.element.container;

import javax.web.skeleton4j.compile.WebCompilable;
import javax.web.skeleton4j.compile.WebCompile;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.page.NamespaceInterfaceMetadata;
import javax.web.skeleton4j.render.Renderable;
import java.util.Collection;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/9/30.
 * Web容器接口,容器中的内容可以编译，也可以不编译，最终渲染的时候进行
 */
public interface WebContainer extends WebCompilable, WebCompile, Renderable, WebElement {
    /**
     * 缓存路径
     *
     * @return
     */
    String getCachePath();

    /**
     * 缓存路径
     *
     * @param cachePath
     */
    void setCachePath(String cachePath);

    /**
     * 获取缓存文件路径
     *
     * @return
     */
    String getCachedFilePath(String fileName, String theme);

    /**
     * 获取容器中导入的命名空间接口元信息，有可能最终多个命名空间接口元信息对应一个接口元信息
     * @return 命名空间接口元信息集合
     */
    Collection<NamespaceInterfaceMetadata> getInterfaces();
}
