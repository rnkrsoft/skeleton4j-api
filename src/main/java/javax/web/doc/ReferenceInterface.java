package javax.web.doc;

import lombok.Getter;

/**
 * Created by rnkrsoft.com on 2017/12/5.
 * 接口引用对象，用于对接口的非直接引用
 */
public class ReferenceInterface {
    @Getter
    DocScanner docScanner;
    /**
     * 命名空间
     */
    @Getter
    String namespace;
    /**
     * 接口别名
     */
    @Getter
    String alias;
    /**
     * 服务名，并非服务类名
     */
    @Getter
    String serviceName;
    /**
     * 接口名，并非方法名
     */
    @Getter
    String interfaceName;
    /**
     * 接口版本号
     */
    @Getter
    String version;

    /**
     * 复制一个接口引用对象
     *
     * @param namespace 命名空间
     * @param ref       引用对象
     */
    public ReferenceInterface(String namespace, ReferenceInterface ref) {
        this(ref.docScanner, namespace, ref.alias, ref.serviceName, ref.interfaceName, ref.version);
    }

    /**
     * 复制一个接口引用对象
     *
     * @param ref 引用对象
     */
    public ReferenceInterface(ReferenceInterface ref) {
        this(ref.docScanner, ref.getNamespace(), ref.alias, ref.serviceName, ref.interfaceName, ref.version);
    }

    /**
     * 构建一个接口引用对象
     *
     * @param docScanner    文档扫描器
     * @param namespace     命名空间
     * @param alias         别名
     * @param serviceName   服务名，并非服务类名
     * @param interfaceName 接口名，并非方法名
     * @param version       接口版本号
     */
    public ReferenceInterface(DocScanner docScanner, String namespace, String alias, String serviceName, String interfaceName, String version) {
        this.docScanner = docScanner;
        this.namespace = namespace;
        this.alias = alias;
        this.serviceName = serviceName;
        this.interfaceName = interfaceName;
        this.version = version;
    }

    /**
     * 获取真实的接口定义信息,通过延迟解析
     *
     * @return 接口定义信息
     */
    public InterfaceInfo get() {
        if (docScanner == null) {
            throw new NullPointerException("docScanner未初始化");
        }
        return docScanner.listInterface(serviceName, interfaceName, version);
    }

    /**
     * 检测接口是否存在
     *
     * @return 是否存在
     */
    public boolean exists() {
        if (docScanner == null) {
            throw new NullPointerException("docScanner未初始化");
        }
        InterfaceInfo interfaceInfo = docScanner.listInterface(serviceName, interfaceName);
        return interfaceInfo != null;
    }

    public String toString() {
        return alias + "=" + serviceName + "." + interfaceName + ":" + version;
    }
}
