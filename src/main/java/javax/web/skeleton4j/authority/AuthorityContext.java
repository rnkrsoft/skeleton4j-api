package javax.web.skeleton4j.authority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by rnkrsoft.com on 2018/1/7.
 * 权限上下文
 */
public interface AuthorityContext {
    /**
     * 获取绑定的HTTP请求
     * @return
     */
    HttpServletRequest getRequest();

    /**
     * 设置绑定的HTTP请求
     * @param request
     */
    void setRequest(HttpServletRequest request);

    /**
     * 获取绑定的HTTP应答
     * @return
     */
    HttpServletResponse getResponse();

    /**
     * 设置绑定的HTTP应答
     * @param response
     */
    void setResponse(HttpServletResponse response);

    /**
     * 设置系统名称
     * @param app
     * @return
     */
    AuthorityContext setApp(String app);
    /**
     * 获取系统名称
     * @return
     */
    String getApp();

    /**
     * 设置产品名称
     * @param product
     * @return
     */
    AuthorityContext setProduct(String product);
    /**
     * 获取产品名称
     * @return
     */
    String getProduct();

    /**
     * 设置操作
     * @param action
     * @return
     */
    AuthorityContext setAction(String action);
    /**
     * 获取操作
     * @return
     */
    String getAction();

    /**
     * 设置子操作
     * @param subAction
     * @return
     */
    AuthorityContext setSubAction(String subAction);
    /**
     * 获取子操作
     * @return
     */
    String getSubAction();
    /**
     * 参数
     * @return
     */
    Map<String, Object> getParams();
    /**
     * 获取用户号
     * @return
     */
    String getUserId();

    /**
     * 设置用户号
     * @param userId
     * @return
     */
    AuthorityContext setUserId(String userId);

    /**
     * 获取用户真实姓名
     * @return
     */
    String getUserName();

    /**
     * 设置用户真实姓名
     * @param userName
     * @return
     */
    AuthorityContext setUserName(String userName);

    /**
     * 获取用户昵称
     * @return
     */
    String getNickName();

    /**
     * 设置用户昵称
     * @param nickName
     * @return
     */
    AuthorityContext setNickName(String nickName);

    /**
     * 设置用户所在分支机构编号
     * @return
     */
    String getUserBranchId();

    /**
     * 设置用户所在分支机构编号
     * @param userOrgId
     * @return
     */
    AuthorityContext setUserBranchId(String userOrgId);

    /**
     * 获取用户所在分支机构名称
     * @return
     */
    String getUserBranchName();

    /**
     * 设置用户所在分支机构名称
     * @param userOrgName
     * @return
     */
    AuthorityContext setUserBranchName(String userOrgName);

    /**
     * 获取用户所在城市编号
     * @return
     */
    String getUserCityId();

    /**
     * 设置用户所在城市编号
     * @param userCityId
     * @return
     */
    AuthorityContext setUserCityId(String userCityId);

    /**
     * 获取用户所在城市名称
     * @return
     */
    String getUserCityName();

    /**
     * 设置用户所在城市名称
     * @param userCityName
     * @return
     */
    AuthorityContext setUserCityName(String userCityName);

    /**
     * 获取用户头像
     * @return
     */
    String getUserAvatar();
    /**
     * 用户头像
     * @param userAvatar
     * @return
     */
    AuthorityContext setUserAvatar(String userAvatar);

    /**
     * 用户角色
     * @return
     */
    List<String> getUserRoles();
    /**
     * 会话令牌
     * @return
     */
    String getToken();

    /**
     * 会话令牌
     * @param token
     * @return
     */
    AuthorityContext setToken(String token);

    /**
     * 是否需要验证令牌
     * @return
     */
    boolean isNeedCheckToken();

    /**
     * 设置是否必须校验TOKEN
     * @param needCheckToken
     * @return
     */
    AuthorityContext setNeedCheckToken(boolean needCheckToken);
    /**
     * 是否需要重新登录
     * @return
     */
    boolean isRelogin();

    /**
     * 设置是否重新登录
     * @param relogin
     * @return
     */
    AuthorityContext setRelogin(boolean relogin);

    /**
     * 设置重新登录URL
     * @param loginUrl
     * @return
     */
    AuthorityContext setLoginUrl(String loginUrl);

    /**
     * 设置重新登录URL
     * @return
     */
    String getLoginUrl();

    /**
     * 设置是否失败
     * @param failure
     * @return
     */
    AuthorityContext setFailure(boolean failure);

    /**
     * 获取是否失败
     * @return
     */
    boolean isFailure();

    /**
     * 设置最近一次活动时间
     * @param lastActiveTime
     * @return
     */
    AuthorityContext setLastActiveTime(Date lastActiveTime);

    /**
     * 获取最近一次活动时间
     * @return
     */
    Date getLastActiveTime();

    /**
     * 设置最近一次登录时间
     * @param lastLoginTime
     * @return
     */
    AuthorityContext setLastLoginTime(Date lastLoginTime);

    /**
     * 获取最近登录时间
     * @return
     */
    Date getLastLoginTime();
}
