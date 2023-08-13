package daily.test;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * @Author xuefei
 * @Date 2022/12/30 7:05 PM
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {

        Set<Long> set = new HashSet<Long>();
        set.add(1L);

        Set<Long> set3 = new HashSet<Long>();
        set3.add(2L);

        set = set3;

        set.add(3L);

        for (Long aLong : set) {
            System.out.println(aLong);
        }


//
//        List<Integer> list1 = new ArrayList<Integer>();
//        list1.add(1);
//        List<Integer> list2 = new ArrayList<Integer>();
//        list2.add(1);
//        List<Integer> list3 = new ArrayList<Integer>();
//        list3.add(1);
//
//
//
//        Student student1 = new Student(1,"test",list1,AssessmentMediumEnum.COMPLETE_VIDEO);
//        Student student2 = new Student(2,"test2",list2,AssessmentMediumEnum.COMPLETE_VIDEO);
//        Student student3 = new Student(1,"test",list1,AssessmentMediumEnum.COMPLETE_VIDEO);
//
//        List<Student> students1 = new ArrayList<>();
//        students1.add(student1);
//        students1.add(student2);
//
//        List<Student> students2 = new ArrayList<>();
//        students2.add(student3);
//
//        List<Student> studentList = Stream.of(students1, students2).flatMap(Collection::stream).distinct().collect(Collectors.toList());
//
//        for (Student student : studentList) {
//            System.out.println(student);
//        }


    }


}
