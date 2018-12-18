package javax.web.skeleton4j.enums;

import com.rnkrsoft.interfaces.EnumStringCode;

/**
 * Created by rnkrsoft.com on 2018/12/18.
 * 规则方法
 */
public enum RuleMethod implements EnumStringCode {
    ACCEPT("accept", "接受"),
    IGNORE("ignore", "忽略");
    String code;
    String desc;

    RuleMethod(String code, String desc) {
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
