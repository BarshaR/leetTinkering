package problem.longestSubStr;

import java.util.*;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        LinkedHashSet<Character> currCharSet = new LinkedHashSet<>();
        int max_substr_len = 0;

        for (int i = 0; i < s.length(); i++) {
            updateSet(currCharSet, s.charAt(i));
            max_substr_len = Math.max(max_substr_len, currCharSet.size());
        }

        return max_substr_len;
    }

    // Checks if the character exists within an array
    public void updateSet(LinkedHashSet<Character> set, char input) { // O(n)
        while (!set.add(input)) {
            set.remove(set.iterator().next());
        }
    }
}
