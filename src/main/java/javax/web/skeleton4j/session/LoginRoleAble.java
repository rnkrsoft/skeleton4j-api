package javax.web.skeleton4j.session;

import java.util.List;

/**
 * Created by rnkrsoft.com on 2018/10/18.
 */
public interface LoginRoleAble {
    /**
     * 获取已登录用户的角色
     * @return
     */
    List<String> getLoginRoles();
}
