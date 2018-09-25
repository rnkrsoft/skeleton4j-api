package javax.web.doc;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by rnkrsoft.com on 2018/8/16.
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class CascadeMenu {
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
     * 菜单显示名称
     */
    String displayName;
    /**
     * 菜单级数
     */
    int level;
    /**
     * 当前菜单需要展示的按钮
     */
    final List<CascadeInterface> cascadeInterfaces = new ArrayList();
    /**
     * 当前菜单需要展示的下一级菜单
     */
    final List<CascadeMenu> cascadeMenus = new ArrayList();

    public CascadeMenu add(CascadeMenu menu){
        cascadeMenus.add(menu);
        return this;
    }

    public CascadeMenu add(CascadeInterface cascadeInterface){
        cascadeInterfaces.add(cascadeInterface);
        return this;
    }
}
