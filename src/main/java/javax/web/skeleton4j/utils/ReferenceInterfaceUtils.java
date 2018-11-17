package javax.web.skeleton4j.utils;


import com.rnkrsoft.logtrace4j.ErrorContextFactory;

import javax.web.doc.DocScanner;
import javax.web.doc.ReferenceInterface;

/**
 * Created by rnkrsoft.com on 2017/10/18.
 * 引用接口表达式工具类
 * 支持如下格式的表达式
 * doing1=com.rnkrsoft.xxx.DemoService.doing1:1.0.0
 * doing1=com.rnkrsoft.xxx.DemoService.doing1
 * com.rnkrsoft.xxx.DemoService.doing1:1.0.0
 * com.rnkrsoft.xxx.DemoService.doing1
 */
public class ReferenceInterfaceUtils {
    /**
     * 根据输入的引用接口表达式，获取引用接口类
     *
     * @param inter 接口表达式
     * @param docScanner 文档对象
     * @return
     */
    public static ReferenceInterface getRefInterface(String inter, DocScanner docScanner) {
        String[] inters = parse(inter);
        ReferenceInterface ref = new ReferenceInterface(docScanner, null, inters[0], inters[1], inters[2], inters[3]);
        return ref;
    }

    /**
     * 根据输入的引用接口表达式，获取引用接口类
     *
     * @param inter 接口表达式
     * @param serviceClass 接口所在服务类
     * @param docScanner 文档对象
     * @return
     */
    public static ReferenceInterface getRefInterface(String inter, Class serviceClass, DocScanner docScanner) {
        String[] inters = parse(inter, serviceClass);
        ReferenceInterface ref = new ReferenceInterface(docScanner, null, inters[0], inters[1], inters[2], inters[3]);
        return ref;
    }
    /**
     * 根据输入的引用接口字符串获取接口信息
     * doing1=com.rnkrsoft.xxx.DemoService.doing1:1.0.0
     *
     * @param inter 接口表达式
     * @param serviceClass 服务类
     * @return {接口别名,接口服务名，接口名， 版本号}
     */
    public static String[] parse(String inter, Class serviceClass) {
        //接口别名，应为BOSS权限不支持长于10个长度的action名
        String alias = null;
        String version = null;
        int equalPos = inter.lastIndexOf("=");
        if (equalPos > 0) {
            alias = inter.substring(0, equalPos);
        } else {
            equalPos = -1;
        }
        int colonPos = inter.lastIndexOf(":");
        if (colonPos > 0) {
            version = inter.substring(colonPos + 1);
            if (version.isEmpty()) {
                throw new IllegalArgumentException("引用接口版本号不正确,格式为'" + inter + "',正确格式如：doing1=com.rnkrsoft.xxx.DemoService.doing1:1.0.0");
            }
        } else {
            version = "1.0.0";
            colonPos = inter.length();
        }
        String temp = inter.substring(equalPos + 1, colonPos);
        int lastDotPos = temp.lastIndexOf(".");
        String serviceName = "";
        String interfaceName = "";
        if (lastDotPos == -1) {
            if (serviceClass == null || serviceClass == Class.class){
                throw ErrorContextFactory.instance()
                        .message("接口名称'" + inter + "'格式不正确")
                        .solution("请确保接口引用格式为:'{}'", "doing1=com.rnkrsoft.xxx.DemoService.doing1:1.0.0")
                        .runtimeException();
            }else{
                serviceName = serviceClass.getName();
                interfaceName = temp;
            }
        }else{
            serviceName = temp.substring(0, lastDotPos);
            interfaceName = temp.substring(lastDotPos + 1);
        }
        if (alias == null || alias.isEmpty()) {
            alias = interfaceName;
        }
        return new String[]{alias, serviceName, interfaceName, version};
    }
    /**
     * 根据输入的引用接口字符串获取接口信息
     * doing1=com.rnkrsoft.xxx.DemoService.doing1:1.0.0
     *
     * @param inter
     * @return {接口别名,接口服务名，接口名， 版本号}
     */
    public static String[] parse(String inter) {
       return parse(inter, null);
    }
}
