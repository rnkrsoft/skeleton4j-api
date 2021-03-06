/**
 * RNKRSOFT OPEN SOURCE SOFTWARE LICENSE TERMS ver.1
 * - 氡氪网络科技(重庆)有限公司 开源软件许可条款(版本1)
 * 氡氪网络科技(重庆)有限公司 以下简称Rnkrsoft。
 * 这些许可条款是 Rnkrsoft Corporation（或您所在地的其中一个关联公司）与您之间达成的协议。
 * 请阅读本条款。本条款适用于所有Rnkrsoft的开源软件项目，任何个人或企业禁止以下行为：
 * .禁止基于删除开源代码所附带的本协议内容、
 * .以非Rnkrsoft的名义发布Rnkrsoft开源代码或者基于Rnkrsoft开源源代码的二次开发代码到任何公共仓库,
 * 除非上述条款附带有其他条款。如果确实附带其他条款，则附加条款应适用。
 * <p/>
 * 使用该软件，即表示您接受这些条款。如果您不接受这些条款，请不要使用该软件。
 * 如下所述，安装或使用该软件也表示您同意在验证、自动下载和安装某些更新期间传输某些标准计算机信息以便获取基于 Internet 的服务。
 * <p/>
 * 如果您遵守这些许可条款，将拥有以下权利。
 * 1.阅读源代码和文档
 * 如果您是个人用户，则可以在任何个人设备上阅读、分析、研究Rnkrsoft开源源代码。
 * 如果您经营一家企业，则禁止在任何设备上阅读Rnkrsoft开源源代码,禁止分析、禁止研究Rnkrsoft开源源代码。
 * 2.编译源代码
 * 如果您是个人用户，可以对Rnkrsoft开源源代码以及修改后产生的源代码进行编译操作，编译产生的文件依然受本协议约束。
 * 如果您经营一家企业，不可以对Rnkrsoft开源源代码以及修改后产生的源代码进行编译操作。
 * 3.二次开发拓展功能
 * 如果您是个人用户，可以基于Rnkrsoft开源源代码进行二次开发，修改产生的元代码同样受本协议约束。
 * 如果您经营一家企业，不可以对Rnkrsoft开源源代码进行任何二次开发，但是可以通过联系Rnkrsoft进行商业授予权进行修改源代码。
 * 完整协议。本协议以及开源源代码附加协议，共同构成了Rnkrsoft开源软件的完整协议。
 * <p/>
 * 4.免责声明
 * 该软件按“原样”授予许可。 使用本文档的风险由您自己承担。Rnkrsoft 不提供任何明示的担保、保证或条件。
 * 5.版权声明
 * 本协议所对应的软件为 Rnkrsoft 所拥有的自主知识产权，如果基于本软件进行二次开发，在不改变本软件的任何组成部分的情况下的而二次开发源代码所属版权为贵公司所有。
 */
package javax.web.skeleton4j.example.one_cascade_one;

import javax.web.doc.annotation.ApidocElement;
import javax.web.doc.enums.WebDisplayType;
import javax.web.doc.enums.WebTriggerEvent;
import javax.web.skeleton4j.annotation.WebCascadeInterface;
import javax.web.skeleton4j.annotation.WebResultDisplay;
import javax.web.validate.annotation.ValidateMessage;
import javax.web.validate.annotation.ValidateResult;

/**
 * Created by rnkrsoft.com on 2017/12/7.
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
            },
            validateResult = @ValidateResult(
                    isRequired = @ValidateMessage("在${failObjectValue}中 ${failFieldName}(${failFieldChsName})${failFieldName}当前为${failValue},不支持，应该修改为'xssd")
            )
    )
    String cityCode;
    /**
     * 该字段为使用接口校验当前值的例子,右侧出现一个校验按钮，校验结果消息框提示
     */
    @ApidocElement(value = "区", interfaces = {
            @WebCascadeInterface(
                    cascadeEvent = WebTriggerEvent.BUTTON,
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
