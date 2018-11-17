package javax.web.doc.enums;

import com.rnkrsoft.interfaces.EnumStringCode;

/**
 * Created by rnkrsoft.com on 2018/1/19.
 * 数据类型
 */
public enum DataType implements EnumStringCode {
    String("java.lang.String", "字符串"),
    Integer("java.lang.Integer", "整数"),
    Decimal("java.lang.BigDecimal", "浮点数"),
    Date("java.util.Date", "日期");
    String code;
    String desc;

    DataType(String code, String desc) {
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
