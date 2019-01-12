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
 package javax.web.doc.annotation;

import javax.web.doc.enums.PatternType;
import javax.web.doc.enums.ValueDisplayType;
import javax.web.skeleton4j.annotation.WebCascadeInterface;
import javax.web.skeleton4j.annotation.WebCascadeMenuLevel1;
import javax.web.validate.annotation.ValidateResult;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by rnkrsoft.com on 2017/12/5.
 * 用于在接口上标注字段
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface ApidocElement {
    /**
     * 是否为唯一主键，标记为唯一组件，则可用于管理系统中表格中按钮事件的传值
     *
     * @return 是否为唯一主键
     */
    boolean unique() default false;

    /**
     * 字段描述
     *
     * @return 字段描述
     */
    String value() default "";

    /**
     * 字段作为界面元素时，是否为只读属性
     *
     * @return 是否为只读
     */
    boolean readonly() default false;

    /**
     * 最大长度
     *
     * @return 最大长度
     */
    int maxLen() default 255;

    /**
     * 最小长度
     *
     * @return 最小长度
     */
    int minLen() default 0;

    /**
     * 是否必输
     *
     * @return 是否必输
     */
    boolean required() default true;

    /**
     * 当前字段作为界面元素时是否为自适应展示。
     * 如果为假，无论何时都展示；
     * 如果为真，在界面宽度不够则隐藏，在宽度足够则显示
     * @return 是否为自适应显示
     */
    boolean adaptive() default false;

    /**
     * 字段类型
     * ValueDisplayType.String将数据展示为输入框
     * ValueDisplayType.Integer将数据展示为输入框
     * ValueDisplayType.Decimal将数据展示为输入框
     * ValueDisplayType.Boolean将数据展示为状态切换框
     * ValueDisplayType.List将数据展示为表格
     * ValueDisplayType.Date将数据展示为日期选择框，字段必须为String
     * ValueDisplayType.Image将数据展示为图片，字段必须为String
     * ValueDisplayType.Tree将数据展示为Tree，单选时字段为String,复选时字段为Set或者List
     * ValueDisplayType.Markdown将数据展示为Markdown编辑器，字段必须为String
     * ValueDisplayType.RichText将数据展示为富文本编辑器，字段必须为String
     * ValueDisplayType.Json将数据展示为Json编辑器，字段必须为String
     * ValueDisplayType.Selection将数据展示为可以选择的单选或则复选，单选时字段为String,复选时字段为Set或者List
     *
     * @return 字段类型
     */
    ValueDisplayType valueDisplayType() default ValueDisplayType.AUTO;

    /**
     * CSS 类信息
     * @return CSS类选择器
     */
    String[] cssClasses() default {};

    /**
     * 枚举字典类
     *
     * @return 枚举类，如果未定义则为Object
     */
    Class enumClass() default Object.class;

    /**
     * 默认值,可以定义组初始值
     *
     * @return 默认值列表
     */
    String[] defaults() default {};

    /**
     * 字段作为界面元素时，显示的占位符，如果为空，则默认使用desc
     *
     * @return 占位符
     */
    String placeholder() default "";

    /**
     * 表达式类型，默认正则表达式
     *
     * @return 表达式类型
     */
    PatternType patternType() default PatternType.AUTO;

    /**
     * 表达式
     *
     * @return 表达式
     */
    String[] pattern() default {};

    /**
     * 级联接口，用于定义元素的级联接口事件
     *
     * @return 级联接口列表
     */
    WebCascadeInterface[] interfaces() default {};

    /**
     * 级联一级菜单集合接口，用于定义一级菜单的级联接口
     * @return 级联的一级菜单数组
     */
    WebCascadeMenuLevel1[] menus() default {};

    /**
     * 是否为隐藏字段
     *
     * @return 否为隐藏
     */
    boolean hidden() default false;

    /**
     * 当前字段校验的结果定义
     * @return 当前字段的校验结果
     */
    ValidateResult validateResult() default @ValidateResult;
}
