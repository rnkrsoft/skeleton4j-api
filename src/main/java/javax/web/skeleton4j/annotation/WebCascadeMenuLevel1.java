package javax.web.skeleton4j.annotation;

/**
 * Created by rnkrsoft.com on 2018/8/16.
 */
public @interface WebCascadeMenuLevel1 {
    /**
     * 一级菜单名
     * @return
     */
    String displayName();
    /**
     * 级联接口，用于定义元素的级联接口事件
     *
     * @return 级联接口列表
     */
    WebCascadeInterface[] interfaces() default {};

    /**
     * 级联二级菜单集合接口，用于定义二级菜单的级联接口
     * @return
     */
    WebCascadeMenuLevel2[] menus() default {};
}
