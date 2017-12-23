package javax.web.skeleton4j.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebTheme {
    /**
     * 主题名称
     *
     * @return
     */
    String name();

    /**
     * 主题描述
     *
     * @return
     */
    String desc();

    /**
     * 主题导入的脚本和样式
     *
     * @return
     */
    WebInit init();

    /**
     * 注册组件加入主题
     *
     * @return
     */
    WebRegisterComponent[] registerComponent();
}
