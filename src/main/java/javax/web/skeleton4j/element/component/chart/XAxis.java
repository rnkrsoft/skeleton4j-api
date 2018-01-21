package javax.web.skeleton4j.element.component.chart;

import java.util.List;

/**
 * Created by devops4j on 2017/12/15.
 */
public class XAxis {
    /**
     * 是否显示 轴
     */
    boolean show = true;
    /**
     * 轴所在的 grid 的索引，默认位于第一个 grid。
     */
    int gridIndex = 0;
    /**
     * 默认 grid 中的第一个 x 轴在 grid 的下方（'bottom'），第二个 x 轴视第一个 x 轴的位置放在另一侧。
     */
    Position position = Position.bottom;
    /**
     * X 轴相对于默认位置的偏移，在相同的 position 上有多个 X 轴的时候有用。
     */
    int offset = 0;
    /**
     * 坐标轴类型。
     */
    Type type = Type.category;
    /**
     * 坐标轴名称
     */
    String name;
    /**
     * 坐标轴名称显示位置
     */
    NameLocation nameLocation;
    /**
     * 坐标轴名称的文字样式
     */
    NameTextStyle nameTextStyle;
    /**
     * 坐标轴名称与轴线之间的距离
     */
    int nameGap = 15;
    /**
     * 坐标轴名字旋转，角度值
     */
    int nameRotate = 0;
    /**
     * 是否是反向坐标轴
     */
    boolean inverse = false;
    /**
     * 坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样。
     * <p>
     * 类目轴中 boundaryGap 可以配置为 true 和 false。默认为 true，这时候刻度只是作为分隔线，标签和数据点都会在两个刻度之间的带(band)中间。
     * <p>
     * 非类目轴，包括时间，数值，对数轴，boundaryGap是一个两个值的数组，分别表示数据最小值和最大值的延伸范围，可以直接设置数值或者相对的百分比，在设置 min 和 max 后无效
     */
    List<Object> boundaryGap;

}
