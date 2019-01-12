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

import javax.web.skeleton4j.registry.WebComponentRegistry;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/12/5.
 * 文档扫描器接口
 */
public interface DocScanner {
    /**
     * 注册过滤器
     *
     * @param handler 处理器
     * @return 文档扫描器
     */
    DocScanner register(InterfaceObjectHandler handler);

    /**
     * 注册过滤字段过滤器
     * @param filter 过滤器
     * @return 文档扫描器
     */
    DocScanner register(InterfaceColumnFilter filter);

    /**
     * 设置类加载器
     *
     * @param classLoader 类加载器
     */
    void setClassLoader(ClassLoader classLoader);

    /**
     * 获取类加载器
     *
     * @return 类加载器
     */
    ClassLoader getClassLoader();

    /**
     * 设置组件注册类
     *
     * @param registry 组件注册类
     */
    void setComponentRegistry(WebComponentRegistry registry);

    /**
     * 获取组件注册类
     *
     * @return 组件注册类
     */
    WebComponentRegistry getComponentRegistry();

    /**
     * 增加扫描包路径
     *
     * @param packages 包路径
     * @return 文档扫描器
     */
    DocScanner addScanPackage(String... packages);

    /**
     * 获取扫描的包名数组
     * @return 包名数组
     */
    List<String> getScanPackages();

    /**
     * 初始化
     *
     * @param ifThrow  如果发生异常，是否抛出异常
     * @param packages 包路径
     * @return 文档扫描器
     */
    DocScanner init(boolean ifThrow, String... packages);

    /**
     * 扫描类
     *
     * @param ifThrow      如果发生异常，是否抛出异常
     * @param serviceClass 类，需要标注@ApidocService和@ApidocInterface
     */
    void scan(boolean ifThrow, Class<?> serviceClass);

    /**
     * 扫描类
     *
     * @param serviceClass 类，需要标注@ApidocService和@ApidocInterface
     */
    void scan(Class<?> serviceClass);

    /**
     * 定义字段元信息
     *
     * @param metadata 元信息
     * @return 文档扫描器
     */
    DocScanner define(ColumnDefineMetadata metadata);

    /**
     * 查询已经定义的字段，不输入则查询所有，输入则进行匹配，如果只有一个输入不能匹配则返回空列表
     *
     * @param names 字段名
     * @return 定义字段元信息列表
     */
    List<ColumnDefineMetadata> listDefinedColumns(String... names);

    /**
     * 列出所有的定义的字段名
     *
     * @return 字段名
     */
    List<String> listDefinedColumnNames();

    /**
     * 查询所有关键词，不输入则查询所有，输入则进行匹配，如果只有一个输入不能匹配则返回空列表
     *
     * @param keywords 关键词数组
     * @return 关键词封装列表
     */
    List<KeywordResult> lookupKeyword(String... keywords);

    /**
     * 列出已扫描的服务
     *
     * @return 服务列表
     */
    List<ServiceInfo> listService();

    /**
     * 根据服务类名获取服务信息
     * @param serviceName 类名
     * @return 服务信息
     */
    ServiceInfo lookupService(String serviceName);

    /**
     * 根据服务类对象获取服务信息
     * @param serviceClass 服务类
     * @return 服务信息
     */
    ServiceInfo lookupService(Class serviceClass);

    /**
     * 根据服务名，列出接口
     *
     * @param serviceNames 服务名
     * @return 接口列表
     */
    List<InterfaceInfo> listInterface(String... serviceNames);

    /**
     * 根据服务类，列出接口
     *
     * @param serviceClasses 服务类
     * @return 接口列表
     */
    List<InterfaceInfo> listInterface(Class<?>... serviceClasses);

    /**
     * 根据服务名和接口名列出接口，默认版本号1.0.0的
     *
     * @param serviceName   服务名
     * @param interfaceName 接口名
     * @return 接口
     */
    InterfaceInfo listInterface(String serviceName, String interfaceName);

    /**
     * 根据服务名和接口名列出接口
     *
     * @param serviceName   服务名
     * @param interfaceName 接口名
     * @param version       版本号
     * @return 接口
     */
    InterfaceInfo listInterface(String serviceName, String interfaceName, String version);
}
