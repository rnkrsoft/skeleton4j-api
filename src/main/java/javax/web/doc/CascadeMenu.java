package javax.web.doc;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2018/8/16.
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class CascadeMenu {
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
    final List<CascadeInterface> cascadeInterfaces = new ArrayList<CascadeInterface>();
    /**
     * 当前菜单需要展示的下一级菜单
     */
    final List<CascadeMenu> cascadeMenus = new ArrayList<CascadeMenu>();

    public CascadeMenu add(CascadeMenu menu){
        cascadeMenus.add(menu);
        return this;
    }

    public CascadeMenu add(CascadeInterface cascadeInterface){
        cascadeInterfaces.add(cascadeInterface);
        return this;
    }
}
