package javax.web.skeleton4j.element.component;

/**
 * Created by devops4j on 2018/1/17.
 */
public interface WebEditorComponent extends WebFormableComponent, WebGroupableComponent{
    /**
     * 编辑器高度
     * @return 编辑器高度
     */
    int getEditorHeight();

    /**
     * 编辑器高度
     * @param editorHeight 编辑器高度
     */
    void setEditorHeight(int editorHeight);

    /**
     * 编辑器宽度
     * @return 编辑器宽度
     */
    int getEditorWidth();

    /**
     * 设置编辑器宽度
     * @param editorWidth 编辑器宽度
     */
    void setEditorWidth(int editorWidth);
}
