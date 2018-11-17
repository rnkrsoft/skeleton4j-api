package javax.web.skeleton4j.authority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by rnkrsoft.com on 2017/10/17.
 * 权限提取器
 */
public interface AuthorityExtractor {
    /**
     * 从HTTP COOKIE提取权限上下文
     *
     * @param request
     * @param response
     * @return
     */
    AuthorityContext extract(HttpServletRequest request, HttpServletResponse response);
}