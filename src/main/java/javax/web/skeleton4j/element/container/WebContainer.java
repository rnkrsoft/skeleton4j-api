package javax.web.skeleton4j.element.container;

import javax.web.skeleton4j.compile.WebCompilable;
import javax.web.skeleton4j.compile.WebCompile;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.page.NamespaceInterfaceMetadata;
import javax.web.skeleton4j.render.Renderable;
import java.util.Collection;
import java.util.List;

/**
 * Created by devops4j on 2017/9/30.
 * Web容器接口,容器中的内容可以编译，也可以不编译，最终渲染的时候进行
 */
public interface WebContainer extends WebCompilable, WebCompile, Renderable, WebElement {
    /**
     * 设置页面提示信息
     *
     * @param hintMessages 提示信息
     */
    void setHintMessages(String... hintMessages);

    /**
     * 获取容器提示信息
     *
     * @return 提示信息
     */
    List<String> getHintMessages();

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
     * 同其中需要导入的接口
     *
     * @return
     */
    Collection<NamespaceInterfaceMetadata> getImports();
}
