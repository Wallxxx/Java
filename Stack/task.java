import java.util.*;

public class tests {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Vector stack = new Vector(0);
            String input = sc.next();
            boolean check = false;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
                    stack.addElement(input.charAt(i));
                }
                else if (input.charAt(i) == ')' && stack.size() > 0) {
                    if ((char)stack.lastElement() == '(') {
                        stack.remove(stack.size() - 1);
                    }
                    else {
                        System.out.println(false);
                        check = true;
                        break;
                    }
                }
                else if (input.charAt(i) == '}' && stack.size() > 0) {
                    if ((char)stack.lastElement() == '{') {
                        stack.remove(stack.size() - 1);
                    }
                    else {
                        System.out.println(false);
                        check = true;
                        break;
                    }
                }
                else if (input.charAt(i) == ']' && stack.size() > 0) {
                    if ((char)stack.lastElement() == '[') {
                        stack.remove(stack.size() - 1);
                    }
                    else {
                        System.out.println(false);
                        check = true;
                        break;
                    }
                }
                else {
                    System.out.println(false);
                    check = true;
                    break;
                }
            }
            if (!check) {
                if (stack.size() > 0) System.out.println(false);
                else System.out.println(true);
            }
        }
    }
}
