package javax.web.skeleton4j.session;

/**
 * Created by rnkrsoft.com on 2017/12/8.
 * 设置请求能够获取登录用户机构信息
 */
public interface LoginBranchAble {
    /**
     * 获取登录用户的所在城市ID
     *
     * @return
     */
    String getLoginCityId();

    /**
     * 设置登录用户的所在城市ID
     *
     * @param loginCityId
     */
    void setLoginCityId(String loginCityId);
    /**
     * 获取登录用户的所在城市ID
     *
     * @return
     */
    String getLoginCityName();

    /**
     * 设置登录用户的所在城市ID
     *
     * @param loginCityName
     */
    void setLoginCityName(String loginCityName);
    /**
     * 获取登录用户所属机构号
     *
     * @return
     */
    String getLoginBranchId();

    /**
     * 设置登录用户所属机构号
     *
     * @param loginBranchId
     */
    void setLoginBranchId(String loginBranchId);

    /**
     * 获取登录用户所属机构名称
     *
     * @return
     */
    String getLoginBranchName();

    /**
     * 设置登录用户所属机构名称
     *
     * @param loginBranchName
     */
    void setLoginBranchName(String loginBranchName);
}
