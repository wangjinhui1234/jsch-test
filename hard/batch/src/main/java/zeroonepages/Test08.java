package zeroonepages;

import java.util.Arrays;
import java.util.List;

class Solution {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && dp[i - len] && word.equals(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

            String str ="catsandog";
        List<String> strings = Arrays.asList("cats", "dog", "sand", "and", "cat");
        boolean b = wordBreak(str, strings);
        System.out.println();

    }
}
