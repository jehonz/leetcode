package part0;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Question20 {
	
	static Map<Character, Character> map;

	public static void main(String[] args) {
		String s = "(())";
		System.out.println(isValid(s));
	}
	
	static {
		map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
	}
	
	public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
        	return true;
        }
        int len = s.length();
        if ((len & 1) == 1) {
        	return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
        	char c = s.charAt(i);
        	if (map.containsKey(c)) {
        		char tmp = stack.isEmpty()? '#' : stack.pop();
        		if (tmp != map.get(c)) {
        			return false;
        		}
        	} else {
        		stack.push(c);
        	}
        }
        return stack.isEmpty();
    }
}
