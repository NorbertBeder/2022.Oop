package lab11_4;

public interface IExpression {
    public static boolean isOperator(String op) {
        op = op.trim();
        return op.matches("[-+/*]");
    }

    public static double evaluate(String postfixExpression) throws ExpressionException {
        Stack stack = new Stack(10);
        String[] items = postfixExpression.split(" ");
        for (String item : items) {
            item = item.trim();
            if(!isOperator(item)){
                double num;
                try{
                    num = Double.parseDouble(item);
                }catch (NumberFormatException e){
                    throw new ExpressionException("Wrong operand: " + item);
                }
                try{
                    stack.push(num);
                }catch (StackException e){
                    throw new ExpressionException("Wrong postfix expression");
                }

            }else {
                double num1, num2;
                try {
                    num2 = (double) stack.top();
                    stack.pop();
                    num1 = (double) stack.top();
                    stack.pop();

                    switch (item) {
                        case "+" -> stack.push(num1 + num2);

                        case "*" -> stack.push(num1 * num2);

                        case "/" -> stack.push(num2 / num1);

                        case "-" -> stack.push(num2 - num1);
                    }
                }catch (StackException e){
                    throw new ExpressionException("Wrong postfix expression");
                }
            }
        }
        try {
            return (double) stack.top();
        }catch (StackException e){
            throw new ExpressionException("Wrong postfix expression");
        }
    }
}
