package javax.web.skeleton4j.annotation;

import javax.web.skeleton4j.enums.RuleMethod;
import java.lang.annotation.*;

/**
 * Created by rnkrsoft.com on 2018/12/18.
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebCascadeRule {
    /**
     * 规则表达式
     * @return 表达式
     */
    String value();

    /**
     * 规则类型接受方法
     * @return
     */
    RuleMethod method() default RuleMethod.ACCEPT;
}
