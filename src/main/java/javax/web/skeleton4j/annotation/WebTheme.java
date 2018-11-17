package javax.web.skeleton4j.annotation;

import javax.web.skeleton4j.render.Skeleton4jPageRenderService;
import java.lang.annotation.*;

/**
 * 用于声明主题
 * Created by rnkrsoft.com on 2017/11/30.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebTheme {
    /**
     * 主题名称
     *
     * @return 主题名称
     */
    String name();

    /**
     * 主题描述
     *
     * @return 主题描述
     */
    String desc();

    /**
     * 主题注册的渲染服务
     * @return
     */
    Class<? extends Skeleton4jPageRenderService> pageRenderServiceClass();
    /**
     * 主题导入的脚本和样式
     *
     * @return 脚本和样式
     */
    WebInit init();

    /**
     * 注册组件加入主题
     *
     * @return 注册组件列表
     */
    WebRegisterComponent[] registerComponent();
}
