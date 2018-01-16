package javax.web.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by devops4j on 2017/12/5.
 * 提供树形节点接口
 */
public interface Nodeable extends Serializable {
    /**
     * 返回树形节点数据
     *
     * @return 节点数据
     */
    List<Node> getNodes();

    /**
     * 增加树节点
     *
     * @param node 节点
     * @return 树形节点接口
     */
    Nodeable addNode(Node node);
}
