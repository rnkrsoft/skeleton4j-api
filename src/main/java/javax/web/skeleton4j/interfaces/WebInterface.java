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
package javax.web.skeleton4j.interfaces;

import lombok.Getter;
import lombok.Setter;

import javax.web.doc.ReferenceInterface;
import javax.web.doc.enums.WebDisplayType;
import javax.web.doc.enums.WebTriggerEvent;
import javax.web.skeleton4j.element.ReferenceWebElement;
import javax.web.skeleton4j.element.component.WebComponent;
import javax.web.skeleton4j.enums.WebCallType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/12/8.
 * 远端接口调用信息类，定义Web前端交互的信息
 */
@Getter
public class WebInterface {
    /**
     * 执行前显示的界面
     */
    final List<ReferenceWebElement> preExecutes;
    /**
     * URL地址
     */
    String url;
    /**
     * 调用类型
     */
    WebCallType callType;
    /**
     * 产品
     */
    String product;
    /**
     * 功能
     */
    String action;
    /**
     * 触发事件的源组件
     */
    WebComponent source;
    /**
     * 执行接口的代码
     */
    String script;
    /**
     * 事件类型
     */
    WebTriggerEvent event;
    /**
     * 调用的接口
     */
    ReferenceInterface nativeInterface;
    /**
     * 提供参数的组件引用
     */
    final List<ReferenceWebElement> params = new ArrayList<ReferenceWebElement>();
    /**
     * 执行后结果展示类型
     */
    @Setter
    WebDisplayType displayType;
    /**
     * 执行后结果需要影响的组件引用
     */
    @Setter
    ReferenceWebElement target;

    WebInterface(List<ReferenceWebElement> preExecutes, List<ReferenceWebElement> params) {
        this.preExecutes = preExecutes;
        this.params.addAll(params);
    }

    public static WebInterfaceBuilder builder() {
        return new WebInterfaceBuilder();
    }

    public static class WebInterfaceBuilder {
        /**
         * 执行前显示的界面
         */
        final List<ReferenceWebElement> preExecutes = new ArrayList();
        /**
         * URL地址
         */
        String url = "ajax";
        /**
         * 调用类型
         */
        WebCallType callType = WebCallType.AJAX;
        /**
         * 产品
         */
        String product;
        /**
         * 功能
         */
        String action;
        /**
         * 执行接口的代码
         */
        String script;
        /**
         * 触发事件的源组件
         */
        WebComponent source;
        /**
         * 事件类型
         */
        WebTriggerEvent event;
        /**
         * 调用的接口
         */
        ReferenceInterface nativeInterface;
        /**
         * 提供参数的组件引用
         */
        final List<ReferenceWebElement> params = new ArrayList();
        /**
         * 执行后结果展示类型
         */
        WebDisplayType displayType = WebDisplayType.DEFAULT;
        /**
         * 执行后结果需要影响的组件引用
         */
        ReferenceWebElement target;

        public WebInterfaceBuilder appendPreExecutes(ReferenceWebElement... element) {
            this.preExecutes.addAll(Arrays.asList(element));
            return this;
        }

        public WebInterfaceBuilder url(String url) {
            this.url = url;
            return this;
        }

        public WebInterfaceBuilder callType(WebCallType callType) {
            this.callType = callType;
            return this;
        }

        public WebInterfaceBuilder product(String product) {
            this.product = product;
            return this;
        }

        public WebInterfaceBuilder action(String action) {
            this.action = action;
            return this;
        }

        public WebInterfaceBuilder script(String script) {
            this.script = script;
            return this;
        }

        public WebInterfaceBuilder source(WebComponent source) {
            this.source = source;
            return this;
        }

        public WebInterfaceBuilder event(WebTriggerEvent event) {
            this.event = event;
            return this;
        }

        public WebInterfaceBuilder nativeInterface(ReferenceInterface nativeInterface) {
            this.nativeInterface = nativeInterface;
            return this;
        }

        public WebInterfaceBuilder appendParams(ReferenceWebElement... element) {
            this.params.addAll(Arrays.asList(element));
            return this;
        }

        public WebInterfaceBuilder displayType(WebDisplayType displayType) {
            this.displayType = displayType;
            return this;
        }

        public WebInterfaceBuilder target(ReferenceWebElement target) {
            this.target = target;
            return this;
        }

        public WebInterface build() {
            WebInterface webInterface = new WebInterface(preExecutes, params);
            webInterface.url = url;
            webInterface.callType = callType;
            webInterface.product = product;
            webInterface.action = action;
            webInterface.script = script;
            webInterface.source = source;
            webInterface.event = event;
            webInterface.nativeInterface = nativeInterface;
            webInterface.displayType = displayType;
            webInterface.target = target;
            return webInterface;
        }
    }
}
