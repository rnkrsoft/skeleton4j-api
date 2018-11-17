package javax.web.skeleton4j.session;

/**
 * Created by rnkrsoft.com on 2018/10/18.
 * 设置已登录用户的头像
 */
public interface LoginAvatarAble {
    /**
     * 获取已登录用户的头像
     * @return
     */
    String getLoginAvatar();

    /**
     * 设置已登录用户的头像
     * @param loginAvatar
     */
    void setLoginAvatar(String loginAvatar);
    /**
     * 获取已登录昵称
     * @return
     */
    String getLoginNick();

    /**
     * 设置已登录昵称
     * @param loginNick
     */
    void setLoginNick(String loginNick);
}
