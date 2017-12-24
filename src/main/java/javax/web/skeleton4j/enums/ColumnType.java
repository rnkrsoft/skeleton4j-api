package javax.web.skeleton4j.enums;

import com.devops4j.interfaces.EnumStringCode;

/**
 * Created by devops4j on 2017/12/12.
 */
public enum  ColumnType implements EnumStringCode{
    REQUEST("request","请求"),
    RESPONSE("response","应答");
    String code;
    String desc;

    ColumnType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
