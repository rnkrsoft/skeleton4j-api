package javax.web.skeleton4j.enums;

import com.rnkrsoft.interfaces.EnumStringCode;

/**
 * Created by rnkrsoft.com on 2017/10/16.
 * 导入接口对应的业务模式
 * @see javax.web.skeleton4j.annotation.WebImport
 *
 */
public enum WebMode implements EnumStringCode {
    CREATE("CREATE", "新建"),
    DELETE("DELETE", "删除"),
    UPDATE("UPDATE", "修改"),
    VIEW("VIEW", "查看"),
    QUERY("QUERY", "查询"),
    IMPORT("IMPORT", "导入"),
    EXPORT("EXPORT", "导出"),
    URL("URL","URL"),
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
