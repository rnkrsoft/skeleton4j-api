package javax.web.doc.enums;

import com.rnkrsoft.interfaces.EnumStringCode;

/**
 * Created by rnkrsoft.com on 2018/1/19.
 * 过滤类型
 */
public enum FilterType implements EnumStringCode {
    ACCEPT("ACCEPT", "接受"),
    IGNORE("IGNORE", "忽略");
    String code;
    String desc;

    FilterType(String code, String desc) {
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
