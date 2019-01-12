/**
 * RNKRSOFT OPEN SOURCE SOFTWARE LICENSE TERMS ver.1
 * - 氡氪网络科技(重庆)有限公司 开源软件许可条款(版本1)
 * 氡氪网络科技(重庆)有限公司 以下简称Rnkrsoft。
 * 这些许可条款是 Rnkrsoft Corporation（或您所在地的其中一个关联公司）与您之间达成的协议。
 * 请阅读本条款。本条款适用于所有Rnkrsoft的开源软件项目，任何个人或企业禁止以下行为：
 * .禁止基于删除开源代码所附带的本协议内容、
 * .以非Rnkrsoft的名义发布Rnkrsoft开源代码或者基于Rnkrsoft开源源代码的二次开发代码到任何公共仓库,
 * 除非上述条款附带有其他条款。如果确实附带其他条款，则附加条款应适用。
 * <p/>
 * 使用该软件，即表示您接受这些条款。如果您不接受这些条款，请不要使用该软件。
 * 如下所述，安装或使用该软件也表示您同意在验证、自动下载和安装某些更新期间传输某些标准计算机信息以便获取基于 Internet 的服务。
 * <p/>
 * 如果您遵守这些许可条款，将拥有以下权利。
 * 1.阅读源代码和文档
 * 如果您是个人用户，则可以在任何个人设备上阅读、分析、研究Rnkrsoft开源源代码。
 * 如果您经营一家企业，则禁止在任何设备上阅读Rnkrsoft开源源代码,禁止分析、禁止研究Rnkrsoft开源源代码。
 * 2.编译源代码
 * 如果您是个人用户，可以对Rnkrsoft开源源代码以及修改后产生的源代码进行编译操作，编译产生的文件依然受本协议约束。
 * 如果您经营一家企业，不可以对Rnkrsoft开源源代码以及修改后产生的源代码进行编译操作。
 * 3.二次开发拓展功能
 * 如果您是个人用户，可以基于Rnkrsoft开源源代码进行二次开发，修改产生的元代码同样受本协议约束。
 * 如果您经营一家企业，不可以对Rnkrsoft开源源代码进行任何二次开发，但是可以通过联系Rnkrsoft进行商业授予权进行修改源代码。
 * 完整协议。本协议以及开源源代码附加协议，共同构成了Rnkrsoft开源软件的完整协议。
 * <p/>
 * 4.免责声明
 * 该软件按“原样”授予许可。 使用本文档的风险由您自己承担。Rnkrsoft 不提供任何明示的担保、保证或条件。
 * 5.版权声明
 * 本协议所对应的软件为 Rnkrsoft 所拥有的自主知识产权，如果基于本软件进行二次开发，在不改变本软件的任何组成部分的情况下的而二次开发源代码所属版权为贵公司所有。
 */
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
     * @return 确认信息内容
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
     *     &amp;WebImport( value = "find=com.rnkrsoft.skeleton.UserService.findUser:1.0.0")
     * </code>
     * 与
     * <code>
     *     &amp;WebImport( serviceClass = UserService.class, value = "find=findUser:1.0.0")
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
