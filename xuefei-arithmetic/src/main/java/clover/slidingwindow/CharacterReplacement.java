package clover.slidingwindow;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/3/22 10:33 上午
 * @Version 1.0
 */
public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];
        int ans = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            cnt[cs[r] - 'A']++;
            while (!check(cnt, k)) {
                cnt[cs[l++] - 'A']--;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    boolean check(int[] cnt, int k) {
        int max = 0, sum = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, cnt[i]);
            sum += cnt[i];
        }
        return sum - max <= k;
    }

}
