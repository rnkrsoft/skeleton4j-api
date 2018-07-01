package javax.web.skeleton4j.authority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * Created by rnkrsoft.com on 2018/1/7.
 * 权限上下文
 */
public interface AuthorityContext {
    HttpServletRequest getRequest();
    void setRequest(HttpServletRequest request);
    HttpServletResponse getResponse();
    void setResponse(HttpServletResponse response);
    AuthorityContext setApp(String app);
    /**
     * 系统名称
     * @return
     */
    String getApp();

    AuthorityContext setProduct(String product);
    /**
     * 产品名称
     * @return
     */
    String getProduct();
    AuthorityContext setAction(String action);
    /**
     * 操作
     * @return
     */
    String getAction();
    AuthorityContext setSubAction(String subAction);
    /**
     * 子操作
     * @return
     */
    String getSubAction();
    /**
     * 参数
     * @return
     */
    Map<String, Object> getParams();
    String getGroup();
    AuthorityContext setGroup(String group);
    /**
     * 用户号
     * @return
     */
    String getUserId();
    AuthorityContext setUserId(String userId);
    String getUserName();
    AuthorityContext setUserName(String userName);
    String getNickName();
    AuthorityContext setNickName(String nickName);
    String getUserOrgId();
    AuthorityContext setUserOrgId(String userOrgId);
    String getUserOrgName();
    AuthorityContext setUserOrgName(String userOrgName);
    String getUserAvatar();
    AuthorityContext setUserAvatar(String userAvatar);
    /**
     * 绘画令牌
     * @return
     */
    String getToken();
    AuthorityContext setToken(String token);

    /**
     * 是否需要验证令牌
     * @return
     */
    boolean isNeedCheckToken();
    AuthorityContext setNeedCheckToken(boolean needCheckToken);
    /**
     * 是否需要重新登录
     * @return
     */
    boolean isRelogin();

    AuthorityContext setRelogin(boolean relogin);
    AuthorityContext setLoginUrl(String loginUrl);
    String getLoginUrl();
    AuthorityContext setFailure(boolean failure);
    boolean isFailure();

    AuthorityContext setLastActiveTime(Date lastActiveTime);
    Date getLastActiveTime();

    AuthorityContext setLastLoginTime(Date lastLoginTime);
    Date getLastLoginTime();
}
