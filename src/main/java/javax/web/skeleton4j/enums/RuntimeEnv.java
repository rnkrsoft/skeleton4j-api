package javax.web.skeleton4j.enums;

import com.rnkrsoft.interfaces.EnumStringCode;

/**
 * Created by rnkrsoft.com on 2018/8/15.
 */
public enum RuntimeEnv implements EnumStringCode {
    DEV("DEV", "开发环境"),
    UAT("UAT", "功能测试环境"),
    PRE("PRE", "预发布环境"),
    GAY("GAY", "灰度环境"),
    PRO("PRO", "生产环境");
    String code;
    String desc;

    RuntimeEnv(String code, String desc) {
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

    public static RuntimeEnv valueOfCode(String code) {
        for (RuntimeEnv value : values()) {
            if (value.code.equalsIgnoreCase(code)) {
                return value;
            }
        }
        return DEV;
    }
}
