package javax.web.skeleton4j.annotation;


import java.lang.annotation.*;

/**
 * Created by rnkrsoft.com on 2017/11/30.
 * 页面注解，用于标注在类或者接口上，进行页面的定义
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebPage {
    /**
     * 优先级，对模块进行排序
     *
     * @return 优先级
     */
    int priority() default 0;
    /**
     * 页面访问URL
     *
     * @return URL
     */
    String url() default "";

    /**
     * 展示名称,显示在二级菜单上的名称和页面标题上
     *
     * @return 显示名称
     */
    String displayName();

    /**
     * 版本号
     *
     * @return 版本号
     */
    String version() default "1.0.0";

    /**
     * 作者
     *
     * @return 作者
     */
    String author();

    /**
     * 支持ApiDoc族注解的识别，用于自动生成界面，系统根据doc模块完成界面的定义
     *
     * @return 如果使用静态资源页面，则设置为false
     */
    boolean apiDocGenerateGui() default true;

    /**
     * 是否使用权限校验，如果为假，则不需要权限
     *
     * @return 是否使用权限校验
     */
    boolean useAuthority() default true;

    /**
     * 将需要的脚本加入渲染队列
     *
     * @return 脚本数组
     */
    WebEnqueueScript[] enqueueScript() default {};

    /**
     * 将需要的样式加入渲染队列
     *
     * @return 样式数组
     */
    WebEnqueueStyle[] enqueueStyle() default {};

    /**
     * 命名空间，用于对具名空间的接口导入
     *
     * @return 命名空间数组
     */
    WebNamespace[] namespaces() default {};

    /**
     * 在该插件中引入资源，引入资源将被渲染分装成资源容器
     *
     * @return 资源数组
     */
    WebResource[] resources() default {};
}
