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

import lombok.Getter;
import lombok.ToString;

import javax.web.doc.enums.ElementSetType;
import javax.web.skeleton4j.enums.ColumnType;

/**
 * Created by rnkrsoft.com on 2017/12/12.
 * 接口信息对象
 */
@ToString(exclude = {"serviceInfo", "request", "response", "mappingRegistry", "docScanner"})
public class InterfaceInfo implements Comparable<InterfaceInfo> {
    @Getter
    DocScanner docScanner;
    /**
     * 所属服务
     */
    @Getter
    ServiceInfo serviceInfo;
    /**
     * 接口名称
     */
    @Getter
    String name;
    /**
     * 接口版本号
     */
    @Getter
    String version;
    /**
     * 接口描述
     */
    @Getter
    String desc;
    /**
     * 用法
     */
    @Getter
    String usage;
    /**
     * 接口类
     */
    @Getter
    String className;
    /**
     * 方法名
     */
    @Getter
    String methodName;

    @Getter
    ElementSet request;

    @Getter
    ElementSet response;

    public InterfaceInfo() {
    }

    public InterfaceInfo(ServiceInfo serviceInfo, String name, String version, String desc, String usage, String className, String methodName, Class requestClass, Class responseClass) {
        this.serviceInfo = serviceInfo;
        this.name = name;
        this.version = version;
        this.desc = desc;
        this.usage = usage;
        this.className = className;
        this.methodName = methodName;
        this.request = new ElementSet(requestClass, ElementSetType.REQUEST);
        this.response = new ElementSet(responseClass, ElementSetType.RESPONSE);
    }

    @Override
    public int compareTo(InterfaceInfo o) {
        if (name == null && o != null && o.name != null) {
            return 1;
        }
        if (name != null && o == null) {
            return -1;
        }
        int i = name.compareTo(o.name);
        if (i == 0) {
            return version.compareTo(o.getVersion());
        } else {
            return i;
        }
    }

    public int hashCode() {
        return name.hashCode() * 37 + version.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.name.equals(((InterfaceInfo) obj).name) && this.version.equals(((InterfaceInfo) obj).getVersion());
    }

    public ElementInfo lookup(String fullName) {
        ColumnType columnType = ColumnType.REQUEST;
        if (fullName.startsWith("request.")) {
            columnType = ColumnType.REQUEST;
            fullName = fullName.substring("request.".length());
        } else if (fullName.startsWith("response.")) {
            columnType = ColumnType.RESPONSE;
            fullName = fullName.substring("response.".length());
        }
        return lookup(columnType, fullName);
    }

    public ElementInfo lookup(ColumnType columnType, String fullName) {
        if (columnType == ColumnType.REQUEST) {
            return request.lookupFullName(fullName);
        } else if (columnType == ColumnType.RESPONSE) {
            return response.lookupFullName(fullName);
        }
        return null;
    }

    /**
     * 获取接口的完整类方法名
     *
     * @return 完整名称
     */
    public String getFullMethodName() {
        return serviceInfo.getServiceClassName() + "." + methodName;
    }

    /**
     * 获取接口的完整的接口名
     *
     * @return 完整的接口名
     */
    public String getFullName() {
        return serviceInfo.getName() + "." + name + "." + version;
    }

    /**
     * 获取请求类对象
     *
     * @return 请求类对象
     */
    public Class getRequestClass() {
        if (request == null) {
            return null;
        }
        return request.getElementClass();
    }

    /**
     * 获取应答类对象
     *
     * @return 应答类对象
     */
    public Class getResponseClass() {
        if (response == null) {
            return null;
        }
        return response.getElementClass();
    }

    /**
     * 根据当前接口信息创建引用对象
     *
     * @param namespace 命名空间
     * @param alias     别名
     * @return 引用对象
     */
    public ReferenceInterface makeReference(String namespace, String alias) {
        return new ReferenceInterface(docScanner, namespace, alias, serviceInfo.getServiceClassName(), name, version);
    }

    /**
     * 接口是否支持分页
     *
     * @return 是否支持分页
     */
    public boolean isPageable() {
        return request.isPageable() && response.isPageable();
    }
}
