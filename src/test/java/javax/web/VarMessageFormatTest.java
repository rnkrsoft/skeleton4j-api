package javax.web;

import com.rnkrsoft.message.VariableMessageFormatter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/28.
 */
public class VarMessageFormatTest {
    @Test
    public void test1() {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("failureObjectValue", "{dsdsadsadasdsadsad}");
        args.put("fieldName", "name");
        args.put("failFieldName", "姓名");
        args.put("failureValue", "test");
        String msg = VariableMessageFormatter.format("在${failureObjectValue}中 ${fieldName}(${failFieldName})${failFieldName}当前为${failureValue},不支持，应该修改为'xssd'", args);
        System.out.println(msg);
    }
}
