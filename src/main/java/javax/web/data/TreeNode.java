package javax.web.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by devops4j on 2017/12/5.
 * 树形节点
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode implements Serializable {
    /**
     * 显示文本
     */
    String text;
    /**
     * 选中值
     */
    String value;
    /**
     * 子节点
     */
    List<TreeNode> nodes;

    public TreeNode addNode(TreeNode node) {
        if (nodes == null) {
            this.nodes = new ArrayList();
        }
        this.nodes.add(node);
        return this;
    }
}
