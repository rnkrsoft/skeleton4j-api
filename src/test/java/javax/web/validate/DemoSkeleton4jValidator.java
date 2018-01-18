package javax.web.validate;

import javax.web.doc.RspCodeWritable;

/**
 * Created by devops4j on 2018/1/4.
 */
public class DemoSkeleton4jValidator implements Skeleton4jValidator{
    @Override
    public boolean validate(Object value, boolean throwException) {
        System.out.println(value);
        return false;
    }

    @Override
    public boolean validate(Object value, RspCodeWritable response) {
        return false;
    }

    @Override
    public boolean validate(ValidateContext context) {
        return false;
    }
}
