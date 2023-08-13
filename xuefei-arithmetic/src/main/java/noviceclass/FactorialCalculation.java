package noviceclass;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/1/29 3:42 PM
 * @Version 1.0
 */
public class FactorialCalculation {

    public static void main(String[] args) {
        System.out.println(factorialCalculation(5));
    }

    public static long factorialCalculation(int n) {
        if (n == 0) {
            return 0L;
        }
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }
}
