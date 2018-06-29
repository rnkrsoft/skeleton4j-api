package javax.web.doc;

import java.io.Serializable;

/**
 * Created by rnkrsoft.com on 2017/12/5.
 * 请求接口
 * 用于实现接口模式的切换
 */
public interface Requestable extends Serializable {
    /**
     * 接口模式
     *
     * @return 接口模式
     */
    String getInterfaceMode();

    /**
     * 设置接口模式
     *
     * @param interfaceMode 接口模式
     */
    void setInterfaceMode(String interfaceMode);
}
