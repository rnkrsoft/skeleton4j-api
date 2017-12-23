package javax.web.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by devops4j on 2017/12/5.
 * 提供列表节点接口
 */
public interface ProvideOptionable extends Serializable {
    /**
     * 返回列表节点数据
     *
     * @return
     */
    List<OptionNode> getNodes();

    /**
     * 增加节点
     *
     * @param node 节点
     * @return 节点接口
     */
    ProvideOptionable addNode(OptionNode node);

}
