package javax.web.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by devops4j on 2017/12/5.
 * 提供树形节点接口
 */
public interface Nodeable extends Serializable {
    /**
     * 设置节点值
     * @param selected 节点值
     */
    void setSelected(Node selected);

    /**
     * 获取选中的节点值
     * @return 节点值
     */
    Node getSelected();
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
