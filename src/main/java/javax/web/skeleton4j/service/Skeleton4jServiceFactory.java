package javax.web.skeleton4j.service;

import com.rnkrsoft.logtrace4j.ErrorContext;
import com.rnkrsoft.logtrace4j.ErrorContextFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by rnkrsoft.com on 2017/12/16.
 * Skeleton4j服务工厂类
 */
public final class Skeleton4jServiceFactory {

    static Skeleton4jService INSTANCE;

    private Skeleton4jServiceFactory() {

    }

    public static Skeleton4jService getInstance(String impClassName, ClassLoader classLoader) {
        if (INSTANCE == null){
            synchronized (Skeleton4jServiceFactory.class){
                if (INSTANCE == null){
                    INSTANCE = newInstance(impClassName, classLoader);
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 构建一个Skeleton4j服务实例
     *
     * @param impClassName 实现类全限定名
     * @return Skeleton4j服务实例
     */
    public static Skeleton4jService newInstance(String impClassName, ClassLoader classLoader) {
        Skeleton4jService service = null;
        ServiceLoader<Skeleton4jService> serviceLoader = ServiceLoader.load(Skeleton4jService.class, classLoader);
        Iterator<Skeleton4jService> serviceIterator = serviceLoader.iterator();
        while (service == null && serviceIterator.hasNext()) {
            Skeleton4jService service0 = serviceIterator.next();
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
            errorContext.message("未发现'{}' 实现", impClassName == null ? Skeleton4jService.class.getName() : impClassName)
                    .solution("在META-INF/services/{}", Skeleton4jService.class.getName());
            Iterator<Skeleton4jService> it = serviceLoader.iterator();
            int i = 0;
            while (it.hasNext()) {
                i++;
                Skeleton4jService service0 = it.next();
                errorContext.extra("found", "实现[{}] {}", i, service0.getClass().getName());
            }
            throw errorContext.runtimeException();
        }
        return service;
    }

    /**
     * 构建一个Skeleton4j服务实例
     *
     * @return Skeleton4j服务实例
     */
    public static Skeleton4jService newInstance(ClassLoader classLoader) {
        return newInstance(null, classLoader);
    }
}
