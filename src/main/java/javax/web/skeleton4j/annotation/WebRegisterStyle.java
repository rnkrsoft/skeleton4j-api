package javax.web.skeleton4j.annotation;

import java.lang.annotation.*;

/**
 * Created by devops4j on 2017/11/30.
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
     * @return
     */
    String value();

    /**
     * 版本号
     *
     * @return
     */
    String version() default "1.0.0";

    /**
     * 依赖
     *
     * @return
     */
    WebDependency[] dep() default {};
}
