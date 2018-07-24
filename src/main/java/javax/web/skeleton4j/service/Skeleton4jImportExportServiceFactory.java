package javax.web.skeleton4j.service;

import com.rnkrsoft.logtrace4j.ErrorContext;
import com.rnkrsoft.logtrace4j.ErrorContextFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Created by rnkrsoft.com on 2018/2/28.
 */
@Slf4j
public class Skeleton4jImportExportServiceFactory {
    /**
     * 根据文件格式获取导入导出服务
     *
     * @param format 文件格式，支持csv,xls等
     * @return 导入导出服务
     */
    public static Skeleton4jImportExportService getInstance(String format) {
        Skeleton4jImportExportService service = null;
        ServiceLoader<Skeleton4jImportExportService> serviceLoader = ServiceLoader.load(Skeleton4jImportExportService.class);
        Iterator<Skeleton4jImportExportService> serviceIterator = serviceLoader.iterator();
        while (service == null && serviceIterator.hasNext()) {
            Skeleton4jImportExportService service0 = serviceIterator.next();
            if (format == null) {
                log.warn(" 文件格式为空，使用默认格式xls");
                format = "xls";
            }
            if (format.equalsIgnoreCase(service0.getSupportFormat())) {
                service = service0;
            }
        }
        if (service == null) {
            ErrorContext errorContext = ErrorContextFactory.instance().reset()
                    .message("未发现支持文件格式 '{}' 的实现", format)
                    .solution("在META-INF/services/{}", Skeleton4jImportExportService.class.getName());
            Iterator<Skeleton4jImportExportService> it = serviceLoader.iterator();
            int i = 0;
            while (it.hasNext()) {
                i++;
                Skeleton4jImportExportService service0 = it.next();
                errorContext.extra("found", "实现[{}] {} 支持格式 '{}'", i, service0.getClass().getName(), service0.getSupportFormat());
            }
            throw errorContext.runtimeException();
        }
        return service;
    }

    /**
     * 获取支持的格式后缀
     * @return 格式后缀列表
     */
    public static List<String> getFormats() {
        Set<String> formats = new HashSet();
        ServiceLoader<Skeleton4jImportExportService> serviceLoader = ServiceLoader.load(Skeleton4jImportExportService.class);
        Iterator<Skeleton4jImportExportService> serviceIterator = serviceLoader.iterator();
        while (serviceIterator.hasNext()) {
            Skeleton4jImportExportService service0 = serviceIterator.next();
            formats.add(service0.getSupportFormat());
        }
        return new ArrayList<String>(formats);
    }
}
