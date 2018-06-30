package javax.web.skeleton4j.authority;

/**
 * Created by rnkrsoft.com on 2018/1/7.
 */
public interface AuthorityService {
    /**
     *校验是否有权限
     * @param context
     * @return
     */
    boolean authority(AuthorityContext context);
}
