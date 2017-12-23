package javax.web.skeleton4j.utils;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by devops4j on 2017/11/23.
 */
public class ReferenceInterfaceUtilsTest {

    @Test
    public void testGetRefInterface() throws Exception {
        String[] str1 = ReferenceInterfaceUtils.getRefInterfaceString("doing1=com.devops4j.skeleton.doing1:1.0.0");
        System.out.println(Arrays.toString(str1));
        String[] str2 = ReferenceInterfaceUtils.getRefInterfaceString("doing1=com.devops4j.skeleton.doing1");
        System.out.println(Arrays.toString(str2));
        String[] str3 = ReferenceInterfaceUtils.getRefInterfaceString("com.devops4j.skeleton.doing1:1.0.0");
        System.out.println(Arrays.toString(str3));
        String[] str4 = ReferenceInterfaceUtils.getRefInterfaceString("com.devops4j.skeleton.doing1");
        System.out.println(Arrays.toString(str4));
    }
}