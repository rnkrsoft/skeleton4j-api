package javax.web.doc.enums;

import com.rnkrsoft.interfaces.EnumStringCode;

public enum Skeleton4jRspCode implements EnumStringCode {
    FAIL("001", "失败"),
    SUCCESS("000", "成功");
    String code;
    String desc;

    Skeleton4jRspCode(String code, String desc) {
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
