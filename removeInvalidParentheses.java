
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int len = -1;
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        if (s == null) {
            result.add("");
            return result;
        }
        queue.add(s);
        set.add(s);
        boolean found = false;
        
        while (!queue.isEmpty()) {
            String str = queue.poll();
            
            if (isValid(str)) {
                result.add(str);
                found = true;
                len = str.length();
            }
            
            if (found) {
                if (str.length() < len) {
                    break;
                }
                continue;
            }
            
            for (int i = 0; i < str.length(); i ++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                    continue;
                }
                
                String next = str.substring(0, i) + str.substring(i + 1, str.length());
                if (set.contains(next)) {
                    continue;
                }
                set.add(next);
                queue.add(next);
            }
        }
        return result;
    }
    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(') {
                count ++;
            } else if (s.charAt(i) == ')') {
                count --;
            }
            if (count < 0) {
                return false;
            }
        }
        return 0 == count;
    }
}
