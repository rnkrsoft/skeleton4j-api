package javax.web.data;

import com.google.gson.GsonBuilder;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devops4j on 2017/12/5.
 */
public class OptionNodeTest {
    @Test
    public void test1() {
        Listxx listxx = new Listxx();
        listxx.getNodes().add(OptionNode.builder().text("xxx1x").value("yyyy").build());
        listxx.getNodes().add(OptionNode.builder().text("xxx2x").value("yyyy").build());
        listxx.getNodes().add(OptionNode.builder().text("xxx3x").value("yyyy").build());
        listxx.getNodes().add(OptionNode.builder().text("xxx4x").value("yyyy").build());
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(listxx));
    }

    @Data
    static class Listxx implements ProvideOptionable {
        final List<OptionNode> nodes = new ArrayList();

        public ProvideOptionable addNode(OptionNode node) {
            nodes.add(node);
            return this;
        }
    }
}