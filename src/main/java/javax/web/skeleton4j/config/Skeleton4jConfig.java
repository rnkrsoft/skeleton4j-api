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
package javax.web.skeleton4j.config;

import java.util.Collection;

/**
 * Created by rnkrsoft.com on 2017/12/16.
 * Skeleton4j配置对象
 */
public interface Skeleton4jConfig {
    /**
     * 临时输出路径
     */
    String TEMP_OUTPUT_PATH = "tempOutputPath";
    /**
     * 系统编号
     */
    String APP = "app";
    /**
     * 系统描述
     */
    String APP_DESC = "appDesc";
    /**
     * 主题包路径，多个;分割
     */
    String THEME_PACKAGES = "themePackages";
    /**
     * 接口包路径，多个;分割
     */
    String INTERFACE_PACKAGES = "interfacePackages";
    /**
     * 主题包路径，多个;分割
     */
    String PAGE_PACKAGES = "pagePackages";
    /**
     * 是否扫描子包
     */
    String SCAN_SUB_PACKAGE = "scanSubPackage";
    /**
     * 是否使用本地缓存
     */
    String USE_CACHE = "useCache";
    /**
     * 环境
     */
    String ENV = "env";
    /**
     * 是否使用开发模式
     */
    String DEV_MODE = "devMode";
    /**
     * 默认主题名
     */
    String DEFAULT_THEME = "defaultTheme";
    /**
     * 是否内联脚本
     */
    String INLINE_SCRIPT = "inlineScript";
    /**
     * 是否内联样式
     */
    String INLINE_STYLE = "inlineStyle";
    /**
     * 服务器地址,默认为空
     */
    String SERVER_HOST = "serverHost";
    /**
     * 服务器端口，默认为80
     */
    String SERVER_PORT = "serverPort";
    /**
     * 默认是否显示折叠菜单
     */
    String DEFAULT_SIDEBAR = "defaultSidebar";
    /**
     * 网页组件注册对象类名
     */
    String WEB_COMPONENT_REGISTRY_CLASS_NAME = "webComponentRegistryClassName";
    /**
     * Skeleton4j服务类
     */
    String SKELETON4J_SERVICE_CLASS_NAME = "skeleton4jServiceClassName";
    /**
     * 首页
     */
    String INDEX_PAGE = "indexPage";
    /**
     * ZOOKEEPER注册中心地址
     */
    String ZOOKEEPER_ADDRESS = "zookeeperAddress";
    /**
     * DUBBO直连提供者，如果为空，则使用注册中心
     */
    String DUBBO_DIRECT_PROVIDER = "dubboDirectProvider";
    /**
     * 文件储存URL
     */
    String FILE_STORE_URL = "fileStoreUrl";
    /**
     * 退出登录
     */
    String LOGOUT_URL = "logoutUrl";
    /**
     * 全局执行器
     */
    String GLOBAL_INTERFACE_CALL = "globalInterfaceCall";
    /**
     * 权限服务
     */
    String AUTHORITY_SERVICE_CLASS_NAME = "authorityServiceClassName";
    /**
     * 权限提取器
     */
    String AUTHORITY_EXTRACTOR_CLASS_NAME = "authorityExtractorClassName";

    /**
     * 列出所有参数的参数名
     *
     * @return 参数名集合
     */
    Collection<String> listParamNames();

    /**
     * 设置参数值
     *
     * @param paramName  参数名
     * @param paramValue 参数值
     * @return 配置对象
     */
    Skeleton4jConfig param(String paramName, String paramValue);

    /**
     * 向字符串型用分号分割的参数追加参数
     * @param paramName  参数名
     * @param paramValue 参数值
     * @return 配置对象
     */
    Skeleton4jConfig appendItem(String paramName, String paramValue);

    /**
     * 获取数组形式的参数值
     * @param paramName 参数名
     * @return 对参数为用;进行分割的进行拆分
     */
    String[] getArray(String paramName);

    /**
     * 获取参数
     *
     * @param paramName  参数名
     * @param paramClass 参数类型
     * @param <T>        参数值
     * @return 参数值
     */
    <T> T getParam(String paramName, Class<T> paramClass);

    /**
     * 获取字符串形式的参数
     *
     * @param paramName    参数名
     * @param defaultValue 如果不存在参数时使用的默认值
     * @return 参数值
     */
    String getString(String paramName, String defaultValue);

    /**
     * 获取整形形式的参数
     *
     * @param paramName    参数名
     * @param defaultValue 如果不存在参数时使用的默认值
     * @return 参数值
     */
    Integer getInteger(String paramName, Integer defaultValue);


    /**
     * 获取布尔值形式的参数
     *
     * @param paramName    参数名
     * @param defaultValue 如果不存在参数时使用的默认值
     * @return 参数值
     */
    Boolean getBoolean(String paramName, Boolean defaultValue);
}
