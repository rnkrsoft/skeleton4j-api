package javax.web.skeleton4j.menu;

import org.junit.Test;

/**
 * Created by rnkrsoft.com on 2017/12/15.
 */
public class WebMenuTest {

    @Test
    public void testAddNode() throws Exception {
        WebMenu menu0 = WebMenu.menuBuilder().name("menu0").title("menu0").build();
        WebMenu menu1 = WebMenu.menuBuilder().name("menu1").title("menu1").build();
        WebMenu menu2 = WebMenu.menuBuilder().name("menu2").title("menu2").build();
        WebMenu menu3 = WebMenu.menuBuilder().name("menu3").title("menu3").build();
        WebMenu menu4 = WebMenu.menuBuilder().name("menu4").title("menu4").build();
        menu0.addNode(menu1);
        menu1.addNode(menu2);
        menu1.addNode(menu3);
        menu0.addNode(menu4);
        System.out.println(menu0);
    }
}