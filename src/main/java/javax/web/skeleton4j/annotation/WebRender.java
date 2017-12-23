package javax.web.skeleton4j.annotation;

import java.lang.annotation.*;

/**
 * Created by devops4j on 2017/11/30.
 * 用于在页面类中定义渲染方法的注解，需要标注在参数为WebPage的方法上
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebRender {
    /**
     * 优先级，存在多个渲染方法时，依靠该属性进行升序渲染，相同优先级使用方法名按照字典排序进行渲染
     *
     * @return 优先级
     */
    int priority();
}
