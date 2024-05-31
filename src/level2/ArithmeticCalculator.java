package level2;

/*
ArithmeticCalculator (사칙연산 계산기) 클래스

        Calculator 클래스를 상속합니다.
        사칙연산(덧셈, 뺄셈, 곱셈, 나눗셈)을 수행하는 기능을 구현합니다.
        calculate(int num1, int num2, char operator) 메서드는 두 개의 정수와 연산자를 받아 해당 연산을 수행하고 결과를 반환합니다.
        inquiryResults() 메서드는 상위 클래스인 Calculator의 추상 메서드를 구현하여 저장된 사칙연산 결과를 조회하고 출력합니다.
 */

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
