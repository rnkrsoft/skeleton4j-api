package javax.web.skeleton4j.remote;

import lombok.Getter;

import javax.web.doc.ReferenceInterface;
import javax.web.doc.enums.WebDisplayType;
import javax.web.doc.enums.WebTriggerEvent;
import javax.web.skeleton4j.element.ReferenceWebElement;
import javax.web.skeleton4j.element.component.WebComponent;
import javax.web.skeleton4j.enums.WebCallType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by devops4j on 2017/12/8.
 * 远端接口调用信息类，定义Web前端交互的信息
 */
@Getter
public class WebInterface {
    /**
     * 执行前显示的界面
     */
    List<ReferenceWebElement> preExecutes;
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
    List<ReferenceWebElement> params;
    /**
     * 执行后结果展示类型
     */
    WebDisplayType displayType;
    /**
     * 执行后结果需要影响的组件引用
     */
    ReferenceWebElement target;

    static class WebInterfaceBuilder{
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
        public WebInterfaceBuilder appendPreExecute(ReferenceWebElement element) {
            this.preExecutes.add(element);
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

        public WebInterfaceBuilder appendParam(ReferenceWebElement element) {
            this.params.add(element);
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
    }
}
