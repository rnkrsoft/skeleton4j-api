package javax.web.doc;

import lombok.Getter;
import lombok.ToString;

import javax.web.skeleton4j.enums.ColumnType;

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
        this.request = new ElementSet(requestClass);
        this.response = new ElementSet(responseClass);
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
    public ElementInfo lookup(String fullName){
        ColumnType columnType = ColumnType.REQUEST;
        if (fullName.startsWith("request.")) {
            columnType = ColumnType.REQUEST;
            fullName = fullName.substring("request.".length());
        }else if(fullName.startsWith("response.")) {
            columnType = ColumnType.RESPONSE;
            fullName = fullName.substring("response.".length());
        }
        return lookup(columnType, fullName);
    }

    public ElementInfo lookup(ColumnType columnType, String fullName){
        if(columnType == ColumnType.REQUEST){
            return request.lookupFullName(fullName);
        }else if(columnType == ColumnType.RESPONSE) {
            return response.lookupFullName(fullName);
        }
        return null;
    }
    /**
     * 获取接口的完整类方法名
     * @return 完整名称
     */
    public String getFullMethodName(){
        return serviceInfo.getServiceClassName() + "." + methodName;
    }

    /**
     * 获取接口的完整的接口名
     * @return 完整的接口名
     */
    public String getFullName(){
        return serviceInfo.getName() + "." + name + "." + version;
    }

    /**
     * 获取请求类对象
     * @return 请求类对象
     */
    public Class getRequestClass(){
        if(request == null){
            return null;
        }
        return request.getElementClass();
    }

    /**
     * 获取应答类对象
     * @return 应答类对象
     */
    public Class getResponseClass(){
        if(response == null){
            return null;
        }
        return response.getElementClass();
    }

    /**
     * 根据当前接口信息创建引用对象
     * @param namespace 命名空间
     * @param alias 别名
     * @return 引用对象
     */
    public ReferenceInterface makeReference(String namespace, String alias){
        return new ReferenceInterface(docScanner, namespace, alias, serviceInfo.getServiceClassName(), name, version);
    }
    /**
     * 接口是否支持分页
     * @return 是否支持分页
     */
    public boolean isPageable(){
        return request.isPageable() && response.isPageable();
    }
}
