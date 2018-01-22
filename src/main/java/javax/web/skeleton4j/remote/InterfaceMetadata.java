package javax.web.skeleton4j.remote;


import javax.web.doc.InterfaceInfo;
import javax.web.skeleton4j.enums.InterfaceCall;

/**
 * Created by devops4j on 2017/12/8.
 * 接口元信息
 * 在容器中描述的后端接口
 */
public interface InterfaceMetadata {
    /**
     * 全局唯一的接口名，一般使用product/action/subAction作为唯一标识
     *
     * @return 接口名
     */
    String getName();

    /**
     * 产品代码
     *
     * @return 产品代码
     */
    String getProduct();

    /**
     * 功能代码
     *
     * @return 功能代码
     */
    String getAction();

    /**
     * 操作代码，即接口的别名，包含了version信息在其中
     *
     * @return 操作代码
     */
    String getSubAction();

    /**
     * 执行该后端接口的方式，具体是本地Bean还是Dubbo
     *
     * @return 接口执行方式
     */
    InterfaceCall getCall();

    /**
     * 接口调用请求类对象
     *
     * @return 类对象
     */
    Class getRequestClass();

    /**
     * 接口调用应答类对象
     *
     * @return 类对象
     */
    Class getResponseClass();

    /**
     * 接口的信息描述
     * @return 接口信息对象
     */
    InterfaceInfo getInterfaceInfo();

}
