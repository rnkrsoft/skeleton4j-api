package javax.web.skeleton4j.menu;

import lombok.Getter;

import javax.web.skeleton4j.module.WebModule;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by devops4j on 2017/10/9.
 */
public class WebMenu extends WebNode{
    @Getter
    final Collection<WebNode> nodes = new LinkedList();

    public WebMenu addNode(WebNode node) {
        nodes.add(node);
        return this;
    }

    public static WebMenuBuilder menuBuilder() {
        return new WebMenuBuilder();
    }

    public static class WebMenuBuilder {
        /**
         * 图标 字体或者图片路径classpath*:com.devops4j.xxx.png
         */
        String icon;
        /**
         * 菜单英文名称
         */
        String mark;
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

        String app;

        String product;

        String action;

        String subAction;
        /**
         * 版本号
         */
        String version;
        /**
         * 子菜单
         */
        Collection<WebNode> nodes = new LinkedList();

        public WebMenuBuilder icon(String icon) {
            this.icon = icon;
            return this;
        }

        public WebMenuBuilder mark(String mark) {
            this.mark = mark;
            return this;
        }

        public WebMenuBuilder title(String title) {
            this.title = title;
            return this;
        }

        public WebMenuBuilder status(int status) {
            this.status = status;
            return this;
        }

        public WebMenuBuilder useAuthority(boolean useAuthority) {
            this.useAuthority = useAuthority;
            return this;
        }

        public WebMenuBuilder hidden(boolean hidden) {
            this.hidden = hidden;
            return this;
        }

        public WebMenuBuilder module(WebModule module) {
            this.module = module;
            return this;
        }

        public WebMenuBuilder parent(String parent) {
            this.parent = parent;
            return this;
        }

        public WebMenuBuilder app(String app) {
            this.app = app;
            return this;
        }

        public WebMenuBuilder product(String product) {
            this.product = product;
            return this;
        }

        public WebMenuBuilder action(String action) {
            this.action = action;
            return this;
        }

        public WebMenuBuilder subAction(String subAction) {
            this.subAction = subAction;
            return this;
        }

        public WebMenuBuilder version(String version) {
            this.version = version;
            return this;
        }

        public WebMenuBuilder node(WebNode ... node) {
            this.nodes.addAll(Arrays.asList(node));
            return this;
        }

        public WebMenu build() {
            WebMenu node = new WebMenu();
            node.icon = icon;
            node.mark = mark;
            node.title = title;
            node.status = status;
            node.useAuthority = useAuthority;
            node.hidden = hidden;
            node.module = module;
            node.parent = parent;
            node.app = app;
            node.product = product;
            node.action = action;
            node.subAction = subAction;
            node.version = version;
            node.nodes.addAll(nodes);
            return node;
        }
    }
}
