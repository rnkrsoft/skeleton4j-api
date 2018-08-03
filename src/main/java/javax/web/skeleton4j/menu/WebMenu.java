package javax.web.skeleton4j.menu;

import lombok.Getter;
import lombok.ToString;

import javax.web.skeleton4j.module.WebModule;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by rnkrsoft.com on 2017/10/9.
 * 界面菜单的对象封装
 * @see WebNode
 */
@ToString
public class WebMenu extends WebNode {
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
         * 所属模块
         */
        WebModule module;
        /**
         * 父菜单
         */
        String parent;
        /**
         * 子菜单
         */
        Collection<WebNode> nodes = new LinkedList();

        public WebMenuBuilder icon(String icon) {
            this.icon = icon;
            return this;
        }

        public WebMenuBuilder name(String name) {
            this.name = name;
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


        public WebMenuBuilder node(WebNode... node) {
            this.nodes.addAll(Arrays.asList(node));
            return this;
        }

        public WebMenu build() {
            WebMenu node = new WebMenu();
            node.icon = icon;
            node.name = name;
            node.title = title;
            node.status = status;
            node.useAuthority = useAuthority;
            node.hidden = hidden;
            node.module = module;
            node.parent = parent;
            node.nodes.addAll(nodes);
            return node;
        }
    }
}
