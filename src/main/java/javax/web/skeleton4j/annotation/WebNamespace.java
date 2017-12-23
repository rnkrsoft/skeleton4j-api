package javax.web.skeleton4j.annotation;

import javax.web.skeleton4j.enums.InterfaceCall;
import java.lang.annotation.*;

/**
 * 用于定义命名空间
 * Created by devops4j on 2017/11/30.
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebNamespace {
    /**
     * 页面提示文本，用于在页面最顶端展示
     *
     * @return 提示文本数组
     */
    String[] hints() default {};
    /**
     * 命名空间名称
     *
     * @return 命名空间名称
     */
    String value() default "main";

    /**
     * 接口调用方式
     *
     * @return
     */
    InterfaceCall call() default InterfaceCall.DUBBO;
    /**
     * 在该插件引入的接口,有顺序性，与stageDisplay有关联，
     *
     * @return 导入数组
     */
    WebImport[] imports() default {};
}
