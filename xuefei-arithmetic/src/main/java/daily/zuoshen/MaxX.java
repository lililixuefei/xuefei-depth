package daily.zuoshen;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/5/9 6:42 PM
 * @Version 1.0
 */
public class MaxX {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 10, 4, 5, 6, 20};
		System.out.println(maxX(arr));
	}

	public static int maxX(int[] arr) {
		// maxX = arr[j] + arr[i] - (j - i) == (arr[i] + i) + (arr[j] - j)
		int preBest = arr[0];
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			ans = Math.max(ans, arr[i] - i + preBest);
			preBest = Math.max(preBest, arr[i] + i);
		}
		return ans;
	}


	public static int maxX_Violent(int[] arr) {
		int maxX = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				maxX = Math.max(maxX, arr[j] + arr[i] - (j - i));
			}
		}
		return maxX;
	}

}
