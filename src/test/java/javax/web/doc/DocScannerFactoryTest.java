package javax.web.doc;

import org.junit.Test;

/**
 * Created by devops4j on 2017/11/23.
 */
public class DocScannerFactoryTest {

    @Test
    public void testNewInstance() throws Exception {
        DocScannerFactory.newInstance("javax.web.doc.DemoDocScanner");
    }
}