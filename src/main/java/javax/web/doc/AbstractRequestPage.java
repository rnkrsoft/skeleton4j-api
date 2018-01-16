package javax.web.doc;

import lombok.ToString;

import javax.web.doc.annotation.ApidocElement;

/**
 * 分页请求
 */
@ToString(callSuper = true)
public abstract class AbstractRequestPage implements RequestPageable {
    @ApidocElement("分页大小")
    int pageSize;
    @ApidocElement("当前页")
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
