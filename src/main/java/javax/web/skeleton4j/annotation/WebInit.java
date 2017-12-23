package javax.web.skeleton4j.annotation;

import java.lang.annotation.*;

/**
 * Created by devops4j on 2017/12/7.
 * 组件或者页面类初始化时进行全局注册脚本和样式的定义注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebInit {
    /**
     * 将需要的脚本加入渲染队列
     *
     * @return 脚本
     */
    WebRegisterScript[] registerScript() default {};

    /**
     * 将需要的样式加入渲染队列
     *
     * @return 样式
     */
    WebRegisterStyle[] registerStyle() default {};
}
