package javax.web.validate;

import com.rnkrsoft.interfaces.EnumStringCode;

public enum ValidateCause implements EnumStringCode {
    SUCCESS("000", "校验通过"),
    IS_NULL_DATA("001", "校验数据为空"),
    IS_REQUIRED("002", "字段为必输"),
    NOT_MATCH_MIN_LEN("003", "字段小于最小长度"),
    NOT_MATCH_MAX_LEN("004", "字段大于最大长度"),
    NOT_MATCH_FIXED_LEN("005", "字段不为固定长度"),
    NOT_MATCH_PATTERN("006", "字段不能匹配表达式"),
    NOT_MATCH_ENUM("007", "字段不能匹配枚举定义"),
    NOT_IMPLEMENT_ENUM_INTERFACE("008", "枚举未实现枚举接口"),
    NOT_SUPPORT_JAVA_TYPE("009", "不支持的JAVA数据类型"),
    NOT_DEFINE_ENUM_FACTORY_METHOD("010", "枚举未定义工厂方法");
    String code;
    String desc;

    ValidateCause(String code, String desc) {
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
