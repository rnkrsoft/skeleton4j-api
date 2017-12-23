package javax.web.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by devops4j on 2017/12/5.
 * 提供树形节点接口
 */
public interface ProvideTreeable extends Serializable {
    /**
     * 返回树形节点数据
     *
     * @return
     */
    List<TreeNode> getNodes();

    /**
     * 增加树节点
     *
     * @param node 节点
     * @return 树形节点接口
     */
    ProvideTreeable addNode(TreeNode node);
}
