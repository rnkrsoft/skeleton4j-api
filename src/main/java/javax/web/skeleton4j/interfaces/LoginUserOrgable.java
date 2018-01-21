package javax.web.skeleton4j.interfaces;

/**
 * 设置请求能够获取登录用户机构信息
 */
public interface LoginUserOrgable {
    /**
     * 获取登录用户所属机构号
     *
     * @return
     */
    String getLoginOrgId();

    /**
     * 设置登录用户所属机构号
     *
     * @param loginOrgId
     */
    void setLoginOrgId(String loginOrgId);

    /**
     * 获取登录用户所属机构名称
     *
     * @return
     */
    String getLoginOrgName();

    /**
     * 设置登录用户所属机构名称
     *
     * @param loginOrgName
     */
    void setLoginOrgName(String loginOrgName);
}
