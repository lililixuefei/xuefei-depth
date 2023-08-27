package manshen.cas;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/08/27 22:53
 */
public class TestAtomicReferenceFieldUpdater {

    public static void main(String[] args) {
        Student stu = new Student();

        AtomicReferenceFieldUpdater updater = AtomicReferenceFieldUpdater.newUpdater(Student.class, String.class, "name");

        System.out.println(updater.compareAndSet(stu, null, "张三"));
        System.out.println(stu);
    }

}

class Student {
    volatile String name;

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + '}';
    }
}