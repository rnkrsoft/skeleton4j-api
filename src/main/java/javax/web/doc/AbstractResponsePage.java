package javax.web.doc;

import lombok.ToString;

import javax.web.doc.annotation.ApidocElement;
import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true)
public abstract class AbstractResponsePage<T> extends AbstractResponse implements ResponsePageable<T> {
    @ApidocElement("记录")
    final List<T> records = new ArrayList();
    @ApidocElement("分页大小")
    int pageSize;
    @ApidocElement("当前页")
    int pageNo;
    @ApidocElement("总条数")
    long total;
    @ApidocElement("页数")
    int pageNum;


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

    public final long getTotal() {
        return total;
    }

    public final void setTotal(long total) {
        this.total = total;
    }

    public final int getPageNum() {
        return pageNum;
    }

    public final void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public final List<T> getRecords() {
        return records;
    }

}
