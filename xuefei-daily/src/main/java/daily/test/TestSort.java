package daily.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/6/13 8:29 PM
 * @Version 1.0
 */
public class TestSort {

	public static void main(String[] args) {

		List<Integer> addTimes = new ArrayList<>();
		addTimes.add(20220910);
		addTimes.add(20230910);
		addTimes.add(20240910);
		addTimes.add(20250910);

		addTimes.sort((e1, e2) -> e2 - e1);

		System.out.println(addTimes);

	}
}
