package javax.web;

/**
 * Created by devops4j on 2017/12/29.
 * 该类申明了Skeleton4j API的版本号
 */
public class Version {
    /**
     * 版本信息
     *
     * @return 版本号
     */
    public static String version() {
        return "1.0.1";
    }

    /**
     * 是否为正式版本
     *
     * @return
     */
    public static boolean release() {
        return false;
    }
}
