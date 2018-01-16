package javax.web.skeleton4j.annotation;

import java.lang.annotation.*;

/**
 * Created by devops4j on 2017/12/7.
 * 依赖样式加入渲染的注解
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebEnqueueStyle {
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
     * 是否进行内联
     *
     * @return 是否进行内联
     */
    boolean inline() default true;
}
