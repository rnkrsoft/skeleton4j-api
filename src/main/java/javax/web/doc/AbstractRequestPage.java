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

    /**
     * 分页大小
     *
     * @return
     */
    public final int getPageSize() {
        return pageSize;
    }

    /**
     * 分页大小
     *
     */
    public final void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 当前页
     *
     * @return
     */
    public final int getPageNo() {
        return pageNo;
    }

    /**
     * 当前页
     */
    public final void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

}
