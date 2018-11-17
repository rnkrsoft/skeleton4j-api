package javax.web.skeleton4j.element.component;

/**
 * Created by rnkrsoft.com on 2018/1/17.
 * JSON 编辑器
 */
public interface WebJsonEditorComponent extends WebEditorComponent {

    /**
     * 是否展示语法树
     *
     * @return 是否展示语法树
     */
    boolean isDisplaySyntaxTree();

    /**
     * 设置是否展示语法树
     *
     * @param displaySyntaxTree 是否展示语法树
     */
    void setDisplaySyntaxTree(boolean displaySyntaxTree);
}
