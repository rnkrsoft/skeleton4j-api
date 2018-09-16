package javax.web.skeleton4j.element;

import com.rnkrsoft.logtrace4j.ErrorContextFactory;
import lombok.Getter;

import javax.web.doc.ElementInfo;
import javax.web.doc.enums.WebDisplayType;
import javax.web.skeleton4j.element.component.WebConfirmBoxComponent;
import javax.web.skeleton4j.element.component.WebDialogBoxComponent;
import javax.web.skeleton4j.element.component.WebMsgBoxComponent;
import javax.web.skeleton4j.page.WebPage;
import javax.web.skeleton4j.registry.WebComponentRegistry;

/**
 * Created by rnkrsoft.com on 2017/12/8.
 */
public class DefaultReferenceWebElement implements ReferenceWebElement {
    @Getter
    ElementInfo column;
    @Getter
    WebComponentRegistry componentRegistry;

    @Getter
    Class elementClass;

    @Getter
    WebPage webPage;

    @Getter
    String id;

    public DefaultReferenceWebElement(WebComponentRegistry componentRegistry, WebPage webPage, ElementInfo column, Class elementClass, String id) {
        this.componentRegistry = componentRegistry;
        this.column = column;
        this.elementClass = elementClass;
        this.webPage = webPage;
        this.id = id;
    }

    @Override
    public WebDisplayType getDisplayType() {
        if (elementClass == WebDialogBoxComponent.class){
            return WebDisplayType.DIALOG_BOX;
        }else if (elementClass == WebConfirmBoxComponent.class){
            return WebDisplayType.CONFIRM_BOX;
        }else if (elementClass == WebMsgBoxComponent.class){
            return WebDisplayType.MSG_BOX;
        }
        return WebDisplayType.DEFAULT;
    }

    public WebElement get() {
        if (this.webPage == null || this.elementClass == null || this.id == null) {
            throw new IllegalArgumentException("字段'" + column + "'引用变量未进行配置，无法进行映射获取真实组件");
        }
        WebElement webElement = this.webPage.lookup(this.id, this.elementClass);
        if (webElement == null) {
            throw new IllegalArgumentException(webPage.getWebPageClassName() + "不存在编号'" + this.id + "'的组件");
        }
        return webElement;
    }

    @Override
    public void bind(WebElement element) {
        if (this.id != null && this.elementClass != null) {
            if (element.getElementClass() != this.elementClass || !element.getId().equals(this.id)) {
                throw ErrorContextFactory.instance()
                        .message("页面类'{}'当前字段'{}'已经进行过映射到组件'{}' 当前希望映射到组件'{}'", webPage.getWebPageClassName(), column, id, element.getId())
                        .solution("移除重复导入的接口")
                        .runtimeException();
            }

        }
        this.elementClass = element.getElementClass();
        this.id = element.getId();
    }


    public <T extends WebElement> T as(Class<T> targetClass) {
        if (targetClass.isAssignableFrom(elementClass)) {
            return (T) get();
        } else {
            throw new ClassCastException("不能将组件对象转换为'" + targetClass + "',因为组件类型为'" + elementClass + "'");
        }
    }

}