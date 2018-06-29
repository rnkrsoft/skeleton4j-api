package javax.web.skeleton4j;

import javax.web.skeleton4j.config.Skeleton4jConfig;

/**
 * Created by rnkrsoft.com on 2017/12/16.
 * 配置服务
 */
public interface Skeleton4jConfigService {
    /**
     * 初始化配置服务
     *
     * @return 配置服务
     */
    Skeleton4jConfigService init();

    /**
     * 保存配置信息
     *
     * @param config 配置对象
     * @return 配置服务
     */
    Skeleton4jConfigService save(Skeleton4jConfig config);

    /**
     * 获取配置
     *
     * @return 配置对象
     */
    Skeleton4jConfig load();
}
