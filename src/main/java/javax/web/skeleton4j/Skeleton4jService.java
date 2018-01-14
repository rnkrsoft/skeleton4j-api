package javax.web.skeleton4j;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.web.doc.DocScanner;
import javax.web.skeleton4j.config.Skeleton4jConfig;
import javax.web.skeleton4j.pool.ModulePool;
import javax.web.skeleton4j.pool.PagePool;
import java.io.File;
import java.util.Collection;
import java.util.Set;

/**
 * Created by devops4j on 2017/12/16.
 * 核心服务
 */
public interface Skeleton4jService {
    /**
     * 默认页面类存放包路径
     */
    String DEFAULT_PAGES = "javax.web.skeleton4j.pages";
    /**
     * 默认主题类存放包路径
     */
    String DEFAULT_THEMES = "javax.web.skeleton4j.themes";
    /**
     * 获取当前配置对象
     *
     * @return 配置对象
     */
    Skeleton4jConfig getConfig();
    /**
     * 获取支持的Skeleton4j版本号
     *
     * @return 版本号集合
     */
    Set<String> getSupportVersions();
    /**
     * 初始化核心服务
     *
     * @param config        配置对象
     * @param docScanner    文档扫描器 如果不存在，则自动使用DocScannerFactory创建实例
     * @param modulePool    模块池 如果模块池不存在则自动创建
     * @param pagePool      页面池 如果页面池不存在则自动创建
     * @param pagePackages  页面包路径 页面路径默认需要包含javax.web.skeleton4j.page
     * @param themePackages 主题包路径 主题路径默认需要包含javax.web.skeleton4j.theme
     */
    void init(Skeleton4jConfig config, DocScanner docScanner, ModulePool modulePool, PagePool pagePool, Collection<String> pagePackages, Collection<String> themePackages);

    /**
     * 扫描所有页面类
     */
    void scan();

    /**
     * 编译页面类为代码
     *
     * @param pageClass 页面类
     * @return 生成页面文件路径
     */
    File compile(Class pageClass);

    /**
     * @param product  模块名称 模块名即权限中的product
     * @param action   页面名称 模块名即权限中的action
     *                 ，例如com.devops4j.page.demo.TestPlugin{
     *                 }s
     *                 modelName = 包名(product)
     *                 pageName = 类名缩写(action)
     *                 usbAction(page)//固定写法
     * @param version  版本号
     * @param theme    主题
     * @param request  HTTP请求对象
     * @param response HTTP应答对象
     */
    void page(String product, String action, String version, String theme, HttpServletRequest request, HttpServletResponse response);

    /**
     * 调用异步接口，所有暴露的接口都要依托于页面，没有页面就无法管理权限
     *
     * @param product   模块名称 包名(product)
     * @param action    类名缩写(action)
     * @param subAction 交易别名(subAction).通过模块中得接口定义原始类找到真实得接口，接口别名能够转换为接口名字和版本号
     * @param data      JSON 报文
     * @param request   HTTP请求对象
     * @param response  HTTP应答对象
     */
    void ajax(String product, String action, String subAction, String data, HttpServletRequest request, HttpServletResponse response);

    /**
     * 导入文件预览，返回解析出的数据页面
     *
     * @param product   模块名称 包名(product)
     * @param action    类名缩写(action)
     * @param subAction 交易别名(subAction).通过模块中得接口定义原始类找到真实得接口，接口别名能够转换为接口名字和版本号
     * @param data      JSON 报文
     * @param file      导入文件
     * @param request   HTTP请求对象
     * @param response  HTTP应答对象
     */
    void impPreview(String product, String action, String subAction, String data, File file, HttpServletRequest request, HttpServletResponse response);

    /**
     * 导入文件
     *
     * @param product   模块名称 包名(product)
     * @param action    类名缩写(action)
     * @param subAction 交易别名(subAction).通过模块中得接口定义原始类找到真实得接口，接口别名能够转换为接口名字和版本号
     * @param data      JSON 报文
     * @param file      导入文件
     * @param request   HTTP请求对象
     * @param response  HTTP应答对象
     */
    void imp(String product, String action, String subAction, String data, File file, HttpServletRequest request, HttpServletResponse response);

    /**
     * 导出文件
     *
     * @param product   模块名称 包名(product)
     * @param action    类名缩写(action)
     * @param subAction 交易别名(subAction).通过模块中得接口定义原始类找到真实得接口，接口别名能够转换为接口名字和版本号
     * @param data      JSON 报文
     * @param file      导入文件
     * @param request   HTTP请求对象
     * @param response  HTTP应答对象
     */
    void exp(String product, String action, String subAction, String data, File file, HttpServletRequest request, HttpServletResponse response);
}
