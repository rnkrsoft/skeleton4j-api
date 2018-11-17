package javax.web.skeleton4j.element.container;

import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/10/20.
 * 内容区域容器接口
 */
public interface WebContentContainer extends WebContainer {
    /**
     * 设置页面提示信息
     *
     * @param hintMessages 提示信息
     */
    void setHintMessages(String... hintMessages);

    /**
     * 获取容器提示信息
     *
     * @return 提示信息
     */
    List<String> getHintMessages();
}
