package javax.web.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2017/12/5.
 * 树形节点
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Node implements Serializable {
    /**
     * 显示文本
     */
    @Getter
    String text;
    /**
     * 选中值
     */
    @Getter
    String value;
    /**
     * 是否选中
     */
    @Getter
    boolean selected;
    /**
     * 子节点
     */
    List<Node> nodes;

    public List<Node> getNodes() {
        if (nodes == null) {
            this.nodes = new ArrayList();
        }
        return nodes;
    }

    public Node addNode(Node node) {
        if (nodes == null) {
            this.nodes = new ArrayList();
        }
        this.nodes.add(node);
        return this;
    }

    @Override
    public String toString() {
        return value + ":" + text + "(" + (selected ? "selected" : "") + ")";
    }
}
