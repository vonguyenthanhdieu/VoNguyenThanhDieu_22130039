package Lab10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyLIFO_App {
	// bảo lưu mảng đã cho
	public static <E> void reserve (E[] array) {
		Stack<E> result = new Stack<>();
		for (E e: array) {
			result.push(e);
		}
		for (int i=0; i< array.length; i++) 
			array[i] = result.pop();
		
		System.out.println(Arrays.toString(array));
	}
	
	// kiểm tra tính đúng đắn của đầu vào nhất định
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==> false
	
	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<>();
		for (Character c: input.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') 
				stack.push(c);
			else 
				if (c == ')' || c == '}' || c == ']' ) {
					if (stack.empty())
						return false;
					
					char top = stack.peek();
	                if ((c == ')' && top != '(') ||
	                    (c == ']' && top != '[') ||
	                    (c == '}' && top != '{')) 
	                    return false;
	                    else stack.pop();
				}
		}
		
	return stack.isEmpty();
	}
	// đánh giá giá trị của một biểu thức
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
        Stack<Integer> stack = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    performOperation(stack, operators);
                }
                operators.push(ch);
            } else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    performOperation(stack, operators);
                }
                operators.pop();
            }
        }

        while (!operators.isEmpty()) {
            performOperation(stack, operators);
        }

        return stack.pop();
    }

    private static int precedence(char operator) {
        if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '+' || operator == '-') {
            return 1;
        }
        return 0;
    }

    private static void performOperation(Stack<Integer> stack, Stack<Character> operators) {
        int operand2 = stack.pop();
        int operand1 = stack.pop();
        char operator = operators.pop();

        int result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
        }

        stack.push(result);
    }

    
	// method stutter chấp nhận hàng đợi các số nguyên làm tham số và thay thế 
    // mỗi phần tử của hàng đợi có hai bản sao của phần tử đó
    // front [1, 2, 3] back
    // becomes
    // front [1, 1, 2, 2, 3, 3] back
    public static <E> void stutter(Queue<E> input) {
        int size = input.size();
        for (int i = 0; i < size; i++) {
            E element = input.poll();
            input.offer(element);
            input.offer(element);
        }
    }
    

    // Method mirror chấp nhận hàng đợi làm tham số và nối thêm 
    // nội dung của hàng đợi vào chính nó theo thứ tự ngược lại
    // front [a, b, c] back
    // becomes
    // front [a, b, c, c, b, a] back
    public static <E> void mirror(Queue<E> input) {
    	ArrayList<E> temp = new ArrayList<E>();
        int size = input.size();
        for (int i = 0; i < size; i++) {
            E element = input.poll();
            temp.add(element);
            input.offer(element);
        }
        for (int i = size -1 ; i >= 0; i--) {
        	E element = temp.get(i);
        	input.offer(element);
        }
        
    }

	public static void main(String[] args) {
		//Stack
		Integer[] array = {1, 2, 3, 4, 5};
        reserve(array);
		
		String input = "()(())[]{(())}";
		System.out.println(isCorrect(input));
		
		String expression = "51 + (54 * (3 + 2))";
        System.out.println("Expression Result: " + evaluateExpression(expression));
        
        //Queue
        Queue<Integer> intQueue = new LinkedList<>(Arrays.asList(1, 2, 3));
        stutter(intQueue);
        System.out.println(intQueue);

        Queue<String> stringQueue = new LinkedList<>(Arrays.asList("a", "b", "c"));
        mirror(stringQueue);
        System.out.println(stringQueue);
	}
}
