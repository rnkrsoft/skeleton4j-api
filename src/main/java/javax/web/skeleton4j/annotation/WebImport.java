package javax.web.skeleton4j.annotation;

import javax.web.doc.enums.WebLayout;
import javax.web.skeleton4j.enums.WebGui;
import javax.web.skeleton4j.enums.WebMode;
import java.lang.annotation.*;

/**
 * Created by rnkrsoft.com on 2017/12/7.
 * 导入接口定义的注解
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebImport {
    /**
     * 展示名称,如果不为空使用该字段的值展示，否则使用接口本身的名字
     *
     * @return 展示名称
     */
    String displayName() default "";

    /**
     * 导入接口交互模式，界面需要@WebPlugin中的apiDocSupport属性为真，才生效
     *
     * @return 默认只导入接口，无界面
     */
    WebGui gui() default WebGui.NONE;

    /**
     * 初始化的时候查询表格
     *
     * @return 是否进行初始化查询
     */
    boolean initQuery() default false;
    /**
     * 是否在进行事件触发前进行确认操作
     *
     * @return 确认操作
     */
    boolean confirm() default false;

    /**
     * 确认信息内容 支持$(变量名)表达式
     * @return
     */
    String confirmMessage() default "";
    /**
     * 布局
     *
     * @return 布局
     */
    WebLayout layout() default WebLayout.INLINE;

    /**
     * 导入接口时，该接口可以用在哪些模式
     * 查询页面，存在新增，则配置为{CREATE}
     * 在表单页面，存在修改，查看切换，则需要配置为{VIEW，UPDATE}
     * 在表单页面，存在删除，查看切换，则需要配置为{VIEW，DELETE}
     * DEFAULT,则根据具体情况提供默认实现,在表单页面等价于{VIEW,UPDATE,DELETE}
     * 在查询页面等价于{CREATE}
     *
     * @return 模式
     * @see WebMode
     */
    WebMode[] mode() default WebMode.OTHER;

    /**
     * 导入接口,顺序生成不同的选项卡，如果没有指定stageDisplay则从阶段1开始
     * 前一个接口有相同名称的字段作为级联接口的输入，第一个接口可以无输入
     * 格式别名=包名.类名.接口名:版本号，例如find=com.rnkrsoft.skeleton.UserService.findUser:1.0.0
     * 再导入单个接口时
     * <code>
     *     @WebImport( value = "find=com.rnkrsoft.skeleton.UserService.findUser:1.0.0")
     * </code>
     * 与
     * <code>
     *     @WebImport( serviceClass = UserService.class, value = "find=findUser:1.0.0")
     * </code>
     * @return 导入接口
     */
    String[] value();

    /**
     * 导入的接口所在类对象
     * @return 服务类对象
     */
    Class serviceClass() default Class.class;
}
