package javax.web.skeleton4j.annotation;

import javax.web.skeleton4j.enums.ResourceType;
import java.lang.annotation.*;

/**
 * 用于声明资源文件
 * Created by rnkrsoft.com on 2017/11/30.
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebResource {
    /**
     * 资源类型
     *
     * @return 资源类型
     */
    ResourceType type() default ResourceType.AUTO;

    /**
     * 资源路径
     *
     * @return 资源路径
     */
    String value();
}
