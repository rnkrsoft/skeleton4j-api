package javax.web.skeleton4j.enums;

import com.devops4j.interfaces.EnumStringCode;

/**
 * Created by devops4j on 2018/1/22.
 * 管理台前端调用后端接口的方式
 */
public enum WebCallType implements EnumStringCode {
    AJAX("AJAX", "AJAX调用"),
    SHOW("SHOW", "显示"),
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
