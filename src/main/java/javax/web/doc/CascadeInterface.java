/**
 * RNKRSOFT OPEN SOURCE SOFTWARE LICENSE TERMS ver.1
 * - 氡氪网络科技(重庆)有限公司 开源软件许可条款(版本1)
 * 氡氪网络科技(重庆)有限公司 以下简称Rnkrsoft。
 * 这些许可条款是 Rnkrsoft Corporation（或您所在地的其中一个关联公司）与您之间达成的协议。
 * 请阅读本条款。本条款适用于所有Rnkrsoft的开源软件项目，任何个人或企业禁止以下行为：
 * .禁止基于删除开源代码所附带的本协议内容、
 * .以非Rnkrsoft的名义发布Rnkrsoft开源代码或者基于Rnkrsoft开源源代码的二次开发代码到任何公共仓库,
 * 除非上述条款附带有其他条款。如果确实附带其他条款，则附加条款应适用。
 * <p/>
 * 使用该软件，即表示您接受这些条款。如果您不接受这些条款，请不要使用该软件。
 * 如下所述，安装或使用该软件也表示您同意在验证、自动下载和安装某些更新期间传输某些标准计算机信息以便获取基于 Internet 的服务。
 * <p/>
 * 如果您遵守这些许可条款，将拥有以下权利。
 * 1.阅读源代码和文档
 * 如果您是个人用户，则可以在任何个人设备上阅读、分析、研究Rnkrsoft开源源代码。
 * 如果您经营一家企业，则禁止在任何设备上阅读Rnkrsoft开源源代码,禁止分析、禁止研究Rnkrsoft开源源代码。
 * 2.编译源代码
 * 如果您是个人用户，可以对Rnkrsoft开源源代码以及修改后产生的源代码进行编译操作，编译产生的文件依然受本协议约束。
 * 如果您经营一家企业，不可以对Rnkrsoft开源源代码以及修改后产生的源代码进行编译操作。
 * 3.二次开发拓展功能
 * 如果您是个人用户，可以基于Rnkrsoft开源源代码进行二次开发，修改产生的元代码同样受本协议约束。
 * 如果您经营一家企业，不可以对Rnkrsoft开源源代码进行任何二次开发，但是可以通过联系Rnkrsoft进行商业授予权进行修改源代码。
 * 完整协议。本协议以及开源源代码附加协议，共同构成了Rnkrsoft开源软件的完整协议。
 * <p/>
 * 4.免责声明
 * 该软件按“原样”授予许可。 使用本文档的风险由您自己承担。Rnkrsoft 不提供任何明示的担保、保证或条件。
 * 5.版权声明
 * 本协议所对应的软件为 Rnkrsoft 所拥有的自主知识产权，如果基于本软件进行二次开发，在不改变本软件的任何组成部分的情况下的而二次开发源代码所属版权为贵公司所有。
 */
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
     * 按钮图标
     */
    String icon;
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
     * 在接口出现确认框时，提示的确认信息
     */
    String confirmMessage = "";
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
        String icon;
        final Set<String> cssClasses = new HashSet();
        final List<ResultDisplay> resultDisplays = new ArrayList();
        final List<CascadeColumn> cascadeColumns = new ArrayList();
        final Set<WebTriggerEvent> cascadeEvents = new HashSet();
        boolean confirm = false;
        String confirmMessage = "";
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

        public CascadeInterfaceBuilder confirmMessage(String confirmMessage) {
            this.confirmMessage = confirmMessage;
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

        public CascadeInterfaceBuilder icon(String icon) {
            this.icon = icon;
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
                if (ref.getAlias().equals("toUpdate")) {
                    cascadeInterface.displayName = "编辑";
                } else if (ref.getAlias().equals("update")) {
                    cascadeInterface.displayName = "保存";
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
            cascadeInterface.confirmMessage = confirmMessage;
            cascadeInterface.icon = icon;
            cascadeInterface.cssClasses.addAll(cssClasses);
            cascadeInterface.cascadeColumns.addAll(cascadeColumns);
            cascadeInterface.resultDisplays.addAll(resultDisplays);
            cascadeInterface.cascadeEvents.addAll(cascadeEvents);
            cascadeInterface.ref = ref;
            return cascadeInterface;
        }
    }
}
