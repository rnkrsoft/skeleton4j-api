package javax.web.skeleton4j.example.one_cascade_one;

import javax.web.doc.annotation.ApidocElement;
import javax.web.doc.enums.ValueDisplayType;
import javax.web.doc.enums.WebDisplayType;
import javax.web.doc.enums.WebTriggerEvent;
import javax.web.skeleton4j.annotation.WebCascadeInterface;
import javax.web.skeleton4j.annotation.WebResultDisplay;
import java.util.List;

/**
 * Created by devops4j on 2017/12/7.
 */
public class QueryCityCodeRequest2 {
    /**
     * 该字段为输入值，无级联接口
     */
    @ApidocElement(value = "国家", required = true)
    String countyCode;
    /**
     * 该字段级联查询接口，需要国家和城市为入参
     */
    @ApidocElement(value = "城市",
            interfaces = {
                    @WebCascadeInterface(
                            cascadeEvent = WebTriggerEvent.BLUR,
                            value = "com.devops4j.service.queryDistinctCode",
                            cascadeColumn = {"countyCode"},//任何情况默认入参包括自身
                            //调用后结果影响到distinctCode字段的值，获取单选数据
                            resultDisplay = @WebResultDisplay(displayType = WebDisplayType.DATA_SOURCE, column = "distinctCode1")
                    )
            })
    String cityCode1;
    /**
     * 该字段为使用接口校验当前值的例子，校验结果消息框提示
     */
    @ApidocElement(value = "区")
    String distinctCode1;


    /**
     * 该字段级联查询接口，需要国家和城市为入参
     */
    @ApidocElement(value = "城市",
            interfaces = {
                    @WebCascadeInterface(
                            cascadeEvent = WebTriggerEvent.BLUR,
                            value = "com.devops4j.service.queryDistinctCode",
                            cascadeColumn = {"countyCode"},//任何情况默认入参包括自身
                            //调用后结果影响到distinctCode2字段的,distinctCode2为多选，则结果影响类型必须为RELOAD_OPTIONS或者INNER_HTML
                            resultDisplay = @WebResultDisplay(displayType = WebDisplayType.DATA_SOURCE, column = "distinctCode2")
                    )
            })
    String cityCode2;
    /**
     * 该字段为使用接口校验当前值的例子，校验结果消息框提示
     */
    @ApidocElement(value = "区", valueDisplayType = ValueDisplayType.List)
    List<String> distinctCode2;


    /**
     * 该字段级联查询接口，需要国家和城市为入参
     */
    @ApidocElement(value = "城市",
            interfaces = {
                    @WebCascadeInterface(
                            cascadeEvent = WebTriggerEvent.BLUR,
                            value = "com.devops4j.service.queryDistinctCode",
                            cascadeColumn = {"countyCode"},//任何情况默认入参包括自身
                            //调用后结果为URL地址，则自动开一个新窗口
                            resultDisplay = @WebResultDisplay(displayType = WebDisplayType.OPEN_URL_WINDOW)
                    )
            })
    String cityCode3;

    /**
     * 该字段级联查询接口，需要国家和城市为入参
     */
    @ApidocElement(value = "城市",
            interfaces = {
                    @WebCascadeInterface(
                            cascadeEvent = WebTriggerEvent.BLUR,
                            value = "com.devops4j.service.queryDistinctCode",
                            cascadeColumn = {"countyCode"},//任何情况默认入参包括自身
                            //调用后结果为RSP_CODE和RSP_DESC，则用消息框展示
                            resultDisplay = @WebResultDisplay(displayType = WebDisplayType.MSG_BOX)
                    )
            })
    String cityCode4;

    /**
     * 该字段级联查询接口，需要国家和城市为入参
     */
    @ApidocElement(value = "城市",
            interfaces = {
                    @WebCascadeInterface(
                            cascadeEvent = WebTriggerEvent.BLUR,
                            value = "com.devops4j.service.queryDistinctCode",
                            cascadeColumn = {"countyCode"},//任何情况默认入参包括自身
                            //调用后结果为RSP_CODE和RSP_DESC，则在column指定的字段进行文本提示
                            resultDisplay = @WebResultDisplay(displayType = WebDisplayType.HINT, column = "cityCode4")
                    )
            })
    String cityCode5;

    /**
     * 该字段级联查询接口，需要国家和城市为入参
     */
    @ApidocElement(value = "城市",
            interfaces = {
                    @WebCascadeInterface(
                            cascadeEvent = WebTriggerEvent.BLUR,
                            value = "com.devops4j.service.queryDistinctCode",
                            cascadeColumn = {"countyCode"},//任何情况默认入参包括自身
                            //调用后结果为级联接口的应答以表单方式展示
                            resultDisplay = @WebResultDisplay(displayType = WebDisplayType.DIALOG_BOX)
                    )
            })
    String cityCode6;
}
