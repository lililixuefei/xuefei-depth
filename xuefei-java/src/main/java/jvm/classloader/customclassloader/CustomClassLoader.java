package jvm.classloader.customclassloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/8/24 22:32
 * @Version 1.0
 */
public class CustomClassLoader extends ClassLoader {


    //需要该类加载器直接加载的类文件的基目录
    private String baseDir;

    public CustomClassLoader(String baseDir, String[] classes) throws IOException {
        super();
        this.baseDir = baseDir;
//        loadClassByMe(classes);
    }

    private void loadClassByMe(String[] classes) throws IOException {
        for (int i = 0; i < classes.length; i++) {
            findClass(classes[i]);
        }
    }

    /**
     * 重写findclass方法
     * <p>
     * 在ClassLoader中，loadClass方法先从缓存中找，缓存中没有，会代理给父类查找，如果父类中也找不到，就会调用此用户实现的findClass方法
     *
     * @param name
     * @return
     */
    @Override
    protected Class findClass(String name) {
        Class clazz = null;
        StringBuffer stringBuffer = new StringBuffer(baseDir);
        String className = name.replace('.', File.separatorChar) + ".class";
        stringBuffer.append(File.separator + className);
        File classF = new File(stringBuffer.toString());
        try {
            clazz = instantiateClass(name, new FileInputStream(classF), classF.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    private Class instantiateClass(String name, InputStream fin, long len) throws IOException {
        byte[] raw = new byte[(int) len];
        fin.read(raw);
        fin.close();
        return defineClass(name, raw, 0, raw.length);
    }

}

