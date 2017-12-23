package javax.web.skeleton4j.compile;


import javax.web.skeleton4j.render.WebContext;

/**
 * Created by devops4j on 2017/10/18.
 * 编译接口
 */
public interface WebCompile {
    /**
     * 编译
     *
     * @return 编译失败返回假
     */
    boolean compile(WebContext ctx);

    /**
     * 获取编译好的代码
     *
     * @return
     */
    void getCodes(WebContext ctx);
}
