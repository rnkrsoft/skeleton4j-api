package javax.web.data;

import lombok.ToString;

import javax.web.doc.AbstractResponse;
import javax.web.doc.annotation.ApidocElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/12/5.
 * 申明用于选项或者树形结构数据获取时的对象定义
 */
@ToString(callSuper = true)
public class RootNode extends AbstractResponse implements Nodeable {
    @ApidocElement("节点")
    List<Node> nodes;

    @Override
    public List<Node> getNodes() {
        if (this.nodes == null) {
            this.nodes = new ArrayList();
        }
        return this.nodes;
    }

    public Nodeable addNode(Node node) {
        if (this.nodes == null) {
            this.nodes = new ArrayList();
        }
        this.nodes.add(node);
        return this;
    }

}
