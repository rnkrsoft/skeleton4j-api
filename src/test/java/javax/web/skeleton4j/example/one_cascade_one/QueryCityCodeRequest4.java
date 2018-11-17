package javax.web.skeleton4j.example.one_cascade_one;

import javax.web.doc.annotation.ApidocElement;
import javax.web.doc.enums.ValueDisplayType;
import javax.web.doc.enums.WebDisplayType;
import javax.web.doc.enums.WebTriggerEvent;
import javax.web.skeleton4j.annotation.WebCascadeInterface;
import javax.web.skeleton4j.annotation.WebResultDisplay;

/**
 * Created by rnkrsoft.com on 2017/12/7.
 * 当前接口级联接口，
 */
public class QueryCityCodeRequest4 {
    /**
     * 该字段为输入值，无级联接口
     */
    @ApidocElement(value = "国家", required = true)
    String countyCode;
    /**
     * 该字段为输入值，无级联接口
     */
    @ApidocElement(value = "城市", required = true)
    String cityCode;
    /**
     * 该字段为使用接口校验当前值的例子，校验结果消息框提示
     */
    @ApidocElement(value = "国家/城市/区1", valueDisplayType = ValueDisplayType.STRING, interfaces = {
            @WebCascadeInterface(
                    cascadeEvent = WebTriggerEvent.BLUR,//失去焦点时调用级联接口
                    value = "com.rnkrsoft.service.queryTree",
                    cascadeColumn = {"countyCode", "cityCode"},
                    resultDisplay = @WebResultDisplay(displayType = WebDisplayType.MSG_BOX, column = "")//将数据以消息框提示
            )
    })
    String distinctCode1;

    /**
     * 该字段为使用接口校验当前值的例子，校验结果消息框提示
     */
    @ApidocElement(value = "国家/城市/区2", valueDisplayType = ValueDisplayType.STRING, interfaces = {
            @WebCascadeInterface(
                    cascadeEvent = WebTriggerEvent.FOCUS,//获取焦点时调用级联接口
                    value = "com.rnkrsoft.service.queryTree",
                    cascadeColumn = {"countyCode", "cityCode"},
                    resultDisplay = @WebResultDisplay(displayType = WebDisplayType.INNER_HTML, column = "")//将结果作用于INNER_HTML，column为空，则作用于自身
            )
    })
    String distinctCode2;
}
