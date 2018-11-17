package javax.web.validate.annotation;

import java.lang.annotation.*;

/**
 * Created by rnkrsoft.com on 2018/10/28.
 * 校验结果不通过时返回的失败信息定义
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateMessage {
    /**
     * 支持变量信息文本输出，用${变量名}进行使用
     * <ol>
     *     <li>failFieldName:失败字段变量名称</li>
     *     <li>failFieldChsName:失败字段中文名称</li>
     *     <li>failValue:失败字段值</li>
     *     <li>failObjectValue:失败字段所在对象的值</li>
     *     <li>failObjectJson:失败字段所在对象的JSON值</li>
     *     <li>failObjectType:失败字段所在对象类型</li>
     *     <li>minLen:当前字段的最小长度</li>
     *     <li>maxLen:当前字段的最大长度</li>
     *     <li>fixedLen:当前字段的固定长度</li>
     *     <li>failPattern:失败时不匹配的表达式</li>
     *     <li>patterns:当前字段的表达式数组</li>
     *     <li>patternType:当前字段的表达式类型</li>
     * </ol>
     * <code>
     *     在${failureObjectValue}中 ${failFieldName}(${failFieldChsName})当前为${failureValue},不支持，应该修改为'xssd'
     * </code>
     * @return
     */
    String value() default "";
}
