package lab11_4;

public class Lab11Main4 {
    public static void main(String[] args) {
        String[] expressions = {
                "1 2 + 3 2 + * ",
                "1 2 + +",
                "1 a +",
                "1 2,3 *",
                "-1 2 3 * +"};
        for (String expr : expressions) {
            try {
                System.out.println("Eval(" + expr + "): " + IExpression.evaluate(expr) + "\n");
            } catch (ExpressionException e) {
                System.out.println("Wrong expression: " + expr );
                System.out.println("\t" + e.getMessage() + "\n");
            }
        }
    }
}
