package javax.web.validate.annotation;

import java.lang.annotation.*;

/**
 * Created by rnkrsoft.com on 2018/10/28.
 * 校验结果定义，用于对默认校验不通过结果的覆盖定义
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateResult {
    /**
     * 校验对象为null时返回该错误
     * @return 如果没用@ValidateMessage("")定义错误信息，则使用ValidateCause中定义的错误信息
     */
    ValidateMessage isNull() default @ValidateMessage();
    /**
     * 校验字段为必输，但是却为null或者空字符串时返回该错误
     * @return 如果没用@ValidateMessage("")定义错误信息，则使用ValidateCause中定义的错误信息
     */
    ValidateMessage isRequired() default @ValidateMessage();
    /**
     * 校验字段长度小于最小长度时返回该错误
     * @return 如果没用@ValidateMessage("")定义错误信息，则使用ValidateCause中定义的错误信息
     */
    ValidateMessage notMatchMinLen() default @ValidateMessage();
    /**
     * 校验字段长度大于最大长度时返回该错误
     * @return 如果没用@ValidateMessage("")定义错误信息，则使用ValidateCause中定义的错误信息
     */
    ValidateMessage notMatchMaxLen() default @ValidateMessage();
    /**
     * 校验字段长度不为固定长度时返回该错误
     * @return 如果没用@ValidateMessage("")定义错误信息，则使用ValidateCause中定义的错误信息
     */
    ValidateMessage notMatchFixedLen() default @ValidateMessage();
    /**
     * 校验字段不能匹配枚举时返回该错误
     * @return 如果没用@ValidateMessage("")定义错误信息，则使用ValidateCause中定义的错误信息
     */
    ValidateMessage notMatchEnum() default @ValidateMessage();
    /**
     * 校验字段不能匹配表达式时返回该错误
     * @return 如果没用@ValidateMessage("")定义错误信息，则使用ValidateCause中定义的错误信息
     */
    ValidateMessage notMatchPattern() default @ValidateMessage();
    /**
     * 校验字段实现枚举接口时返回该错误
     * @return 如果没用@ValidateMessage("")定义错误信息，则使用ValidateCause中定义的错误信息
     */
    ValidateMessage notImplementEnumInterface() default @ValidateMessage();
    /**
     * 校验字段为不支持的数据类型时返回该错误
     * @return 如果没用@ValidateMessage("")定义错误信息，则使用ValidateCause中定义的错误信息
     */
    ValidateMessage notSupportDataType() default @ValidateMessage();
    /**
     * 校验字段指定的枚举类未实现枚举工厂方法时返回该错误
     * @return 如果没用@ValidateMessage("")定义错误信息，则使用ValidateCause中定义的错误信息
     */
    ValidateMessage notDefineEnumFactoryMethod() default @ValidateMessage();
}
