package jvm.classloader.customclassloader2;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/8/24 22:49
 * @Version 1.0
 */

public class BizClassLoader extends URLClassLoader {

    public BizClassLoader(URL[] urls) {
        super(urls);
    }

}
