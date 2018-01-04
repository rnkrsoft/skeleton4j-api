package javax.web.validate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by devops4j on 2018/1/4.
 */
public class Skeleton4jValidatorFactoryTest {

    static class DemoBean{
        String name;

        @Override
        public String toString() {
            return "DemoBean{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void testGetInstance() throws Exception {
        Skeleton4jValidator validator = Skeleton4jValidatorFactory.getInstance();
        validator.validate(new DemoBean(), false);
    }
}