package javax.web.skeleton4j.annotation;

import java.lang.annotation.*;

/**
 * Created by rnkrsoft.com on 2017/11/30.
 * 用于标注在package-info类上，声明该子包下模块的展示信息和权限信息，如果申明使用权限将覆盖所有页面和接口必须使用权限，如果不使用权限，则根据@WebPage的权限设置
 */
@Target({ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebModule {
    /**
     * 展示名称,显示在二级菜单上的名称和页面标题上
     *
     * @return 展示名称
     */
    String displayName();

    /**
     * 是否使用权限校验，如果为假，则不需要权限
     *
     * @return 是否使用权限校验
     */
    boolean useAuthority() default true;
}
