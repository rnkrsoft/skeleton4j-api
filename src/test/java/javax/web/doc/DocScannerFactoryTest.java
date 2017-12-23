package javax.web.doc;

import org.junit.Test;

/**
 * Created by devops4j on 2017/11/23.
 */
public class DocScannerFactoryTest {

    @Test(expected = RuntimeException.class)
    public void testNewInstance() throws Exception {
        DocScannerFactory.newInstance();
    }
}