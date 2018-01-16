package javax.web.skeleton4j.page;

import javax.web.doc.DocScanner;
import javax.web.skeleton4j.compile.WebCompilable;
import javax.web.skeleton4j.compile.WebCompile;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.element.WebElement;
import javax.web.skeleton4j.element.container.WebContainer;
import javax.web.skeleton4j.menu.WebNode;
import javax.web.skeleton4j.remote.AjaxInterface;
import javax.web.skeleton4j.script.WebScript;
import javax.web.skeleton4j.style.WebStyle;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by devops4j on 2017/10/13.
 * 用于包装HTML页面
 */

public interface WebPage extends WebCompilable, WebCompile {
    /**
     * Web组件注册表
     *
     * @return 注册表对象
     */
    WebComponentRegistry getComponentRegistry();

    DocScanner getDocScanner();
    /**
     * 获取页面上注册的所有Ajax接口
     *
     * @return
     */
    List<AjaxInterface> getAjaxInterfaces();

    /**
     * 获取当前页面所有的web元素引用，通过ID查询引用时，从发起字段查询的组件开始进行同一级查询，如果不存在则进行上一级查询
     *
     * @return
     */
    Map<String, WebElement> getElements();

    /**
     * 包路径
     */
    String getPackagePath();

    /**
     * 标注@WebPlugin注解的类名
     */
    String getWebPageClassName();

    /**
     *
     */
    Class getWebPageClass();

    /**
     * 产品
     */
    String getProduct();

    /**
     * 模块描述
     */
    String getProductDesc();

    /**
     * 功能（页面）
     */
    String getAction();

    /**
     * 页面版本号,如果存在多个版本号，则会生成多个菜单；页面名称的唯一标识为name + ":" + version
     */
    String getVersion();

    /**
     * 页面对应的子菜单
     */
    WebNode getNode();

    /**
     * 作者
     */
    String getAuthor();

    /**
     * 页面显示在浏览器栏的标题
     */
    String getTitle();

    /**
     * 页面中引用的样式,引用来源为插件
     */
    Collection<WebStyle> getStyles();

    /**
     * 页面中引用的脚本,引用来源为插件
     */
    Collection<WebScript> getScripts();

    /**
     * 获取主题下页面需要的脚本，包含插件引用来的和组件引用来的
     *
     * @param theme
     * @return
     */
    Collection<WebScript> getScripts(String theme);

    /**
     * 获取主题下页面需要的样式，包含插件引用来的和组件引用来的
     *
     * @param theme
     * @return
     */
    Collection<WebStyle> getStyles(String theme);

    /**
     * 页面中的容器
     */
    Collection<WebContainer> getContainers();

    /**
     * 导入的接口
     */
    Collection<ImportInterfaceMetadata> getImports();

    /**
     * 用于缓存生成的HTML代码，将直接缓存在直接内存中
     */
    ByteBuffer getCodes();

    WebPage getodes(ByteBuffer buffer);

    String getUrl();

    /**
     * 通过HTML ID或者字段ID查询组件
     *
     * @param id           HTML ID或者字段ID
     * @param elementClass 组件类型
     * @return 组件
     */
    WebElement lookup(String id, Class elementClass);

    /**
     * 通过HTML ID或者字段ID查询组件,查询从source开始平级查起，组件向外
     *
     * @param source       起点元素
     * @param id           HTML ID或者字段ID
     * @param elementClass 组件类型
     * @return 组件
     */
    WebElement lookup(WebElement source, String id, Class elementClass);


    boolean isNotUseAuthority();
//
//    void visit(WebElement element);
//    void visit(WebComponent element);
//    void visit(WebTextComponent element);
//    void visit(WebDateComponent element);
//    void visit(WebGroupComponent element);
//    void visit(WebGroupableComponent element);
//    void visit(WebFormableComponent element);
//    void visit(WebSelectItemComponent element);
//    void visit(WebRadioComponent element);
//    void visit(WebTreeComponent element);
//    void visit(WebTableComponent element);
//    void visit(WebButtonComponent element);
//    void visit(WebHintComponent element);
//    void visit(WebMsgBoxComponent element);
//    void visit(WebDialogBoxComponent element);
//    void visit(WebHeaderContainer element);
//    void visit(WebMenuContainer element);
//    void visit(WebFormContainer element);
}
