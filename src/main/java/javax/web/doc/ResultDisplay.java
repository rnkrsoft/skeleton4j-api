package javax.web.doc;

import lombok.Getter;

import javax.web.doc.enums.WebDisplayType;

/**
 * Created by devops4j on 2017/12/7.
 */
public class ResultDisplay {
    @Getter
    WebDisplayType displayType;

    @Getter
    CascadeColumn column;

    public ResultDisplay(WebDisplayType displayType, CascadeColumn column) {
        this.displayType = displayType;
        this.column = column;
    }

    @Override
    public String toString() {
        return displayType.getCode() + " " + column.toString();
    }
}
