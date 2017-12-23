package javax.web.skeleton4j.annotation;

import java.lang.annotation.*;

/**
 * Created by devops4j on 2017/12/7.
 * 容器定义注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebContainer {
    /**
     * 容器实现的接口
     * @return 组件实现的接口数组
     */
    Class[] componentInterface() default {};

    /**
     * 容器版本
     *
     * @return 版本号
     */
    String version() default "1.0.0";

    /**
     * 将需要的脚本加入渲染队列
     *
     * @return 容器依赖的脚本数组
     */
    WebEnqueueScript[] enqueueScript() default {};

    /**
     * 将需要的样式加入渲染队列
     *
     * @return 容器依赖的样式数组
     */
    WebEnqueueStyle[] enqueueStyle() default {};
}
