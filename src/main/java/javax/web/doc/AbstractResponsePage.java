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
     * @return
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

    /**
     * 总记录数
     *
     * @return
     */
    public final long getTotal() {
        return total;
    }

    /**
     * 总记录数
     */
    public final void setTotal(long total) {
        this.total = total;
    }

    /**
     * 分页数目
     *
     * @return
     */
    public final int getPageNum() {
        return pageNum;
    }

    /**
     * 分页数目
     */
    public final void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * 获取记录
     *
     * @return
     */
    public final List<T> getRecords() {
        return records;
    }

}
