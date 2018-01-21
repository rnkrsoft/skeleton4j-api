package javax.web.skeleton4j.element.component.chart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devops4j on 2017/12/15.
 */
public class LineStyle {
    static enum Type {
        linear,
        radial
    }

    static class ColorStop {
        int offset = 0;

    }

    Type type;
    int x;
    int y;
    int x2;
    int y2;
    final List<ColorStop> colorStops = new ArrayList();
    boolean globalCoord = false;
}
