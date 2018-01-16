package javax.web.skeleton4j.annotation;

import javax.web.skeleton4j.element.component.*;
import java.lang.annotation.*;

/**
 * Created by devops4j on 2017/11/30.
 * 组件注册注解
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebRegisterComponent {
    /**
     * 组件实现的接口
     *
     * @return 组件实现的接口
     */
    Class<? extends javax.web.skeleton4j.element.WebElement> componentInterface() default javax.web.skeleton4j.element.WebElement.class;

    /**
     * 组件实现类
     *
     * @return 组件实现类
     */
    Class<? extends javax.web.skeleton4j.element.WebElement> value();
}
