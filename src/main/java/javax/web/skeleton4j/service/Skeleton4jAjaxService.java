package javax.web.skeleton4j.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by rnkrsoft.com on 2018/6/30.
 */
public interface Skeleton4jAjaxService {
     /**
     * 调用异步接口，所有暴露的接口都要依托于页面，没有页面就无法管理权限
     *
     * @param devMode   是否为开发模式
     * @param product   模块名称 包名(product)
     * @param action    类名缩写(action)
     * @param subAction 交易别名(subAction).通过模块中得接口定义原始类找到真实得接口，接口别名能够转换为接口名字和版本号
     * @param data      JSON 报文
     * @param request   HTTP请求对象
     * @param response  HTTP应答对象
     */
    void ajax(boolean devMode, String product, String action, String subAction, String data, HttpServletRequest request, HttpServletResponse response);

}
