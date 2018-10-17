package javax.web.skeleton4j.session;

import java.util.Date;

/**
 * Created by rnkrsoft.com on 2017/12/8.
 * 设置请求能够获取登录时间有关信息
 */
public interface LoginTimeAble {
    /**
     * 获取上次用户活动时间
     *
     * @return
     */
    Date getLastActiveTime();

    /**
     * 设置上次用户活动时间
     *
     * @param lastActiveTime
     */
    void setLastActiveTime(Date lastActiveTime);

    /**
     * 获取上次用户登录时间
     *
     * @return
     */
    Date getLastLoginTime();

    /**
     * 设置上次用户登录时间
     *
     * @param lastLoginTime
     */
    void setLastLoginTime(Date lastLoginTime);
}
