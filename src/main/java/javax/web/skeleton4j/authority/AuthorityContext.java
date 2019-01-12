/**
 * RNKRSOFT OPEN SOURCE SOFTWARE LICENSE TERMS ver.1
 * - 氡氪网络科技(重庆)有限公司 开源软件许可条款(版本1)
 * 氡氪网络科技(重庆)有限公司 以下简称Rnkrsoft。
 * 这些许可条款是 Rnkrsoft Corporation（或您所在地的其中一个关联公司）与您之间达成的协议。
 * 请阅读本条款。本条款适用于所有Rnkrsoft的开源软件项目，任何个人或企业禁止以下行为：
 * .禁止基于删除开源代码所附带的本协议内容、
 * .以非Rnkrsoft的名义发布Rnkrsoft开源代码或者基于Rnkrsoft开源源代码的二次开发代码到任何公共仓库,
 * 除非上述条款附带有其他条款。如果确实附带其他条款，则附加条款应适用。
 * <p/>
 * 使用该软件，即表示您接受这些条款。如果您不接受这些条款，请不要使用该软件。
 * 如下所述，安装或使用该软件也表示您同意在验证、自动下载和安装某些更新期间传输某些标准计算机信息以便获取基于 Internet 的服务。
 * <p/>
 * 如果您遵守这些许可条款，将拥有以下权利。
 * 1.阅读源代码和文档
 * 如果您是个人用户，则可以在任何个人设备上阅读、分析、研究Rnkrsoft开源源代码。
 * 如果您经营一家企业，则禁止在任何设备上阅读Rnkrsoft开源源代码,禁止分析、禁止研究Rnkrsoft开源源代码。
 * 2.编译源代码
 * 如果您是个人用户，可以对Rnkrsoft开源源代码以及修改后产生的源代码进行编译操作，编译产生的文件依然受本协议约束。
 * 如果您经营一家企业，不可以对Rnkrsoft开源源代码以及修改后产生的源代码进行编译操作。
 * 3.二次开发拓展功能
 * 如果您是个人用户，可以基于Rnkrsoft开源源代码进行二次开发，修改产生的元代码同样受本协议约束。
 * 如果您经营一家企业，不可以对Rnkrsoft开源源代码进行任何二次开发，但是可以通过联系Rnkrsoft进行商业授予权进行修改源代码。
 * 完整协议。本协议以及开源源代码附加协议，共同构成了Rnkrsoft开源软件的完整协议。
 * <p/>
 * 4.免责声明
 * 该软件按“原样”授予许可。 使用本文档的风险由您自己承担。Rnkrsoft 不提供任何明示的担保、保证或条件。
 * 5.版权声明
 * 本协议所对应的软件为 Rnkrsoft 所拥有的自主知识产权，如果基于本软件进行二次开发，在不改变本软件的任何组成部分的情况下的而二次开发源代码所属版权为贵公司所有。
 */
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
     * @return 获取绑定的HTTP请求
     */
    HttpServletRequest getRequest();

    /**
     * 设置绑定的HTTP请求
     * @param request 设置绑定的HTTP请求
     */
    void setRequest(HttpServletRequest request);

    /**
     * 获取绑定的HTTP应答
     * @return 获取绑定的HTTP应答
     */
    HttpServletResponse getResponse();

    /**
     * 设置绑定的HTTP应答
     * @param response 设置绑定的HTTP应答
     */
    void setResponse(HttpServletResponse response);

    /**
     * 设置系统名称
     * @param app 设置系统名称
     * @return 上下文
     */
    AuthorityContext setApp(String app);

    /**
     * 获取系统名称
     * @return 获取系统名称
     */
    String getApp();

    /**
     * 设置产品名称
     * @param product 设置产品名称
     * @return 上下文
     */
    AuthorityContext setProduct(String product);

    /**
     * 获取产品名称
     * @return 获取产品名称
     */
    String getProduct();

    /**
     * 设置操作
     * @param action 设置操作
     * @return 上下文
     */
    AuthorityContext setAction(String action);

    /**
     * 获取操作
     * @return 获取操作
     */
    String getAction();

    /**
     * 设置子操作
     * @param subAction 设置子操作
     * @return 上下文
     */
    AuthorityContext setSubAction(String subAction);

    /**
     * 获取子操作
     * @return 获取子操作
     */
    String getSubAction();

    /**
     * 参数
     * @return 参数
     */
    Map<String, Object> getParams();

    /**
     * 获取用户号
     * @return 获取用户号
     */
    String getUserId();

    /**
     * 设置用户号
     * @param userId 设置用户号
     * @return 上下文
     */
    AuthorityContext setUserId(String userId);

    /**
     * 获取用户真实姓名
     * @return 获取用户真实姓名
     */
    String getUserName();

    /**
     * 设置用户真实姓名
     * @param userName 设置用户真实姓名
     * @return 上下文
     */
    AuthorityContext setUserName(String userName);

    /**
     * 获取用户昵称
     * @return 获取用户昵称
     */
    String getNickName();

    /**
     * 设置用户昵称
     * @param nickName 设置用户昵称
     * @return 上下文
     */
    AuthorityContext setNickName(String nickName);

    /**
     * 设置用户所在分支机构编号
     * @return 设置用户所在分支机构编号
     */
    String getUserBranchId();

    /**
     * 设置用户所在分支机构编号
     * @param userOrgId 设置用户所在分支机构编号
     * @return 上下文
     */
    AuthorityContext setUserBranchId(String userOrgId);

    /**
     * 获取用户所在分支机构名称
     * @return 获取用户所在分支机构名称
     */
    String getUserBranchName();

    /**
     * 设置用户所在分支机构名称
     * @param userOrgName 设置用户所在分支机构名称
     * @return 上下文
     */
    AuthorityContext setUserBranchName(String userOrgName);

    /**
     * 获取用户所在城市编号
     * @return 获取用户所在城市编号
     */
    String getUserCityId();

    /**
     * 设置用户所在城市编号
     * @param userCityId 获取用户所在城市编号
     * @return 上下文
     */
    AuthorityContext setUserCityId(String userCityId);

    /**
     * 获取用户所在城市名称
     * @return 获取用户所在城市名称
     */
    String getUserCityName();

    /**
     * 设置用户所在城市名称
     * @param userCityName 获取用户所在城市名称
     * @return 上下文
     */
    AuthorityContext setUserCityName(String userCityName);

    /**
     * 获取用户头像
     * @return 获取用户头像
     */
    String getUserAvatar();

    /**
     * 用户头像
     * @param userAvatar 获取用户头像
     * @return 上下文
     */
    AuthorityContext setUserAvatar(String userAvatar);

    /**
     * 用户角色
     * @return 用户角色
     */
    List<String> getUserRoles();

    /**
     * 会话令牌
     * @return 会话令牌
     */
    String getToken();

    /**
     * 会话令牌
     * @param token 会话令牌
     * @return 上下文
     */
    AuthorityContext setToken(String token);

    /**
     * 是否需要验证令牌
     * @return 是否需要验证令牌
     */
    boolean isNeedCheckToken();

    /**
     * 设置是否必须校验TOKEN
     * @param needCheckToken 设置是否必须校验TOKEN
     * @return 上下文
     */
    AuthorityContext setNeedCheckToken(boolean needCheckToken);

    /**
     * 是否需要重新登录
     * @return 是否需要重新登录
     */
    boolean isRelogin();

    /**
     * 设置是否重新登录
     * @param relogin 设置是否重新登录
     * @return 上下文
     */
    AuthorityContext setRelogin(boolean relogin);

    /**
     * 设置重新登录URL
     * @param loginUrl 设置重新登录URL
     * @return 上下文
     */
    AuthorityContext setLoginUrl(String loginUrl);

    /**
     * 设置重新登录URL
     * @return 设置重新登录URL
     */
    String getLoginUrl();

    /**
     * 设置是否失败
     * @param failure 设置是否失败
     * @return 上下文
     */
    AuthorityContext setFailure(boolean failure);

    /**
     * 获取是否失败
     * @return 获取是否失败
     */
    boolean isFailure();

    /**
     * 设置最近一次活动时间
     * @param lastActiveTime 设置最近一次活动时间
     * @return 上下文
     */
    AuthorityContext setLastActiveTime(Date lastActiveTime);

    /**
     * 获取最近一次活动时间
     * @return 获取最近一次活动时间
     */
    Date getLastActiveTime();

    /**
     * 设置最近一次登录时间
     * @param lastLoginTime 获取最近一次活动时间
     * @return 上下文
     */
    AuthorityContext setLastLoginTime(Date lastLoginTime);

    /**
     * 获取最近登录时间
     * @return 获取最近登录时间
     */
    Date getLastLoginTime();
}
