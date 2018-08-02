package javax.web.skeleton4j.enums;

import com.rnkrsoft.interfaces.EnumStringCode;

/**
 * Created by rnkrsoft.com on 2017/10/16.
 * 系统通信编码
 */
public enum InterfaceCode implements EnumStringCode {
    SUCCESS("000","成功"),
    FAIL("999","失败"),
    NO_AUTHORITY_ACCESS_PAGE("001","无权限访问页面"),
    NO_AUTHORITY_EXECUTE_AJAX("002","无权限执行AJAX接口"),
    CALL_INTERFACE_HAPPEN_ERROR("003","调用接口发生错误"),
    NOT_EXISTS_PAGE("004","不存在的页面"),
    NOT_EXISTS_AJAX("005","不存在的AJAX接口"),
    AJAX_DATA_FORMAT_ERROR("006","请求信息格式错误");
    String code;
    String desc;

    InterfaceCode(String code, String desc) {
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