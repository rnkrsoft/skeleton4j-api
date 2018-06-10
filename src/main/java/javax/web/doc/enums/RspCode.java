package javax.web.doc.enums;

import com.rnkrsoft.interfaces.EnumStringCode;

public enum RspCode implements EnumStringCode {
    FAIL("0001", "失败"),
    SUCCESS("0000", "成功");
    String code;
    String desc;

    RspCode(String code, String desc) {
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
