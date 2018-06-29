package javax.web.data;

import lombok.ToString;

import javax.web.doc.AbstractResponse;
import javax.web.doc.annotation.ApidocElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/12/5.
 * 申明用于选项或者树形结构数据获取时的对象定义
 * example:
 */
@ToString
public class RootNode extends AbstractResponse implements Nodeable {
    @ApidocElement("节点")
    List<Node> nodes;

    @Override
    public List<Node> getNodes() {
        if (nodes == null) {
            this.nodes = new ArrayList();
        }
        return nodes;
    }

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
