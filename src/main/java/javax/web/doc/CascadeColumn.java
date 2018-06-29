package javax.web.doc;

import lombok.Getter;

import javax.web.skeleton4j.enums.ColumnType;

/**
 * Created by rnkrsoft.com on 2017/12/7.
 */
public class CascadeColumn {
    @Getter
    InterfaceInfo interfaceInfo;
    @Getter
    ColumnType columnType;
    @Getter
    String columnName;

    public CascadeColumn(InterfaceInfo interfaceInfo, ColumnType columnType, String columnName) {
        this.interfaceInfo = interfaceInfo;
        this.columnType = columnType;
        this.columnName = columnName;
    }

    public ElementInfo get() {
        ElementInfo column = this.interfaceInfo.lookup(columnType, columnName);
        return column;
    }

    @Override
    public String toString() {
        return interfaceInfo.getFullName() + "." + columnType.getCode() + "." + columnName;
    }
}
