package javax.web.doc;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by devops4j on 2017/12/5.
 * 文档扫描器工厂类
 */
public final class DocScannerFactory {
    private DocScannerFactory(){

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
                if (scanner.getClass().getName().equals(impClassName)) {
                    scanner = scanner0;
                }
            } else {
                scanner = scanner0;
            }
        }
        if (scanner == null) {
            throw new RuntimeException("未发现'" + DocScanner.class.getName() + "' 实现");
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
