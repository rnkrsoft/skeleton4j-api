package javax.web.skeleton4j.example.one_cascade_one;

import javax.web.doc.annotation.ApidocElement;
import javax.web.doc.enums.ValueDisplayType;
import javax.web.doc.enums.WebDisplayType;
import javax.web.skeleton4j.annotation.WebCascadeInterface;
import javax.web.skeleton4j.annotation.WebResultDisplay;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/12/7.
 */
public class QueryCityCodeRequest3 {
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
                            value = "com.rnkrsoft.service.queryCity",
                            cascadeColumn = {"countyCode"},//任何情况默认入参包括自身
                            //调用后结果影响到distinctCode字段为多选，则展示方式为RELOAD_OPTIONS,不支持VALUE
                            resultDisplay = @WebResultDisplay(displayType = WebDisplayType.DATA_SOURCE, column = "distinctCode")
                    )
            })
    String cityCode;
    /**
     * 该字段为使用接口校验当前值的例子，校验结果消息框提示
     */
    @ApidocElement(value = "多个区", valueDisplayType = ValueDisplayType.List)
    List<String> distinctCode;
}
