class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(String s: tokens) {
            
            if("+-*/".contains(s)) {
                
                int y = stack.pop();
                int x = stack.pop();
                
                if(s.equals("+"))
                    stack.push(x + y);
                
                else if(s.equals("-"))
                    stack.push(x - y);
                
                else if(s.equals("*"))
                    stack.push(x * y);
                
                else if(s.equals("/"))
                    stack.push(x / y);
            }
            else
                stack.push(Integer.parseInt(s));
        }
        
        return stack.peek();
    }
}
