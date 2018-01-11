package javax.web.doc;

import com.devops4j.logtrace4j.ErrorContext;
import com.devops4j.logtrace4j.ErrorContextFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by devops4j on 2017/12/5.
 * 文档扫描器工厂类
 */
public final class DocScannerFactory {
    private DocScannerFactory() {

    }

    /**
     * 新建一个文档扫描器
     *
     * @param impClassName 实现类名称
     * @return 文档扫描器
     */
    public static DocScanner newInstance(String impClassName) {
        DocScanner scanner = null;
        ServiceLoader<DocScanner> serviceLoader = ServiceLoader.load(DocScanner.class);
        Iterator<DocScanner> scannerIterator = serviceLoader.iterator();
        while (scanner == null && scannerIterator.hasNext()) {
            DocScanner scanner0 = scannerIterator.next();
            if (impClassName != null) {
                if (scanner0.getClass().getName().equals(impClassName)) {
                    scanner = scanner0;
                }
            } else {
                scanner = scanner0;
            }
        }
        if (scanner == null) {
            ErrorContext errorContext = ErrorContextFactory.instance().reset();
            errorContext.message("未发现'{}' 实现", impClassName == null ? DocScanner.class.getName() : impClassName)
                    .solution("在META-INF/services/javax.web.doc.DocScanner文件中定义实现类");
            Iterator<DocScanner> it = serviceLoader.iterator();
            int i = 0;
            while (it.hasNext()) {
                i++;
                DocScanner docScanner = it.next();
                errorContext.extra("found", "实现{} {}", i, docScanner.getClass().getName());
            }
            throw errorContext.runtimeException();
        }
        System.out.println("DocScanner 使用实现'" + scanner.getClass().getName() + "'");
        return scanner;
    }

    /**
     * 新建一个文档扫描器
     *
     * @return 文档扫描器
     */
    public static DocScanner newInstance() {
        return newInstance(null);
    }
}
