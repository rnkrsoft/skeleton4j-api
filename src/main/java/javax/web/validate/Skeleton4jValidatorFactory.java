package javax.web.validate;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by rnkrsoft.com on 2018/1/4.
 * 校验器工厂类
 */
public class Skeleton4jValidatorFactory {

    static Skeleton4jValidator INSTANCE = newInstance();

    private Skeleton4jValidatorFactory() {

    }

    public static Skeleton4jValidator getInstance() {
        if (INSTANCE == null){
            INSTANCE = newInstance();
        }
        return INSTANCE;
    }

    /**
     * 构建一个校验器实例
     *
     * @param impClassName 实现类全限定名
     * @return 校验器实例
     */
    public static Skeleton4jValidator newInstance(String impClassName) {
        Skeleton4jValidator validator = null;
        ServiceLoader<Skeleton4jValidator> serviceLoader = ServiceLoader.load(Skeleton4jValidator.class);
        Iterator<Skeleton4jValidator> serviceIterator = serviceLoader.iterator();
        while (validator == null && serviceIterator.hasNext()) {
            Skeleton4jValidator validator0 = serviceIterator.next();
            if (impClassName != null) {
                if (validator0.getClass().getName().equals(impClassName)) {
                    validator = validator0;
                }
            } else {
                validator = validator0;
            }
        }
        if (validator == null) {
            throw new RuntimeException("not found'" + Skeleton4jValidator.class.getName() + "' implement class '" + impClassName + "'");
        }
        return validator;
    }

    /**
     * 构建一个校验器实例
     *
     * @return 校验器实例
     */
    public static Skeleton4jValidator newInstance() {
        return newInstance(null);
    }
}
