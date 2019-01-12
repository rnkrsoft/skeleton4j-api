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

import com.rnkrsoft.logtrace4j.ErrorContextFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by rnkrsoft.com on 2017/12/5.
 * 接口引用对象，用于对接口的非直接引用
 */
@Slf4j
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
        InterfaceInfo interfaceInfo = docScanner.listInterface(serviceName, interfaceName, version);
        if (interfaceInfo == null) {
            log.error("获取接口'{}'失败, 但是当前存在如下接口\n '{}'", this, docScanner.listService());
            throw ErrorContextFactory.instance()
                    .message("{}接口不存在", this)
                    .solution("检查服务类'{}'是否存在名为'{}'的接口方法并确认其版本号为'{}'", serviceName, interfaceName, version)
                    .runtimeException();
        }
        return interfaceInfo;
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
        InterfaceInfo interfaceInfo = docScanner.listInterface(serviceName, interfaceName, version);
        if (interfaceInfo == null) {
            log.error("接口'{}'不存在, 但是当前存在如下接口\n '{}'", this, docScanner.listService());
            return false;
        } else {
            return true;
        }
    }

    public String toString() {
        return alias + "=" + serviceName + "." + interfaceName + ":" + version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReferenceInterface that = (ReferenceInterface) o;

        if (namespace != null ? !namespace.equals(that.namespace) : that.namespace != null) return false;
        if (alias != null ? !alias.equals(that.alias) : that.alias != null) return false;
        if (serviceName != null ? !serviceName.equals(that.serviceName) : that.serviceName != null) return false;
        if (interfaceName != null ? !interfaceName.equals(that.interfaceName) : that.interfaceName != null)
            return false;
        return !(version != null ? !version.equals(that.version) : that.version != null);

    }

    @Override
    public int hashCode() {
        int result = namespace != null ? namespace.hashCode() : 0;
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + (interfaceName != null ? interfaceName.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}
