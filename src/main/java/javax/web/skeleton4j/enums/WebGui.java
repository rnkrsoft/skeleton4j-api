package javax.web.skeleton4j.enums;

import com.devops4j.interfaces.EnumStringCode;

public enum WebGui implements EnumStringCode {
    /**
     * 无界面，只导入接口，可以访问后端接口
     */
    NONE("NONE", "无界面"),
    /**
     * 表单格式的界面，上部为表单输入内容，下面为表单结果，如果只实现ResponseReadable接口，则展示为应答为对话框展示；
     * 如果还实现了ResponsePagable则将records展示为表格，表格中的按钮按照记录中标记为Key
     */
    FORM("FORM", "表单"),
    /**
     * 生成模态框
     */
    MODEL("MODEL", "模态框"),
    /**
     * 生成提示框
     */
    MSG_BOX("MSG_BOX", "消息提示框"),
    /**
     * 交互类型为向导方式的接口，在@WebPlug加入的接口按照@ApidocElement中的stage
     * 交互界面展示不同阶段在一个FRAME中，不同标签卡
     */
    GUIDE_TAB("GUIDE_TAB", "向导"),
    /**
     * 交互类型为向导方式的接口，在@WebPlug加入的接口按照@ApidocElement中的stage
     * 交互界面展示不同阶段为一个FRAME框
     */
    GUIDE_FRAME("GUIDE_FRAME", "向导"),
    /**
     * 交互类型为级联时，，在@WebPlug加入的接口按照各自导入的接口@ApidocInterface中的stage
     * 交互界面展示不同阶段在一个FRAME中，不同标签卡
     */
    CASCADE_TAB("CASCADE_TAB", "级联"),
    /**
     * 交互类型为级联时，，在@WebPlug加入的接口按照各自导入的接口@ApidocInterface中的stage
     * 交互界面展示不同阶段为一个FRAME框
     */
    CASCADE_FRAME("CASCADE_FRAME", "级联");
    String code;
    String desc;

    WebGui(String code, String desc) {
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
