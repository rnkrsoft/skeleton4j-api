package javax.web.skeleton4j.annotation;

import java.lang.annotation.*;

/**
 * Created by devops4j on 2017/11/30.
 * 脚本全局注册注解
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebRegisterScript {
    /**
     * 脚本注册别名，与版本号确定唯一关系
     *
     * @return 别名
     */
    String alias();

    /**
     * 版本号
     *
     * @return 版本号
     */
    String version() default "1.0.0";

    /**
     * 引入脚本别名
     *
     * @return 引入脚本别名
     */
    String value();

    /**
     * 依赖
     *
     * @return 依赖
     */
    WebDependency[] dep() default {};
}
