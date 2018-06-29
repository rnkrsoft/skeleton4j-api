package javax.web.skeleton4j.page;


import javax.web.doc.ReferenceInterface;
import javax.web.doc.enums.WebLayout;
import javax.web.skeleton4j.enums.InterfaceCall;
import javax.web.skeleton4j.enums.WebGui;
import javax.web.skeleton4j.enums.WebMode;
import java.util.List;
import java.util.Set;

/**
 * Created by rnkrsoft.com on 2017/10/13
 * 导入带有命名空间的接口元信息.
 */
public interface NamespaceInterfaceMetadata {
    /**
     * 命名空间
     *
     * @return 命名空间
     */
    String getNamespace();

    /**
     * 展示名称
     *
     * @return 展示名称
     */
    String getDisplayName();

    /**
     * 接口列表
     *
     * @return 接口列表
     */
    Set<ReferenceInterface> getInterfaces();

    /**
     * 交互界面类型
     *
     * @return 交互界面类型
     */
    WebGui getGui();

    /**
     * 在接口事件触发前，是否展示确认框
     * @return 是否展示确认框
     */
    boolean isConfirm();

    /**
     * 是否初始化查询数据
     *
     * @return 是否初始化查询数据
     */
    boolean isInitQuery();

    /**
     * 获取导入接口的模式，如果为CREATE，则不进行查询界面条件区域的级联
     *
     * @return 接口的模式
     */
    List<WebMode> getModes();

    /**
     * 布局类型
     *
     * @return 布局类型
     */
    WebLayout getLayout();

    /**
     * 接口调用类型
     *
     * @return 调用类型
     */
    InterfaceCall getCall();
}
