package javax.web.doc;

import javax.web.skeleton4j.registry.WebComponentRegistry;
import java.util.List;

/**
 * Created by 面试1 on 2018/1/11.
 */
public class DemoDocScanner implements DocScanner{
    @Override
    public void setClassLoader(ClassLoader classLoader) {

    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
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
    public DocScanner init(boolean ifThrow) {
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
    public List<ServiceInfo> listService() {
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
