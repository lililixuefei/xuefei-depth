package daily.test;

import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/4/7 4:35 PM
 * @Version 1.0
 */
@Data
public class Student {

	private Integer id;

	private String name;

	private List<Integer> list;

	private AssessmentMediumEnum assessmentMediumEnum;

	public Student(Integer id,String name,List<Integer> list, AssessmentMediumEnum assessmentMediumEnum) {
		this.id = id;
		this.name = name;
		this.list = list;
		this.assessmentMediumEnum = assessmentMediumEnum;
	}

	public Student() {
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				'}';
	}
//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//		Student student = (Student) o;
//		return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(list, student.list) && assessmentMediumEnum == student.assessmentMediumEnum;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(id, name, list, assessmentMediumEnum);
//	}
}
