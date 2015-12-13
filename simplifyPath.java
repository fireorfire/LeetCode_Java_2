public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for (String p : paths) {
            if (p.equals("") || p.equals(".")) {
                continue;
            }
            else if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(p);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }
        if (result.length() == 0) {
            return "/";
        }
        return result.toString();
    }
}