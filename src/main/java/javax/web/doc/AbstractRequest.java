package javax.web.doc;

import lombok.ToString;

import javax.web.doc.annotation.ApidocElement;
import javax.web.skeleton4j.enums.WebMode;

/**
 * Created by rnkrsoft.com on 2017/12/5.
 * 请求接口
 */
@ToString
public abstract class AbstractRequest implements Requestable {
    @ApidocElement(value = "接口模式", enumClass = WebMode.class, required = false, hidden = true)
    String interfaceMode;

    /**
     * 接口模式
     *
     * @return 接口模式
     */
    public final String getInterfaceMode() {
        return interfaceMode;
    }

    /**
     * 接口模式
     *
     * @param interfaceMode 接口模式
     */
    public final void setInterfaceMode(String interfaceMode) {
        this.interfaceMode = interfaceMode;
    }
}
