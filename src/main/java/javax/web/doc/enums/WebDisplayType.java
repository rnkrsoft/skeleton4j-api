package javax.web.doc.enums;

import com.devops4j.interfaces.EnumStringCode;

/**
 * Created by devops4j on 2017/12/5.
 * 结果展示类型，定义了接口结果的展示方式
 */
public enum WebDisplayType implements EnumStringCode {
    DEFAULT("DEFAULT", "根据情况展示"),
    TABLE("TABLE", "表格"),
    MSG_BOX("MSG_BOX", "消息框"),
    DIALOG_BOX("DIALOG_BOX", "对话框"),
    OPEN_URL_WINDOW("OPEN_URL_WINDOW", "在新窗口打开一个地址"),
    OPEN_URL_DIALOG("OPEN_URL_DIALOG", "在模态框打开一个地址"),
    HINT("HINT", "提示框"),
    DATA_SOURCE("DATA_SOURCE", "数据源"),
    INNER_HTML("INNER_HTML", "HTML内容填充");
    String code;
    String desc;

    WebDisplayType(String code, String desc) {
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
