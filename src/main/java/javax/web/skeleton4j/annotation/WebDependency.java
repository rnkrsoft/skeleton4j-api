package javax.web.skeleton4j.annotation;

import java.lang.annotation.*;

/**
 * Created by rnkrsoft.com on 2017/12/7.
 * 依赖脚本或者样式定义注解
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebDependency {
    /**
     * 依赖样式或者脚本的别名
     *
     * @return 别名
     */
    String value();

    /**
     * 版本号
     *
     * @return 版本号
     */
    String version() default "1.0.0";
}
