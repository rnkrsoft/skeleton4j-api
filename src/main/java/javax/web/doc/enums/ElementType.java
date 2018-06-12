package javax.web.doc.enums;

import com.rnkrsoft.interfaces.EnumStringCode;

/**
 * Created by devops4j on 2017/12/5.
 * 定义元素的类型
 */
public enum ElementType implements EnumStringCode {
    VALUE("value", "值元素"),
    FORM("form", "列表元素"),
    BEAN("bean", "对象元素");
    String code;
    String desc;

    ElementType(String code, String desc) {
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
