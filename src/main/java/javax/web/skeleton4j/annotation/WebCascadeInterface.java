package javax.web.skeleton4j.annotation;

import javax.web.doc.enums.WebLayout;
import javax.web.doc.enums.WebTriggerEvent;

/**
 * Created by rnkrsoft.com on 2017/12/7.
 * 用于定义级联接口
 */
public @interface WebCascadeInterface {
    /**
     * 级联接口
     * 格式别名=包名.类名.接口名:版本号，例如find=com.rnkrsoft.skeleton.UserService.findUser:1.0.0
     *
     * @return 接口引用格式
     */
    String value();

    /**
     * 引用接口所在服务类
     * @return
     */
    Class serviceClass() default Class.class;
    /**
     * 是否在进行事件触发前进行确认操作
     *
     * @return 确认操作
     */
    boolean confirm() default false;

    /**
     * 生成的模态框的元素布局，会覆盖接口定义中的布局
     *
     * @return 布局类型
     */
    WebLayout layout() default WebLayout.INLINE;
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
     * 展示名称，如果是按钮情况，则使用该字段的值展示，否则使用接口本身的名字
     *
     * @return 展示名称
     */
    String displayName() default "";

    /**
     * 当前级联接口调用时需要的级联入参数组，填入的时当前接口的Java字段名
     *
     * @return 级联字段数组
     */
    String[] cascadeColumn() default {};

    /**
     * 级联接口调用后结果如何展示
     *
     * @return 展示类型数组
     */
    WebResultDisplay[] resultDisplay() default @WebResultDisplay();

    /**
     * 级联事件
     *
     * @return 事件数组
     */
    WebTriggerEvent[] cascadeEvent() default WebTriggerEvent.CHANGE;
}
