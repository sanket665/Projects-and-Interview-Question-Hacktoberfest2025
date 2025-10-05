import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index, List<String> path, List<String> result) {
        
        if (path.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;

            String segment = s.substring(index, index + len);

            if (isValid(segment)) {
                path.add(segment);
                backtrack(s, index + len, path, result);
                path.remove(path.size() - 1); 
            }
        }
    }

    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.restoreIpAddresses("25525511135")); 
        System.out.println(s.restoreIpAddresses("0000")); 
        System.out.println(s.restoreIpAddresses("101023")); 
    }
}
