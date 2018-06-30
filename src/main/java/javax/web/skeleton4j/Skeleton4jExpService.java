package javax.web.skeleton4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by rnkrsoft.com on 2018/6/30.
 */
public interface Skeleton4jExpService {
    /**
     * 导出文件
     *
     * @param devMode   是否为开发模式
     * @param product   模块名称 包名(product)
     * @param action    类名缩写(action)
     * @param subAction 交易别名(subAction).通过模块中得接口定义原始类找到真实得接口，接口别名能够转换为接口名字和版本号
     * @param data      JSON 报文
     * @param file      导入文件
     * @param request   HTTP请求对象
     * @param response  HTTP应答对象
     */
    void exp(boolean devMode, String product, String action, String subAction, String data, File file, HttpServletRequest request, HttpServletResponse response);
}
