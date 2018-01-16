package javax.web.skeleton4j.pool;

import javax.web.skeleton4j.page.WebPage;
import java.util.List;

/**
 * 页面池
 */
public interface PagePool {
    /**
     * 查询页面类
     * @param product 产品编号
     * @param action 功能编号
     * @param version 版本号
     * @param ifNotExistsReturnNull 不存在是否返回null
     * @return 页面类
     */
    WebPage lookupPage(String product, String action, String version, boolean ifNotExistsReturnNull);

    /**
     * 获取所有页面类
     * @return 页面类
     */
    List<WebPage> pages();

    /**
     * 增加页面类
     * @param webPage 页面类
     * @return 页面池
     */
    PagePool addPage(WebPage webPage);

    /**
     * 清空所有页面
     * @return 页面池
     */
    PagePool clean();

    /**
     * 移除指定的页面
     * @param product 产品编号
     * @param action 功能编号
     * @param version 版本号
     * @return 页面池
     */
    PagePool remove(String product, String action, String version);
}
