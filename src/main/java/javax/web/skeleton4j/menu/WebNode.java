package javax.web.skeleton4j.menu;

import lombok.Getter;
import lombok.Setter;

import javax.web.skeleton4j.module.WebModule;

/**
 * Created by devops4j on 2017/10/9.
 */
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

    @Getter
    @Setter
    int no = 0;
    /**
     * 图标 字体或者图片路径classpath*:com.devops4j.xxx.png
     */
    @Getter
    @Setter
    String icon;
    /**
     * 菜单英文名称
     */
    String name;
    /**
     * 菜单展示名称
     */
    @Getter
    @Setter
    String title;
    /**
     * 状态
     */
    @Getter
    @Setter
    int status;
    /**
     * 是否使用权限
     */
    @Getter
    @Setter
    boolean useAuthority;

    @Getter
    @Setter
    boolean hidden;
    /**
     * 所属模块
     */
    @Getter
    @Setter
    WebModule module;
    /**
     * 父菜单
     */
    @Getter
    @Setter
    String parent;
    /**
     * product/action/version构成叶子菜单的最终访问路径，与Skeleton4jService的page方法入参一致
     */
    @Getter
    @Setter
    String product;

    @Getter
    @Setter
    String action;
    /**
     * 版本号
     */
    @Getter
    @Setter
    String version;

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
         * 图标 字体或者图片路径classpath*:com.devops4j.xxx.png
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
        boolean hidden;
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
            node.module = module;
            node.parent = parent;
            node.product = product;
            node.action = action;
            node.version = version;
            return node;
        }
    }
}
