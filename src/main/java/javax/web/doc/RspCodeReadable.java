package javax.web.doc;

import java.io.Serializable;

/**
 * 应答码可读接口
 */
public interface RspCodeReadable extends Serializable {
    /**
     * 设置应答码
     */
    String getRspCode();

    /**
     * 设置应答描述
     */
    String getRspDesc();
}
