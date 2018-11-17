package javax.web.skeleton4j.element.component;

/**
 * Created by rnkrsoft.com on 2018/1/17.
 */
public interface WebEditorComponent extends WebFormableComponent, WebGroupableComponent {
    /**
     * 编辑器高度
     *
     * @return 编辑器高度
     */
    int getHeight();

    /**
     * 编辑器高度
     *
     * @param editorHeight 编辑器高度
     */
    void setHeight(int editorHeight);

    /**
     * 编辑器宽度
     *
     * @return 编辑器宽度
     */
    int getWidth();

    /**
     * 设置编辑器宽度
     *
     * @param editorWidth 编辑器宽度
     */
    void setWidth(int editorWidth);
}
