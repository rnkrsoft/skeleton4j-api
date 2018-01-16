package javax.web.skeleton4j.annotation;

import javax.web.doc.enums.WebDisplayType;
import java.lang.annotation.*;

/**
 * Created by devops4j on 2017/12/7.
 * 结果展示，展示类型为默认时，根据接口判断
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebResultDisplay {
    /**
     * 展示方式
     * @return 展示方式
     */
    WebDisplayType displayType() default WebDisplayType.DEFAULT;
    /**
     * 展示结果作用的Java字段名,默认无值
     * @return 结果展示的目标字段
     */
    String column() default "";
}
