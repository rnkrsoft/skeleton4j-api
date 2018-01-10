package javax.web.doc;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.web.doc.enums.WebLayout;
import javax.web.doc.enums.WebTriggerEvent;
import java.util.*;

@Getter
@ToString
@EqualsAndHashCode
public class CascadeInterface {
    /**
     * CSS样式使用的class选择器,可以定义多个，总是追加系统生成，例如该字段对应Text组件，则生成textComponent
     *
     * @return
     */
    final Set<String> cssClasses = new HashSet();
    /**
     * 接口执行的结果展示为何种方式
     */
    final List<ResultDisplay> resultDisplays = new ArrayList();
    /**
     * 级联字段
     */
    final List<CascadeColumn> cascadeColumns = new ArrayList();
    /**
     * 将该接口如何与级联该接口的字段用什么事件级联
     */
    final Set<WebTriggerEvent> cascadeEvents = new HashSet();
    /**
     * 在接口事件触发前，是否展示确认框
     */
    boolean confirm = false;
    /**
     * 级联接口
     */
    ReferenceInterface ref;
    /**
     * 级联接口的表单布局
     */
    WebLayout layout;
    /**
     * 展示出的名称，通常为按钮
     */
    String displayName;
    private CascadeInterface() {

    }

    public static CascadeInterfaceBuilder builder() {
        return new CascadeInterfaceBuilder();
    }

    public static class CascadeInterfaceBuilder {
        final Set<String> cssClasses = new HashSet();
        final List<ResultDisplay> resultDisplays = new ArrayList();
        final List<CascadeColumn> cascadeColumns = new ArrayList();
        final Set<WebTriggerEvent> cascadeEvents = new HashSet();
        boolean confirm = false;
        ReferenceInterface ref;
        WebLayout layout = WebLayout.INLINE;
        String displayName;
        private CascadeInterfaceBuilder() {
        }
        public CascadeInterfaceBuilder ref(ReferenceInterface ref) {
            this.ref = ref;
            return this;
        }
        public CascadeInterfaceBuilder confirm(boolean confirm) {
            this.confirm = confirm;
            return this;
        }

        public CascadeInterfaceBuilder layout(WebLayout layout) {
            this.layout = layout;
            return this;
        }

        public CascadeInterfaceBuilder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public CascadeInterfaceBuilder cssClass(String... cssClass) {
            this.cssClasses.addAll(Arrays.asList(cssClass));
            return this;
        }

        public CascadeInterfaceBuilder cascadeColumn(CascadeColumn... columns) {
            this.cascadeColumns.addAll(Arrays.asList(columns));
            return this;
        }

        public CascadeInterfaceBuilder resultDisplay(ResultDisplay... resultDisplay) {
            this.resultDisplays.addAll(Arrays.asList(resultDisplay));
            return this;
        }

        public CascadeInterfaceBuilder cascadeEvent(WebTriggerEvent... cascadeEvent) {
            this.cascadeEvents.addAll(Arrays.asList(cascadeEvent));
            return this;
        }


        public CascadeInterface build() {
            CascadeInterface cascadeInterface = new CascadeInterface();
            cascadeInterface.ref = ref;
            cascadeInterface.layout = layout;
            if (displayName == null || displayName.isEmpty()) {
                if (ref.getAlias().equals("update")) {
                    cascadeInterface.displayName = "编辑";
                } else if (ref.getAlias().equals("add")) {
                    cascadeInterface.displayName = "新增";
                } else if (ref.getAlias().equals("view") || ref.getAlias().equals("detail")) {
                    cascadeInterface.displayName = "详情";
                } else {
                    cascadeInterface.displayName = ref.getAlias();
                }

            } else {
                cascadeInterface.displayName = displayName;
            }
            cascadeInterface.confirm = confirm;
            cascadeInterface.cssClasses.addAll(cssClasses);
            cascadeInterface.cascadeColumns.addAll(cascadeColumns);
            cascadeInterface.resultDisplays.addAll(resultDisplays);
            cascadeInterface.cascadeEvents.addAll(cascadeEvents);
            cascadeInterface.ref = ref;
            return cascadeInterface;
        }
    }
}
