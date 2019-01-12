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
 package javax.web.doc;

import javax.web.doc.enums.ElementType;
import javax.web.skeleton4j.element.ReferenceWebElement;
import javax.web.skeleton4j.enums.ColumnType;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;

/**
 * Created by rnkrsoft.com on 2017/12/5.
 * 字段信息父接口
 * @see ValueElementInfo
 * @see BeanElementInfo
 * @see FormElementInfo
 */
public interface ElementInfo {
    /**
     * 获取字段的映射界面组件
     *
     * @param page 映射到页面
     * @return 组件引用
     */
    ReferenceWebElement getMapping(WebPage page);

    /**
     * 字段类型
     *
     * @return 字段类型
     */
    ColumnType getColumnType();

    /**
     * 获取接口信息
     *
     * @return 接口信息
     */
    InterfaceInfo getInterfaceInfo();

    /**
     * 获取字段信息所在集合
     *
     * @return 字段信息所在集合
     */
    ElementSet getElementSet();

    /**
     * 字段属于请求对象
     *
     * @return 是否属于请求
     */
    boolean isBelongToRequest();

    /**
     * 字段数与应答对象
     *
     * @return 是否属于应答
     */
    boolean isBelongToResponse();

    /**
     * 获取WEB组件注册对象
     *
     * @return WEB组件注册对象
     */
    WebComponentRegistry getComponentRegistry();

    /**
     * 要素类型
     *
     * @return 要素类型
     */
    String getTypeName();

    /**
     * 要素类型
     *
     * @return 要素类型
     */
    ElementType getType();

    /**
     * 如果为ValueElementInfo返回真
     *
     * @return ValueElementInfo返回真
     */
    boolean isValue();

    /**
     * 如果为FormElementInfo返回真
     *
     * @return ormElementInfo返回真
     */
    boolean isForm();

    /**
     * 如果为BeanElementInfo返回真
     *
     * @return BeanElementInfo返回真
     */
    boolean isBean();

    /**
     * 将字段转换为具体的字段类型
     *
     * @param targetClass 目标类型
     * @param <T>         目标类型
     * @return 字段
     */
    <T extends ElementInfo> T as(Class<T> targetClass);

    /**
     * 要素名称，通常为英文
     *
     * @return 要素名称
     */
    String getName();

    /**
     * 获取字段完整名称
     *
     * @return 完整名称
     */
    String getFullName();

    /**
     * 要素描述
     * 如果描述为空，则取name的值
     *
     * @return 要素描述
     */
    String getDesc();

    /**
     * 要素用法
     * 如果用法为空，则取desc的值
     *
     * @return 要素用法
     */
    String getUsage();
}
