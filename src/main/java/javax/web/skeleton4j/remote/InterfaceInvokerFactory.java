package javax.web.skeleton4j.remote;

import com.rnkrsoft.logtrace4j.ErrorContext;
import com.rnkrsoft.logtrace4j.ErrorContextFactory;

import javax.web.skeleton4j.enums.InterfaceCall;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * Created by rnkrsoft.com on 2018/1/22.
 * 接口执行器工厂
 */
public class InterfaceInvokerFactory {
    final static Map<InterfaceCall, InterfaceInvoker> CACHE = new Hashtable();

    /**
     * 构建一个Skeleton4j配置服务实例
     *
     * @param type 实现类全限定名
     * @return Skeleton4j配置服务实例
     */
    public static InterfaceInvoker newInstance(InterfaceCall type) {
        InterfaceInvoker invoker = CACHE.get(type);
        if (invoker != null) {
            return invoker;
        }
        ServiceLoader<InterfaceInvoker> serviceLoader = ServiceLoader.load(InterfaceInvoker.class);
        Iterator<InterfaceInvoker> iterator = serviceLoader.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            InterfaceInvoker invoker0 = iterator.next();
            if (invoker0 != null) {
                if (invoker0.getType() == type) {
                    count++;
                    if (invoker == null) {
                        invoker = invoker0;
                    }
                }
            }
        }
        if (count == 0 || invoker == null) {
            ErrorContext errorContext = ErrorContextFactory.instance().reset();
            errorContext.message("未发现'{}' 执行器", type)
                    .solution("在META-INF/services/javax.web.skeleton4j.remote.InterfaceInvoker检查");
            Iterator<InterfaceInvoker> it = serviceLoader.iterator();
            int i = 0;
            while (it.hasNext()) {
                i++;
                InterfaceInvoker invoker0 = it.next();
                errorContext.extra("found", "实现[{}] '{}' {}", i, invoker0.getType(), invoker0.getClass().getName());
            }
            throw errorContext.runtimeException();
        } else if (count > 1) {
            ErrorContext errorContext = ErrorContextFactory.instance().reset();
            errorContext.message("发现'{}' 执行器存在多个", type)
                    .solution("在META-INF/services/javax.web.skeleton4j.remote.InterfaceInvoker检查");
            Iterator<InterfaceInvoker> it = serviceLoader.iterator();
            int i = 0;
            while (it.hasNext()) {
                i++;
                InterfaceInvoker invoker0 = it.next();
                errorContext.extra("found", "实现[{}] '{}' {}", i, invoker0.getType(), invoker0.getClass().getName());
            }
            throw errorContext.runtimeException();
        }
        CACHE.put(invoker.getType(), invoker);
        return invoker;
    }

    /**
     * 构建一个Skeleton4j配置服务实例
     *
     * @return Skeleton4j配置服务实例
     */
    public static InterfaceInvoker newInstance() {
        return newInstance(InterfaceCall.SPRING_BEAN);
    }
}
