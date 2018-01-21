package javax.web.skeleton4j.remote;


import javax.web.doc.InterfaceInfo;
import javax.web.skeleton4j.enums.InterfaceCall;

/**
 * 接口元信息
 */
public interface WebInterfaceMetadata {
    /**
     * @return
     */
    String getUrl();

    /**
     * @param url
     */
    void setUrl(String url);

    /**
     * @return
     */
    String getProduct();

    void setProduct(String product);

    String getAction();

    void setAction(String action);

    String getSubAction();

    void setSubAction(String subAction);

    InterfaceCall getCall();

    void setCall(InterfaceCall call);

    Class getRequestClass();

    void setRequestClass(Class requestClass);

    Class getResponseClass();

    void setResponseClass(Class responseClass);

    InterfaceInfo getInterfaceInfo();

    void setInterfaceInfo(InterfaceInfo interfaceInfo);
}
