package javax.web.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by devops4j on 2017/12/5.
 * 申明用于列表数据获取时的对象定义
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptionNode implements Serializable {
    /**
     * 显示文本
     */
    String text;
    /**
     * 选中值
     */
    String value;
}
