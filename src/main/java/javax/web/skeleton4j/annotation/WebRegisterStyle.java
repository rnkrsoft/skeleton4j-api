package javax.web.skeleton4j.annotation;

import java.lang.annotation.*;

/**
 * Created by rnkrsoft.com on 2017/11/30.
 * 样式全局注册注解
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebRegisterStyle {
    /**
     * 样式注册别名，与版本号确定唯一关系
     *
     * @return 别名
     */
    String alias();

    /**
     * 引入样式别名
     *
     * @return 引入样式别名
     */
    String value();

    /**
     * 版本号
     *
     * @return 版本号
     */
    String version() default "1.0.0";

    /**
     * 依赖
     *
     * @return 依赖
     */
    WebDependency[] dep() default {};
}
