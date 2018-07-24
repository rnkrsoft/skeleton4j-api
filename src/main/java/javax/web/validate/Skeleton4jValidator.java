package javax.web.validate;

import javax.web.doc.RspCodeWritable;

/**
 * Created by rnkrsoft.com on 2018/1/4.
 * 校验器
 */
public interface Skeleton4jValidator {
    /**
     * 校验值对象，如果throwException为真，发生校验不通过，则抛出异常
     *
     * @param value          校验对象
     * @param throwException 是否抛出异常
     * @return 校验通过返回真，否则返回假
     */
    boolean validate(Object value, boolean throwException);

    /**
     * 校验值对象，如果校验不通过，则将rspCode和rspDesc填充到Response
     *
     * @param value    校验对象
     * @param response 应答对象
     * @return 校验通过返回真，否则返回假
     */
    boolean validate(Object value, RspCodeWritable response);

    /**
     * 通过校验上下文进行校验值对象
     *
     * @param context 校验上下文，可以设置发生校验不通过，是否抛出异常
     * @return 校验通过返回真，否则返回假
     */
    boolean validate(ValidateContext context);
}
