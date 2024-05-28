package level2;

import java.util.ArrayList;
import java.util.List;

// 사칙연산 오류를 처리하기 위한 사용자 정의 예외 클래스
class CalculatorException extends Exception {
    public CalculatorException(String message) {
        super(message);
    }
}

// 사칙연산을 수행하고 결과를 저장하는 Calculator 클래스
public class Calculator {
    // 연산 결과를 저장하는 리스트
    private List<Double> results;

    // 생성자
    public Calculator() {
        results = new ArrayList<>();
    }

    // 사칙연산 메서드
    public double calculate(int num1, int num2, char operator) throws CalculatorException {
        double result;
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
                // 나눗셈에서 분모가 0인 경우 예외를 발생시킴
                if (num2 == 0) {
                    throw new CalculatorException("분모가 0일 수 없습니다.");
                }
                result = (double) num1 / num2;
                break;
            default:
                // 잘못된 연산자 기호인 경우 예외를 발생시킴
                throw new CalculatorException("잘못된 연산자입니다: " + operator);
        }
        // 결과를 리스트에 저장
        results.add(result);
        return result;
    }

    // 저장된 모든 결과를 반환하는 메서드
    public List<Double> getResults() {
        return results;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            // 확인을 위한 몇 가지 예제 연산 수행
            System.out.println("3 + 2 = " + calculator.calculate(3, 2, '+'));
            System.out.println("3 - 2 = " + calculator.calculate(3, 2, '-'));
            System.out.println("3 * 2 = " + calculator.calculate(3, 2, '*'));
            System.out.println("3 / 2 = " + calculator.calculate(3, 2, '/'));
            // 예외 발생 예제
            // System.out.println("3 / 0 = " + calculator.calculate(3, 0, '/'));
            // System.out.println("3 $ 2 = " + calculator.calculate(3, 2, '$'));
        } catch (CalculatorException e) {
            // 예외 메시지를 출력
            System.out.println("오류: " + e.getMessage());
        }

        // 저장된 모든 결과 출력
        System.out.println("저장된 결과들: " + calculator.getResults());
    }
}