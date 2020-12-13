package valber.calculator;


import java.util.Locale;

public class Calculation {
    private final double result;
    private final Operator operator;
    private final double operandA;
    private final double operandB;

    private static double calculateResult(Double A, Operator operator, Double B) {
        return switch (operator) {
            case ADD -> A + B;
            case SUB -> A - B;
            case MUL -> A * B;
            case DIV -> A / B;
            default -> 0;
        };

    }

    public Calculation(double A, Operator operator, double B) {
        operandA = A;
        operandB = B;
        this.operator = operator;
        result = calculateResult(A, operator, B);
    }

    public Calculation(double A, String operator, double B) {
        operandA = A;
        operandB = B;
        switch (operator.toLowerCase(Locale.ROOT)) {
            case "add" -> this.operator = Operator.ADD;
            case "sub" -> this.operator = Operator.SUB;
            case "mul" -> this.operator = Operator.MUL;
            case "div" -> this.operator = Operator.DIV;
            default -> this.operator = Operator.ERR;
        }
        result = calculateResult(A, this.operator, B);
    }


    public Operator getOperator() {
        return operator;
    }

    public double getOperandA() {
        return operandA;
    }

    public double getOperandB() {
        return operandB;
    }

    public double getResult() {
        return result;
    }
}
