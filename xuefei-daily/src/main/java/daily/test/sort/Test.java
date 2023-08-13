package daily.test.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/9 5:50 下午
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Student student = new Student();
            int id = random.nextInt(100);
            int k = random.nextInt(1000);
            long l = random.nextInt(10000);
            student.setAge(k);
            student.setBirthday(l);
            student.setId(id);
            students.add(student);
        }

//        students.get(7).setAge(null);

        List<Student> sortStudents = students.stream().sorted(Comparator.comparing(Student::getAge, Comparator.reverseOrder()).thenComparingLong(Student::getBirthday).thenComparing(Student::getId)).collect(Collectors.toList());

        for (Student sortStudent : sortStudents) {
            System.out.println(sortStudent.getAge() + "--" + sortStudent.getBirthday() + "--" + sortStudent.getId());
        }
    }

}
