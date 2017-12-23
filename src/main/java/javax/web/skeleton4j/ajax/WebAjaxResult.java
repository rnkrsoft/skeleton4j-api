package javax.web.skeleton4j.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by devops4j on 2017/12/7.
 * Ajax调用结果封装接口
 */
public interface WebAjaxResult<T> {
    /**
     * 结果码
     * @return
     */
    String getCode();

    /**
     * 结果描述
     * @return
     */
    String getDesc();

    /**
     * 结果对象
     * @return 对象
     */
    T getData();

    /**
     * 将当前对象转换为JSON
     * @return JSON
     */
    String toJson();

    /**
     * 将当前对象转换为JSON，写入Servlet中
     * @param request 请求
     * @param response 应答
     */
    void write(HttpServletRequest request, HttpServletResponse response);
}
