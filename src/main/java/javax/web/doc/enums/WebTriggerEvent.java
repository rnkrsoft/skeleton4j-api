package javax.web.doc.enums;

import com.devops4j.interfaces.EnumStringCode;

/**
 * Created by devops4j on 2017/12/5.
 * 触发事件类型
 */
public enum WebTriggerEvent implements EnumStringCode {
    VALIDATE_BUTTON("VALIDATE_BUTTON", "数据校验按钮"),
    CLICK("CLICK", "当用户点击某个对象时调用的事件句柄"),
    DBLCLICK("DBLCLICK", "当用户双击某个对象时调用的事件句柄"),
    CHANGE("CHANGE", "值变化"),
    INIT("INIT","页面初始化"),
    BLUR("BLUR", "元素失去焦点"),
    FOCUS("FOCUS", "元素获得焦点"),
    KEYDOWN("KEYDOWN", "某个键盘按键被按下"),
    KEYPRESS("KEYPRESS", "某个键盘按键被按下并松开"),
    KEYUP("KEYUP", "某个键盘按键被松开"),
    MOUSEMOVE("MOUSEMOVE", "鼠标被移动"),
    MOUSEOUT("MOUSEOUT", "鼠标从某元素移开"),
    SELECT("SELECT", "文本被选中");
    String code;
    String desc;

    WebTriggerEvent(String code, String desc) {
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
