package javax.web.skeleton4j.registry;

import com.rnkrsoft.logtrace4j.ErrorContext;
import com.rnkrsoft.logtrace4j.ErrorContextFactory;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.page.WebPage;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by rnkrsoft.com on 2017/12/12.
 * 组件注册工厂
 */
public final class WebComponentRegistryFactory {
    static final WebComponentRegistry INSTANCE = newInstance();

    private WebComponentRegistryFactory() {
    }

    /**
     * 获取已生成的实例
     * @return 组建注册对象
     */
    public static WebComponentRegistry getInstance() {
        return INSTANCE;
    }

    /**
     * 根据字段定义创建Web组件对象
     *
     * @param namespace
     * @param theme
     * @param componentInterface
     * @param column
     * @param parentID
     * @param name
     * @param <T>
     * @return
     */
    public static <T extends WebElement> T newComponent(WebPage webPage, String namespace, String theme, Class<T> componentInterface, ElementInfo column, String parentID, String name) {
        return getInstance().newComponent(webPage, namespace, theme, componentInterface, column, parentID, name);
    }

    /**
     * 根据字段定义创建Web组件对象
     *
     * @param namespace          命名空间
     * @param theme              主题名
     * @param componentInterface 组件接口
     * @param column             字段对象
     * @param parentID           上一级ID
     * @param <T>
     * @return
     */
    public static <T extends WebElement> T newComponent(WebPage webPage, String namespace, String theme, Class<T> componentInterface, ElementInfo column, String parentID) {
        return getInstance().newComponent(webPage, namespace, theme, componentInterface, column, parentID, column.getName());
    }

    /**
     * 进行组件的新建
     *
     * @param theme     主题名
     * @param component 组件
     * @param <T>
     * @return
     */
    public static <T extends WebElement> T newComponent(String theme, T component) {
        return getInstance().newComponent(theme, component);
    }

    /**
     * 构建一个组件注册对象
     *
     * @param impClassName
     * @return
     */
    public static WebComponentRegistry newInstance(String impClassName) {
        WebComponentRegistry registry = null;
        ServiceLoader<WebComponentRegistry> serviceLoader = ServiceLoader.load(WebComponentRegistry.class);
        Iterator<WebComponentRegistry> iterator = serviceLoader.iterator();
        while (registry == null && iterator.hasNext()) {
            WebComponentRegistry registry0 = iterator.next();
            if (impClassName != null) {
                if (registry0.getClass().getName().equals(impClassName)) {
                    registry = registry0;
                }
            } else {
                registry = registry0;
            }
        }
        if (registry == null) {
            ErrorContext errorContext = ErrorContextFactory.instance().reset();
            errorContext.message("未发现'{}' 实现", impClassName == null ? WebComponentRegistry.class.getName() : impClassName)
                    .solution("在META-INF/services/javax.web.skeleton4j.registry.WebComponentRegistry文件中定义实现类");
            Iterator<WebComponentRegistry> it = serviceLoader.iterator();
            int i = 0;
            while (it.hasNext()) {
                i++;
                WebComponentRegistry registry1 = it.next();
                errorContext.extra("found", "实现[{}] {}", i, registry1.getClass().getName());
            }
            throw errorContext.runtimeException();
        }
        return registry;
    }

    public static WebComponentRegistry newInstance() {
        return newInstance(null);
    }
}
