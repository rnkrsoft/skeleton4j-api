package javax.web.doc;

import java.io.Serializable;

/**
 * Created by devops4j on 2017/12/5.
 * 请求接口
 * 用于实现接口模式的切换
 */
public interface Requestable extends Serializable {
    /**
     * 接口模式
     *
     * @return
     */
    String getInterfaceMode();

    /**
     * 设置接口模式
     *
     * @param interfaceMode
     */
    void setInterfaceMode(String interfaceMode);
}
