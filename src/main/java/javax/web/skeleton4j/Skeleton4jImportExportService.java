package javax.web.skeleton4j;

import javax.web.doc.InterfaceInfo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by devops4j on 2018/2/28.
 * 导入导出服务
 */
public interface Skeleton4jImportExportService {
    /**
     * 支持的文件格式
     * @return 文件格式
     */
    String getSupportFormat();
    /**
     * 解析接口对应的文件
     * @param interfaceInfo 接口元信息
     * @param file 文件
     * @param object 对象
     * @param <T> 解析出的对象
     * @return 解析出的对象
     */
    <T> T parse(InterfaceInfo interfaceInfo, File file, Object object) throws IOException;

    /**
     * 解析接口对应的输入流
     * @param interfaceInfo 接口元信息
     * @param is 输入流
     * @param object 对象
     * @param <T> 解析出的对象
     * @return 解析出的对象
     */
    <T> T parse(InterfaceInfo interfaceInfo, InputStream is, Object object) throws IOException;

    /**
     * 根据接口和输入的对象生成导出文件
     * @param interfaceInfo 接口元信息
     * @param file 文件
     * @param data 对象
     */
    void generate(InterfaceInfo interfaceInfo, File file, Object data) throws IOException;
    /**
     * 根据接口和输入的对象生成输出流
     * @param interfaceInfo 接口元信息
     * @param os 输出流
     * @param data 对象
     */
    void generate(InterfaceInfo interfaceInfo, OutputStream os, Object data) throws IOException;
}
