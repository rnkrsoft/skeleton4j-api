package javax.web.skeleton4j.menu;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.web.skeleton4j.module.WebModule;

/**
 * Created by rnkrsoft.com on 2017/10/9.
 */
@Data
public class WebNode {
    @Override
    public String toString() {
        return "WebNode{" +
                "no=" + no +
                ", name='" + getName() + '\'' +
                ", title='" + title + '\'' +
                ", parent='" + parent + '\'' +
                '}';
    }

    protected int no = 0;
    /**
     * 图标 字体或者图片路径classpath*:com.rnkrsoft.xxx.png
     */
    protected String icon;
    /**
     * 菜单英文名称
     */
    protected String name;
    /**
     * 菜单展示名称
     */
    protected String title;
    /**
     * 状态
     */
    protected int status;
    /**
     * 是否使用权限
     */
    protected boolean useAuthority;
    /**
     * 是否隐藏
     */
    protected boolean hidden;
    /**
     * 是否展开
     */
    protected boolean expand;
    /**
     * 所属模块
     */
    protected WebModule module;
    /**
     * 父菜单
     */
    protected String parent;
    /**
     * product/action/version构成叶子菜单的最终访问路径，与Skeleton4jService的page方法入参一致
     */
    protected String product;
    /**
     *  功能
     */
    protected String action;
    /**
     * 版本号
     */
    protected String version;

    public String getName() {
        if (name == null) {
            return product + "/" + action + "/" + version;
        } else {
            return name;
        }
    }

    public static WebNodeBuilder nodeBuilder() {
        return new WebNodeBuilder();
    }

    public static class WebNodeBuilder {
        /**
         * 图标 字体或者图片路径classpath*:com.rnkrsoft.xxx.png
         */
        String icon;
        /**
         * 菜单英文名称
         */
        String name;
        /**
         * 菜单展示名称
         */
        String title;
        /**
         * 状态
         */
        int status;
        /**
         * 是否使用权限
         */
        boolean useAuthority;
        /**
         * 是否隐藏
         */
        boolean hidden;
        /**
         * 是否展开
         */
        boolean expand;
        /**
         * 所属模块
         */
        WebModule module;
        /**
         * 父菜单
         */
        String parent;

        String product;

        String action;
        /**
         * 版本号
         */
        String version;

        public WebNodeBuilder icon(String icon) {
            this.icon = icon;
            return this;
        }

        public WebNodeBuilder title(String title) {
            this.title = title;
            return this;
        }

        public WebNodeBuilder status(int status) {
            this.status = status;
            return this;
        }

        public WebNodeBuilder useAuthority(boolean useAuthority) {
            this.useAuthority = useAuthority;
            return this;
        }

        public WebNodeBuilder hidden(boolean hidden) {
            this.hidden = hidden;
            return this;
        }

        public WebNodeBuilder expand(boolean expand) {
            this.expand = expand;
            return this;
        }

        public WebNodeBuilder module(WebModule module) {
            this.module = module;
            return this;
        }

        public WebNodeBuilder parent(String parent) {
            this.parent = parent;
            return this;
        }

        public WebNodeBuilder product(String product) {
            this.product = product;
            return this;
        }

        public WebNodeBuilder action(String action) {
            this.action = action;
            return this;
        }

        public WebNodeBuilder version(String version) {
            this.version = version;
            return this;
        }

        public WebNode build() {
            WebNode node = new WebNode();
            node.icon = icon;
            node.title = title;
            node.status = status;
            node.useAuthority = useAuthority;
            node.hidden = hidden;
            node.expand = expand;
            node.module = module;
            node.parent = parent;
            node.product = product;
            node.action = action;
            node.version = version;
            return node;
        }
    }
}
