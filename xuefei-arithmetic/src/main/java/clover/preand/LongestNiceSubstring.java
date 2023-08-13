package clover.preand;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/17 4:45 下午
 * @Version 1.0
 */
public class LongestNiceSubstring {


    public String longestNiceSubstring_2(String s) {
        int n = s.length();
        int[][] cnt = new int[n + 1][128];
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            cnt[i] = cnt[i - 1].clone();
            cnt[i][c - 'A']++;
        }
        int idx = -1, len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 <= len) {
                    continue;
                }
                int[] a = cnt[i], b = cnt[j + 1];
                if (check(a, b)) {
                    idx = i;
                    len = j - i + 1;
                }
            }
        }
        return idx == -1 ? "" : s.substring(idx, idx + len);
    }

    boolean check(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            int low = b[i] - a[i], up = b[i + 32] - a[i + 32]; // 'A' = 65、'a' = 97
            if (low != 0 && up == 0) {
                return false;
            }
            if (low == 0 && up != 0) {
                return false;
            }
        }
        return true;
    }



    public String longestNiceSubstring(String s) {
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 > ans.length() && check(s.substring(i, j + 1))) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    boolean check(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (char c : s.toCharArray()) {
            char a = Character.toLowerCase(c), b = Character.toUpperCase(c);
            if (!set.contains(a) || !set.contains(b)) {
                return false;
            }
        }
        return true;
    }

}