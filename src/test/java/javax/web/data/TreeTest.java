package javax.web.data;

import com.google.gson.GsonBuilder;
import org.junit.Test;

/**
 * Created by devops4j on 2017/12/5.
 */
public class TreeTest {

    @Test
    public void testGetNodes() throws Exception {
        Tree tree = new Tree();
        TreeNode node1 = TreeNode.builder().text("节点1").value("node1").build();
        TreeNode node21 = TreeNode.builder().text("节点2.1").value("node21").build();
        TreeNode node22 = TreeNode.builder().text("节点2.2").value("node22").build();
        TreeNode node31 = TreeNode.builder().text("节点3.1").value("node31").build();
        TreeNode node32 = TreeNode.builder().text("节点3.2").value("node32").build();
        node21.addNode(node31).addNode(node32);
        TreeNode node43 = TreeNode.builder().text("节点4.3").value("node43").build();
        node31.addNode(node43);
        TreeNode node2 = TreeNode.builder().text("节点2").value("node2").build();
        node1.addNode(node21).addNode(node22);
        tree.addNode(node1).addNode(node2);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(tree));
    }
}