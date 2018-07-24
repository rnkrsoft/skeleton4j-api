package javax.web.skeleton4j.annotation;

import javax.web.skeleton4j.element.WebElement;
import java.lang.annotation.*;

/**
 * Created by rnkrsoft.com on 2017/12/7.
 * 组件定义注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebComponent {
    /**
     * 组件实现的接口
     *
     * @return 组件实现的接口数组
     */
    Class<? extends WebElement>[] componentInterface() default {};

    /**
     * 组件版本
     *
     * @return 版本号
     */
    String version() default "1.0.0";

    /**
     * 将需要的脚本加入渲染队列
     *
     * @return 组件依赖的脚本数组
     */
    WebEnqueueScript[] enqueueScript() default {};

    /**
     * 将需要的样式加入渲染队列
     *
     * @return 组件依赖的样式数组
     */
    WebEnqueueStyle[] enqueueStyle() default {};
}
