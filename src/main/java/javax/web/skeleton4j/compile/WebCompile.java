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
     * @param ctx 上下文
     * @return 是否编译成功
     */
    boolean compile(WebContext ctx);

    /**
     * 获取编译好的代码
     *
     * @param ctx 上下文
     */
    void getCodes(WebContext ctx);
}
