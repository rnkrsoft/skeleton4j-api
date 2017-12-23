package javax.web.skeleton4j;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by devops4j on 2017/12/16.
 * Skeleton4j服务工厂类
 */
public final class Skeleton4jServiceFactory {

    static final Skeleton4jService INSTANCE = newInstance();

    private Skeleton4jServiceFactory() {

    }

    public static Skeleton4jService getInstance() {
        return INSTANCE;
    }

    /**
     * 构建一个Skeleton4j服务实例
     *
     * @param impClassName 实现类全限定名
     * @return Skeleton4j服务实例
     */
    public static Skeleton4jService newInstance(String impClassName) {
        Skeleton4jService service = null;
        ServiceLoader<Skeleton4jService> serviceLoader = ServiceLoader.load(Skeleton4jService.class);
        Iterator<Skeleton4jService> serviceIterator = serviceLoader.iterator();
        while (service == null && serviceIterator.hasNext()) {
            Skeleton4jService service0 = serviceIterator.next();
            if (impClassName != null) {
                if (service.getClass().getName().equals(impClassName)) {
                    service = service0;
                }
            } else {
                service = service0;
            }
        }
        if (service == null) {
            throw new RuntimeException("未发现'" + Skeleton4jService.class.getName() + "' 实现类'" + impClassName + "'");
        }
        return service;
    }

    /**
     * 构建一个Skeleton4j服务实例
     *
     * @return Skeleton4j服务实例
     */
    public static Skeleton4jService newInstance() {
        return newInstance(null);
    }
}
