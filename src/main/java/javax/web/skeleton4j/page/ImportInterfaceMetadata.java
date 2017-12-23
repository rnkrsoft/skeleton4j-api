package javax.web.skeleton4j.page;


import javax.web.doc.ReferenceInterface;
import javax.web.doc.enums.WebLayout;
import javax.web.skeleton4j.enums.InterfaceCall;
import javax.web.skeleton4j.enums.WebGui;
import javax.web.skeleton4j.enums.WebMode;
import java.util.List;
import java.util.Set;

/**
 * Created by devops4j on 2017/10/13.
 */
public interface ImportInterfaceMetadata {
    /**
     * 命名空间
     * @return
     */
    String getNamespace();

    /**
     * 展示名称
     */
    String getDisplayName();

    /**
     * 接口具有别名
     */
    Set<ReferenceInterface> getInterfaces();

    /**
     * 交互界面
     */
    WebGui getGui();

    /**
     * 是否初始化查询数据
     * @return
     */
    boolean isInitQuery();
    /**
     * 获取导入接口的模式，如果为CREATE，则不进行查询界面条件区域的级联
     * @return
     */
    List<WebMode> getModes();
    /**
     * 布局
     */
    WebLayout getLayout();

    /**
     * 接口调用类型
     */
    InterfaceCall getCall();
}
