package javax.web.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devops4j on 2017/12/5.
 * 申明用于树形结构数据获取时的对象定义
 */
@Data
public class RootNode implements Nodeable {
    List<Node> nodes;

    /**
     * 增加节点
     *
     * @param node 节点
     * @return 树
     */
    public Nodeable addNode(Node node) {
        if (nodes == null) {
            this.nodes = new ArrayList();
        }
        this.nodes.add(node);
        return this;
    }
}
