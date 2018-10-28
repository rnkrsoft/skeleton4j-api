package javax.web.validate;

import com.rnkrsoft.interfaces.EnumStringCode;

public enum ValidateCause implements EnumStringCode {
    SUCCESS("000", "校验通过"),
    IS_NULL("001", "校验数据为空"),
    IS_REQUIRED("002", "'${failFieldChsName}'为必填字段"),
    NOT_MATCH_MIN_LEN("003", "'${failFieldChsName}'字段最少要输入${minLen}个字符"),
    NOT_MATCH_MAX_LEN("004", "'${failFieldChsName}'字段最多可以输入${maxLen}个字符"),
    NOT_MATCH_FIXED_LEN("005", "${failFieldChsName}'字段,请输入长度${fixedLen}的字符串"),
    NOT_MATCH_PATTERN("006", "'${failFieldChsName}'字段不能匹配表达式'${pattern}'"),
    NOT_MATCH_ENUM("007", "字段不能匹配枚举定义"),
    NOT_IMPLEMENT_ENUM_INTERFACE("008", "枚举未实现枚举接口"),
    NOT_SUPPORT_DATA_TYPE("009", "不支持的数据类型"),
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
