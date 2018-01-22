package javax.web.skeleton4j.remote;

import javax.web.skeleton4j.config.Skeleton4jConfig;
import javax.web.skeleton4j.enums.InterfaceCall;

/**
 * Created by devops4j on 2017/12/8.
 * 接口执行器
 */
public interface InterfaceInvoker {
    void setConfig(Skeleton4jConfig config);
    /**
     * 执行器能够处理的请求类型
     * @return 类型
     */
    InterfaceCall getType();
    /**
     * 执行接口
     *
     * @param metadata 接口元信息
     * @param request  请求对象
     * @param <T>      应答对象
     * @return 应答对象
     */
    <T> T invoke(InterfaceMetadata metadata, Object request);

}
