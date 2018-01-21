package javax.web.data;

import com.google.gson.GsonBuilder;
import lombok.Data;
import org.junit.Test;

/**
 * Created by devops4j on 2017/12/5.
 */
public class OptionNodeTest {
    @Test
    public void test1() {
        Listxx listxx = new Listxx();
        listxx.getNodes().add(Node.builder().text("xxx1x").value("yyyy").build());
        listxx.getNodes().add(Node.builder().text("xxx2x").value("yyyy").selected(true).build());
        listxx.getNodes().add(Node.builder().text("xxx3x").value("yyyy").build());
        listxx.getNodes().add(Node.builder().text("xxx4x").value("yyyy").build());
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(listxx));
    }

    @Data
    static class Listxx extends RootNode {
    }
}