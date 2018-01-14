package javax.web.skeleton4j.pool;

import javax.web.skeleton4j.page.WebPage;
import java.util.List;

/**
 * 
 */
public interface PagePool {

    PagePool addPage(WebPage webPage);

    WebPage lookupPage(String product, String action, String version, boolean ifNotExistsReturnNull);

    List<WebPage> listPages();

    PagePool clean();

    PagePool remove(String product, String action, String version);
}
