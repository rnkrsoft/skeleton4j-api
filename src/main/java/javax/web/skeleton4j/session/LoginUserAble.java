package javax.web.skeleton4j.session;

import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/12/8.
 * 设置请求能够获取登录用户信息
 */
public interface LoginUserAble {
    /**
     * 获取登录用户号
     *
     * @return
     */
    String getLoginUserId();

    /**
     * 设置登陆用户号
     *
     * @param loginUserId
     */
    void setLoginUserId(String loginUserId);

    /**
     * 获取登录用户姓名
     *
     * @return
     */
    String getLoginUserName();

    /**
     * 设置登录用户姓名
     *
     * @param loginUserName
     */
    void setLoginUserName(String loginUserName);

}
