package javax.web.doc.enums;

import com.rnkrsoft.interfaces.EnumStringCode;

/**
 * Created by devops4j on 2017/12/5.
 * 触发事件类型,参照Jquery事件定义
 */
public enum WebTriggerEvent implements EnumStringCode {
    INIT("init", "页面初始化"),
    VALIDATE_BUTTON("validate_button", "数据校验按钮"),
    BLUR("blur", "元素失去焦点"),
    CHANGE("change", "值变化"),
    CLICK("click", "当用户点击某个对象时调用的事件句柄"),
    DBLCLICK("dblclick", "当用户双击某个对象时调用的事件句柄"),
    FOCUS("focus", "元素获得焦点"),
    KEYDOWN("keydown", "某个键盘按键被按下"),
    KEYPRESS("keypress", "某个键盘按键被按下并松开"),
    KEYUP("keyup", "某个键盘按键被松开"),
    MOUSEDOWN("mousedown", "当按下鼠标按钮时"),
    MOUSEENTER("mouseenter", "当鼠标指针进入（穿过）元素时"),
    MOUSELEAVE("mouseleave", "当鼠标指针离开元素时"),
    MOUSEMOVE("mousemove", "鼠标被移动"),
    MOUSEOUT("mouseout", "鼠标从某元素移开"),
    MOUSEOVER("mouseover", "当鼠标指针位于元素上方时时"),
    MOUSEUP("mouseup", "当松开鼠标按钮时"),
    SELECT("select", "文本被选中");
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
