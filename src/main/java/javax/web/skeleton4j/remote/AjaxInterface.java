package javax.web.skeleton4j.remote;

import lombok.Builder;
import lombok.Getter;

import javax.web.doc.ReferenceInterface;
import javax.web.doc.enums.WebDisplayType;
import javax.web.doc.enums.WebTriggerEvent;
import javax.web.skeleton4j.element.ReferenceWebElement;
import javax.web.skeleton4j.element.component.WebComponent;
import javax.web.skeleton4j.element.component.WebConfirmBoxComponent;
import java.util.List;

/**
 * Created by devops4j on 2017/12/8.
 */
@Getter
@Builder
public class AjaxInterface {
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
     * 执行前显示的界面
     */
    List<ReferenceWebElement> preExecutes;
    /**
     * URL地址
     */
    String url;
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
}
