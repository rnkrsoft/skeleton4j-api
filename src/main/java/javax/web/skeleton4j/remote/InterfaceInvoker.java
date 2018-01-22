package javax.web.skeleton4j.remote;

/**
 * Created by devops4j on 2017/12/8.
 * 接口执行器
 */
public interface InterfaceInvoker {
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
