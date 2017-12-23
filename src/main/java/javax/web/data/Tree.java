package javax.web.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devops4j on 2017/12/5.
 * 申明用于树形结构数据获取时的对象定义
 */
@Data
public class Tree implements ProvideTreeable {
    List<TreeNode> nodes;

    /**
     * 增加节点
     *
     * @param node 节点
     * @return 树
     */
    public ProvideTreeable addNode(TreeNode node) {
        if (nodes == null) {
            this.nodes = new ArrayList();
        }
        this.nodes.add(node);
        return this;
    }
}
