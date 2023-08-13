package labuladong.brackets;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/1 11:13 AM
 * @Version 1.0
 */
public class Brackets {

    public static void main(String[] args) {
//        System.out.println(isValid("()[]{}"));
        System.out.println(minInsertions1(")("));
    }


   public static int minInsertions1(String s) {
        int res = 0, need = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                need += 2;
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
            }

            if (s.charAt(i) == ')') {
                need--;
                if (need == -1) {
                    res++;
                    need = 1;
                }
            }
        }

        return res + need;
    }

    public static int minInsertions(String s) {
        int res = 0, need = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                need += 2;
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
            }
            if (c == ')') {
                need--;
                if (need == -1) {
                    res++;
                    need = 1;
                }
            }
        }

        return res + need;
    }

    public static int minAddToMakeValid(String s) {
        // res 记录插入次数
        int res = 0;
        // need 变量记录右括号的需求量
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                // 对右括号的需求 + 1
                need++;
            }
            if (c == ')') {
                // 对右括号的需求 - 1
                need--;
                if (need == -1) {
                    need = 0;
                    // 需插入一个左括号
                    res++;
                }
            }
        }

        return res + need;
    }

    public static Boolean isValid(String str) {
        Deque<Character> left = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                left.push(c);
            } else {
                if (!left.isEmpty() && leftOf(c) == left.getFirst()) {
                    left.pop();
                } else {
                    return false;
                }
            }
        }
        return left.isEmpty();
    }

    public static char leftOf(char c) {
        if (c == '}') {
            return '{';
        }
        if (c == ')') {
            return '(';
        }
        return '[';
    }
}
