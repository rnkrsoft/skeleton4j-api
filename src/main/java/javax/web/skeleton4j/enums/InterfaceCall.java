package javax.web.skeleton4j.enums;

import com.rnkrsoft.interfaces.EnumStringCode;

/**
 * 接口调用方式
 */
public enum InterfaceCall implements EnumStringCode {
    LOCAL("LOCAL", "本地通过new调用"),
    DUBBO("DUBBO", "DUBBO调用"),
    SPRING_CLOUD("SPRING_CLOUD", "Spring Cloud调用"),
    SPRING_BEAN("SPRING_BEAN", "本地Spring Bean调用"),
    ZEROC_ICE("ZEROC_ICE", "Zeroc ICE 调用"),
    GRPC("GRPC", "gRPC 调用"),
    WEB_SERVICE("WEB_SERVICE", "WEB SERVICE 调用"),
    JBI("JBI", "Java Business Integration 调用"),
    RESTFUL("RESTFUL", "RESTful 调用");
    String code;
    String desc;

    InterfaceCall(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
