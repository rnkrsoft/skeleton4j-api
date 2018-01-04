package javax.web.doc;

import com.devops4j.interfaces.EnumIntegerCode;
import com.devops4j.interfaces.EnumStringCode;
import java.io.Serializable;

/**
 * 应答码可写接口
 */
public interface RspCodeWritable extends Serializable {
    /**
     * 设置应答码
     *
     * @param code 代码
     */
    void setRspCode(String code);

    /**
     * 设置应答描述
     *
     * @param desc 描述
     */
    void setRspDesc(String desc);

    /**
     * 设置应答码
     *
     * @param code 代码枚举
     */
    void setRspCode(EnumIntegerCode code);

    /**
     * 设置应答码
     *
     * @param code 代码枚举
     */
    void setRspCode(EnumStringCode code);
}
