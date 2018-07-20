package javax.web.doc;

import javax.web.skeleton4j.registry.WebComponentRegistry;
import java.util.List;

/**
 * Created by rnkrsoft.com on 2018/1/11.
 */
public class DemoDocScanner implements DocScanner {
    @Override
    public DocScanner register(DocScannerColumnFilter filter) {
        return null;
    }

    @Override
    public DocScanner register(DocScannerIgnoreColumnFilter filter) {
        return null;
    }

    @Override
    public void setClassLoader(ClassLoader classLoader) {

    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void setComponentRegistry(WebComponentRegistry registry) {

    }

    @Override
    public WebComponentRegistry getComponentRegistry() {
        return null;
    }

    @Override
    public DocScanner addScanPackage(String... packages) {
        return null;
    }

    @Override
    public DocScanner init(boolean ifThrow, String... packages) {
        return null;
    }

    @Override
    public void scan(boolean ifThrow, Class<?> clazz) {

    }

    @Override
    public void scan(Class<?> serviceClass) {

    }

    @Override
    public DocScanner define(ColumnDefineMetadata metadata) {
        return null;
    }

    @Override
    public List<ColumnDefineMetadata> listDefinedColumns(String... names) {
        return null;
    }

    @Override
    public List<String> listDefinedColumnNames() {
        return null;
    }

    @Override
    public List<KeywordResult> lookupKeyword(String... keywords) {
        return null;
    }

    @Override
    public List<ServiceInfo> listService() {
        return null;
    }

    @Override
    public ServiceInfo lookupService(String serviceName) {
        return null;
    }

    @Override
    public ServiceInfo lookupService(Class serviceClass) {
        return null;
    }

    @Override
    public List<InterfaceInfo> listInterface(String... serviceNames) {
        return null;
    }

    @Override
    public List<InterfaceInfo> listInterface(Class<?>... serviceClasses) {
        return null;
    }

    @Override
    public InterfaceInfo listInterface(String serviceName, String interfaceName) {
        return null;
    }

    @Override
    public InterfaceInfo listInterface(String serviceName, String interfaceName, String version) {
        return null;
    }
}
