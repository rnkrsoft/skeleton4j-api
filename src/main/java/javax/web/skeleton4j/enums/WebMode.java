package javax.web.skeleton4j.enums;

import javax.web.interfaces.EnumStringCode;

public enum WebMode implements EnumStringCode {
    CREATE("CREATE", "新建"),
    UPDATE("UPDATE", "修改"),
    VIEW("VIEW", "查看"),
    DELETE("DELETE", "删除"),
    QUERY("QUERY", "查询"),
    IMPORT("IMPORT", "导入"),
    EXPORT("EXPORT", "导出"),
    OTHER("OTHER", "其他");
    String code;
    String desc;

    WebMode(String code, String desc) {
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
