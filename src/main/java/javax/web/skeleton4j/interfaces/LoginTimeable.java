package javax.web.skeleton4j.interfaces;

import java.util.Date;

public interface LoginTimeable {
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
