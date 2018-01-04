package javax.web.validate;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by devops4j on 2018/1/4.
 */
@Data
public class ValidateContext {
    /**
     * 校验值
     */
    Object value;
    /**
     * 注册的发生异常的原因
     */
    final Map<ValidateCause, String> causes = new HashMap();
    /**
     * 校验发生错误的代码
     */
    String code;
    /**
     * 校验发生错误的描述
     */
    String desc;
    /**
     * 是否抛出异常
     */
    boolean throwException;

    public ValidateContext() {
        register(ValidateCause.IS_NULL_DATA, ValidateCause.IS_NULL_DATA.getDesc());
        register(ValidateCause.IS_REQUIRED, ValidateCause.IS_REQUIRED.getDesc());
        register(ValidateCause.NOT_MATCH_MIN_LEN, ValidateCause.NOT_MATCH_MIN_LEN.getDesc());
        register(ValidateCause.NOT_MATCH_MAX_LEN, ValidateCause.NOT_MATCH_MAX_LEN.getDesc());
        register(ValidateCause.NOT_MATCH_FIXED_LEN, ValidateCause.NOT_MATCH_FIXED_LEN.getDesc());
        register(ValidateCause.NOT_MATCH_PATTERN, ValidateCause.NOT_MATCH_PATTERN.getDesc());
        register(ValidateCause.NOT_MATCH_ENUM, ValidateCause.NOT_MATCH_ENUM.getDesc());
        register(ValidateCause.NOT_IMPLEMENT_ENUM_INTERFACE, ValidateCause.NOT_IMPLEMENT_ENUM_INTERFACE.getDesc());
    }

    public void register(ValidateCause cause, String desc){
        causes.put(cause, desc);
    }

    public static ValidateContextBuilder builder(){
        return new ValidateContextBuilder();
    }

    public static class ValidateContextBuilder{
        Object value;
        boolean throwException;

        public ValidateContextBuilder value(Object value) {
            this.value = value;
            return this;
        }

        public ValidateContextBuilder throwException(boolean throwException) {
            this.throwException = throwException;
            return this;
        }

        public ValidateContext build(){
            ValidateContext context = new ValidateContext();
            context.value = value;
            context.throwException = throwException;
            return context;
        }
    }
}
