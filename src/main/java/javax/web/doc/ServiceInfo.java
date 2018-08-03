package javax.web.doc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rnkrsoft.com on 2017/12/5.
 * 服务信息
 */
@Data
@ToString(exclude = {"interfaces"})
@AllArgsConstructor
public class ServiceInfo implements Comparable<ServiceInfo> {
    final Set<InterfaceInfo> interfaces = new HashSet();
    /**
     * 服务名
     */
    String name;
    /**
     * 服务描述
     */
    String desc;
    /**
     * 服务类
     */
    Class<?> serviceClass;
    /**
     * 服务类全限定名
     */
    String serviceClassName;
    /**
     * 用法
     */
    String usage;

    @Override
    public int compareTo(ServiceInfo o) {
        if (name == null && o != null && o.name != null) {
            return 1;
        }
        if (name != null && o == null) {
            return -1;
        }
        return name.compareTo(o.name);
    }

    public int hashCode() {
        return name.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.name.equals(((InterfaceInfo) obj).name);
    }
}
