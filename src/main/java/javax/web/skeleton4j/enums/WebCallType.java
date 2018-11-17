package javax.web.skeleton4j.enums;

import com.rnkrsoft.interfaces.EnumStringCode;

/**
 * Created by rnkrsoft.com on 2018/1/22.
 * 管理台前端调用后端接口的方式
 */
public enum WebCallType implements EnumStringCode {
    AJAX("AJAX", "AJAX调用"),
    ONLY_SHOW("ONLY_SHOW", "只显示界面"),
    EXPORT("EXPORT", "导出"),
    IMPORT("IMPORT", "导入"),
    URL("URL", "URL调用");
    String code;
    String desc;

    WebCallType(String code, String desc) {
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
