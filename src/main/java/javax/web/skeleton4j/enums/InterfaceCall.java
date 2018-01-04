package javax.web.skeleton4j.enums;

import com.devops4j.interfaces.EnumStringCode;

public enum InterfaceCall implements EnumStringCode {
    DUBBO("DUBBO", "DUBBO调用"),
    LOCAL("LOCAL", "本地调用");
    String code;
    String desc;

    InterfaceCall(String code, String desc) {
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
