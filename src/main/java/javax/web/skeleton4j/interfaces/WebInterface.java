package javax.web.skeleton4j.interfaces;

import lombok.Getter;

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
    final List<ReferenceWebElement> params;
    /**
     * 执行后结果展示类型
     */
    WebDisplayType displayType;
    /**
     * 执行后结果需要影响的组件引用
     */
    ReferenceWebElement target;

    WebInterface(List<ReferenceWebElement> preExecutes, List<ReferenceWebElement> params) {
        this.preExecutes = preExecutes;
        this.params = params;
    }

    public static WebInterfaceBuilder builder(){
        return new WebInterfaceBuilder();
    }
    public static class WebInterfaceBuilder{
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
        WebDisplayType displayType = WebDisplayType.MSG_BOX;
        /**
         * 执行后结果需要影响的组件引用
         */
        ReferenceWebElement target;
        public WebInterfaceBuilder appendPreExecutes(ReferenceWebElement ... element) {
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

        public WebInterfaceBuilder appendParams(ReferenceWebElement ... element) {
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

        public WebInterface build(){
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
