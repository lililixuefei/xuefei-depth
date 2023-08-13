package labuladong.array;

import java.util.Stack;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/1 4:40 PM
 * @Version 1.0
 */
public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();

        // 维护一个计数器记录字符串中字符的数量
        // 因为输入为 ASCII 字符，大小 256 够用了
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            // 每遍历过一个字符，都将对应的计数减一
            count[c]--;
            if (inStack[c]) {
                continue;
            }

            while (!stk.isEmpty() && stk.peek() > c) {
                // 若之后不存在栈顶元素了，则停止 pop
                if (count[stk.peek()] == 0) {
                    break;
                }
                // 若之后还有，则可以 pop
                inStack[stk.pop()] = false;
            }
            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.empty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }

    public static String removeDuplicateLetters1(String s) {
        Stack<Character> stk = new Stack<>();
        boolean[] inStack = new boolean[256];

        for (char c : s.toCharArray()) {
            if (inStack[c]) {
                continue;
            }
            // 插入之前，和之前的元素比较一下大小
            // 如果字典序比前面的小，pop 前面的元素
            while (!stk.isEmpty() && stk.peek() > c) {
                // 弹出栈顶元素，并把该元素标记为不在栈中
                inStack[stk.pop()] = false;
            }

            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.empty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }

    public static String removeDuplicateLetters2(String s) {
        // 存放去重的结果
        Stack<Character> stk = new Stack<>();
        // 布尔数组初始值为 false，记录栈中是否存在某个字符
        // 输入字符均为 ASCII 字符，所以大小 256 够用了
        boolean[] inStack = new boolean[256];

        for (char c : s.toCharArray()) {
            // 如果字符 c 存在栈中，直接跳过
            if (inStack[c]) {
                continue;
            }
            // 若不存在，则插入栈顶并标记为存在
            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.empty()) {
            sb.append(stk.pop());
        }
        // 栈中元素插入顺序是反的，需要 reverse 一下
        return sb.reverse().toString();
    }

}
