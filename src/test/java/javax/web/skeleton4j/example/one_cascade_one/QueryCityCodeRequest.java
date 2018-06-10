package javax.web.skeleton4j.example.one_cascade_one;

import javax.web.doc.annotation.ApidocElement;
import javax.web.doc.enums.WebDisplayType;
import javax.web.doc.enums.WebTriggerEvent;
import javax.web.skeleton4j.annotation.WebCascadeInterface;
import javax.web.skeleton4j.annotation.WebResultDisplay;

/**
 * Created by devops4j on 2017/12/7.
 */
public class QueryCityCodeRequest {
    /**
     * 该字段为distinctCode获取级联数据的例子
     */
    @ApidocElement(value = "城市",
            interfaces = {
                    @WebCascadeInterface(
                            cascadeEvent = WebTriggerEvent.CHANGE,
                            value = "com.rnkrsoft.service.queryCity",
                            resultDisplay = @WebResultDisplay(displayType = WebDisplayType.DATA_SOURCE, column = "distinctCode")
                    )
            })
    String cityCode;
    /**
     * 该字段为使用接口校验当前值的例子,右侧出现一个校验按钮，校验结果消息框提示
     */
    @ApidocElement(value = "区", interfaces = {
            @WebCascadeInterface(
                    cascadeEvent = WebTriggerEvent.VALIDATE_BUTTON,
                    value = "com.rnkrsoft.service.check",
                    //校验结果有两种提示MSG_BOX和HINT
                    resultDisplay = @WebResultDisplay(displayType = WebDisplayType.MSG_BOX)
            ),
            @WebCascadeInterface(
                    cascadeEvent = WebTriggerEvent.CHANGE,
                    value = "com.rnkrsoft.service.queryCity",
                    //校验结果有两种提示MSG_BOX和HINT
                    resultDisplay = @WebResultDisplay(displayType = WebDisplayType.DATA_SOURCE)
            )
    })
    String distinctCode;
}
