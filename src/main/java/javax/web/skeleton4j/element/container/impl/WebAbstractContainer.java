package javax.web.skeleton4j.element.container.impl;

import lombok.Getter;
import lombok.Setter;

import javax.web.doc.ElementInfo;
import javax.web.skeleton4j.element.container.WebContainer;
import javax.web.skeleton4j.element.impl.WebAbstractElement;
import javax.web.skeleton4j.page.NamespaceInterfaceMetadata;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;
import javax.web.skeleton4j.theme.WebThemePack;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by rnkrsoft.com on 2017/10/20.
 * 抽象的容器基类
 */
public abstract class WebAbstractContainer extends WebAbstractElement implements WebContainer {

    @Getter
    protected final Collection<NamespaceInterfaceMetadata> interfaces = new ArrayList();
    @Getter
    @Setter
    String product;
    @Getter
    @Setter
    String action;
    @Getter
    @Setter
    String subAction;
    @Getter
    @Setter
    String version;
    @Getter
    @Setter
    String cachePath;
    public WebAbstractContainer(){
        super();
    }

    public WebAbstractContainer(WebComponentRegistry componentRegistry, WebPage webPage, WebThemePack themePack, ElementInfo column, String parentId, String name) {
        super(componentRegistry, webPage, themePack, column, parentId, name);
    }

    protected WebAbstractContainer(WebAbstractContainer src) {
        super(src);
        this.interfaces.addAll(src.interfaces);
        this.product = src.product;
        this.action = src.action;
        this.subAction = src.subAction;
        this.version = src.version;
        this.cachePath = src.cachePath;
    }


    @Override
    public String getCachedFilePath(String fileName, String theme) {
        if (cachePath == null) {
            cachePath = "./target";
        }
        return getCachePath() + File.separator + theme + File.separator + getProduct() + File.separator + getAction() + File.separator + getSubAction() + File.separator + getVersion() + File.separator + fileName;
    }
}
