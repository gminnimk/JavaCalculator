package level2;

import java.util.List;

public class ArithmeticCalculator extends Calculator {

    public ArithmeticCalculator(List<Double> results) {
        super(results);
    }

    public double calculate(int num1, int num2, char operator) {
        int result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                break;
            default:
                throw new UnsupportedOperationException("올바른 선택이 아닙니다.");
        }

        return result;
    }

    @Override
    public void inquiryResults() {
        for (Double result : super.getResults()) {
            System.out.println("연산 결과 = " + result);
        }
    }
}
