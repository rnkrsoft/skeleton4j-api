package javax.web.skeleton4j.render;

import com.rnkrsoft.logtrace4j.ErrorContext;
import com.rnkrsoft.logtrace4j.ErrorContextFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by rnkrsoft.com on 2017/12/18.
 * 页面渲染服务工厂类
 */
public final class Skeleton4jPageRenderServiceFactory {
    static Skeleton4jPageRenderService INSTANCE = newInstance();

    private Skeleton4jPageRenderServiceFactory() {

    }

    public static Skeleton4jPageRenderService getInstance() {
        if (INSTANCE == null) {
            return newInstance();
        }else{
            return INSTANCE;
        }
    }

    /**
     * 构建一个Skeleton4j配置服务实例
     *
     * @param impClassName 实现类全限定名
     * @return Skeleton4j配置服务实例
     */
    public static Skeleton4jPageRenderService newInstance(String impClassName) {
        Skeleton4jPageRenderService service = null;
        ServiceLoader<Skeleton4jPageRenderService> serviceLoader = ServiceLoader.load(Skeleton4jPageRenderService.class);
        Iterator<Skeleton4jPageRenderService> serviceIterator = serviceLoader.iterator();
        while (service == null && serviceIterator.hasNext()) {
            Skeleton4jPageRenderService service0 = serviceIterator.next();
            if (impClassName != null && !impClassName.isEmpty()) {
                if (service0.getClass().getName().equals(impClassName)) {
                    service = service0;
                }
            } else {
                service = service0;
            }
        }
        if (service == null) {
            ErrorContext errorContext = ErrorContextFactory.instance().reset();
            errorContext.message("未发现'{}' 实现", impClassName == null ? Skeleton4jPageRenderService.class.getName() : impClassName)
                    .solution("在META-INF/services/{}", Skeleton4jPageRenderService.class.getName());
            Iterator<Skeleton4jPageRenderService> it = serviceLoader.iterator();
            int i = 0;
            while (it.hasNext()) {
                i++;
                Skeleton4jPageRenderService service0 = it.next();
                errorContext.extra("found", "实现[{}] {}", i, service0.getClass().getName());
            }
            throw errorContext.runtimeException();
        }
        return service;
    }

    /**
     * 构建一个Skeleton4j配置服务实例
     *
     * @return Skeleton4j配置服务实例
     */
    public static Skeleton4jPageRenderService newInstance() {
        return newInstance(null);
    }
}
