package javax.web.doc.enums;

import javax.interfaces.EnumStringCode;

public enum RspCode implements EnumStringCode {
    FAIL("9999999", "失败"),
    SUCCESS("AAAAAAA", "成功");
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
