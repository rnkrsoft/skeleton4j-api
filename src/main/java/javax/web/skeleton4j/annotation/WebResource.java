package javax.web.skeleton4j.annotation;

import javax.web.skeleton4j.enums.ResourceType;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebResource {
    /**
     * 资源类型
     *
     * @return
     */
    ResourceType type() default ResourceType.AUTO;

    /**
     * 资源路径
     *
     * @return
     */
    String value();
}
