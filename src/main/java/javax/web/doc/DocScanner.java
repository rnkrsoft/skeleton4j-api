package javax.web.doc;

import javax.web.skeleton4j.registry.WebComponentRegistry;
import java.util.List;

/**
 * Created by devops4j on 2017/12/5.
 * 文档扫描器接口
 */
public interface DocScanner {
    WebComponentRegistry getComponentRegistry();
    void setComponentRegistry(WebComponentRegistry componentRegistry);
    /**
     * 增加扫描包路径
     *
     * @param packages 包路径
     * @return 文档扫描器
     */
    DocScanner addScanPackage(String... packages);

    /**
     * 初始化
     *
     * @param ifThrow 如果发生异常，是否抛出异常
     * @return 文档扫描器
     */
    DocScanner init(boolean ifThrow);

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
     * @param ifThrow 如果发生异常，是否抛出异常
     * @param clazz   类，需要标注@ApidocService和@ApidocInterface
     */
    void scan(boolean ifThrow, Class<?> clazz);

    /**
     * 列出已扫描的服务
     *
     * @return 服务列表
     */
    List<ServiceInfo> listService();

    /**
     * 根据服务名，列出接口
     *
     * @param serviceNames 服务名
     * @return 接口
     */
    List<InterfaceInfo> listInterface(String... serviceNames);

    /**
     * 根据服务类，列出接口
     *
     * @param serviceClasses 服务类
     * @return 接口
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
