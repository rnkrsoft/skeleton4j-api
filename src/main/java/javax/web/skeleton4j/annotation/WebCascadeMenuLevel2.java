package javax.web.skeleton4j.annotation;

import java.lang.annotation.*;

/**
 * Created by rnkrsoft.com on 2018/8/16.
 * 二级级联菜单
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebCascadeMenuLevel2 {
    /**
     * 级联规则
     * @return
     */
    WebCascadeRule[] rule() default @WebCascadeRule("*");
    /**
     * 菜单图片
     * @return
     */
    String icon() default "";

    /**
     *  CSS样式类数组
     * @return
     */
    String[] cssClasses() default {};
    /**
     * 二级菜单名
     * @return
     */
    String displayName();
    /**
     * 级联接口，用于定义元素的级联接口事件
     *
     * @return 级联接口列表
     */
    WebCascadeInterface[] interfaces() default {};
}
