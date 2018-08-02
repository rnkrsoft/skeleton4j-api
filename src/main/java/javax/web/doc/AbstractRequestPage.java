package javax.web.doc;

import lombok.ToString;

import javax.web.doc.annotation.ApidocElement;

/**
 * Created by rnkrsoft.com on 2017/12/5.
 * 抽象的分页请求
 * @see AbstractResponsePage
 */
@ToString(callSuper = true)
public abstract class AbstractRequestPage implements RequestPageable {
    @ApidocElement(value = "分页大小", required = false, defaults = "20")
    int pageSize;
    @ApidocElement(value = "当前页", required = false, defaults = "1")
    int pageNo;

    public final int getPageSize() {
        return pageSize;
    }

    public final void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public final int getPageNo() {
        return pageNo;
    }

    public final void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

}
