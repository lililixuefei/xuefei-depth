package jdk.reflect;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/08/13 12:09
 */
public class Test1Class {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<Student> c1 = Student.class;
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        Class c2 = Class.forName("jdk.reflect.Student");

        Student student = new Student();
        Class c3 = student.getClass();


    }

    @Test
    public void test(){
        System.out.println("hello");
    }


}
