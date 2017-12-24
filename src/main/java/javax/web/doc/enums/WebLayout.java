package javax.web.doc.enums;

import com.devops4j.interfaces.EnumStringCode;

/**
 * Created by devops4j on 2017/12/5.
 * 组件布局类型
 */
public enum WebLayout implements EnumStringCode {
    INLINE("INLINE", "内联"),
    HORIZONTAL("HORIZONTAL", "水平");
    String code;
    String desc;

    WebLayout(String code, String desc) {
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
