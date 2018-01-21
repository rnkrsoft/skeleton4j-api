package javax.web.skeleton4j;

import com.devops4j.logtrace4j.ErrorContext;
import com.devops4j.logtrace4j.ErrorContextFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * Created by devops4j on 2017/12/18.
 * 配置服务工厂
 */
public final class Skeleton4jConfigServiceFactory {

    static final Map<String, Skeleton4jConfigService> INSTANCES = new HashMap();

    static {
        INSTANCES.put("default", newInstance());
        ServiceLoader<Skeleton4jConfigService> serviceLoader = ServiceLoader.load(Skeleton4jConfigService.class);
        Iterator<Skeleton4jConfigService> serviceIterator = serviceLoader.iterator();
        while (serviceIterator.hasNext()) {
            Skeleton4jConfigService service0 = serviceIterator.next();
            INSTANCES.put(service0.getClass().getName(), service0);
        }
    }

    private Skeleton4jConfigServiceFactory() {

    }

    public static Skeleton4jConfigService getInstance(String impClassName) {
        if (impClassName == null) {
            if (INSTANCES.isEmpty()) {
                throw new RuntimeException("未发现'" + Skeleton4jConfigService.class.getName() + "' 实现");
            } else {
                return INSTANCES.values().iterator().next();
            }
        }
        if (INSTANCES.containsKey(impClassName)) {
            return INSTANCES.get(impClassName);
        } else {
            throw new RuntimeException("未发现'" + Skeleton4jConfigService.class.getName() + "' 实现类'" + impClassName + "'");
        }
    }

    /**
     * 构建一个Skeleton4j配置服务实例
     *
     * @param impClassName 实现类全限定名
     * @return Skeleton4j配置服务实例
     */
    public static Skeleton4jConfigService newInstance(String impClassName) {
        Skeleton4jConfigService service = null;
        ServiceLoader<Skeleton4jConfigService> serviceLoader = ServiceLoader.load(Skeleton4jConfigService.class);
        Iterator<Skeleton4jConfigService> serviceIterator = serviceLoader.iterator();
        while (service == null && serviceIterator.hasNext()) {
            Skeleton4jConfigService service0 = serviceIterator.next();
            if (impClassName != null) {
                if (service0.getClass().getName().equals(impClassName)) {
                    service = service0;
                }
            } else {
                service = service0;
            }
        }
        if (service == null) {
            ErrorContext errorContext = ErrorContextFactory.instance().reset();
            errorContext.message("未发现'{}' 实现", impClassName == null ? Skeleton4jConfigService.class.getName() : impClassName)
                    .solution("在META-INF/services/javax.web.skeleton4j.Skeleton4jConfigService");
            Iterator<Skeleton4jConfigService> it = serviceLoader.iterator();
            int i = 0;
            while (it.hasNext()) {
                i++;
                Skeleton4jConfigService service0 = it.next();
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
    public static Skeleton4jConfigService newInstance() {
        return newInstance(null);
    }
}
