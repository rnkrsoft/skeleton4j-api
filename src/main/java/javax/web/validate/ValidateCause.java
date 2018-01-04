package javax.web.validate;

import com.devops4j.interfaces.EnumIntegerCode;

public enum ValidateCause implements EnumIntegerCode{
    IS_NULL_DATA(1, "校验数据为空"),
    IS_REQUIRED(2, "字段为必输"),
    NOT_MATCH_MIN_LEN(3, "字段小于最小长度"),
    NOT_MATCH_MAX_LEN(4, "字段大于最大长度"),
    NOT_MATCH_FIXED_LEN(5, "字段不为固定长度"),
    NOT_MATCH_PATTERN(6, "字段不能匹配表达式"),
    NOT_MATCH_ENUM(7, "字段不能匹配枚举定义"),
    NOT_IMPLEMENT_ENUM_INTERFACE(8, "枚举未实现枚举接口");
    int code;
    String desc;

    ValidateCause(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
