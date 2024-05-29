package level2;

import java.util.ArrayList;
import java.util.List;

// 예외처리 할 Exception 클래스를 생성
class CalculatorException extends Exception {
    public CalculatorException(String message) {
        super(message);
    }
}


public class Calculator {

    // 연산 결과를 저장하는 컬렉션 타입
    private List<Double> results;

    public Calculator() {
        results = new ArrayList<>();
    }


    public double calculate(int num1, int num2, char operator) throws CalculatorException {
        double result = 0;

        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            if (num2 == 0) { // 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘 못 들어온 경우
                // 미리 생성핸놓은 Exception 클래스에 throw 처리 (매개변수로 해당 오류 내용을 전달)
                throw new CalculatorException("분모에 0이 들어갈 수 없습니다.");
            }
            result = num1 / num2;
        } else {
            throw new CalculatorException("잘못된 기호를 입력하였습니다.");
        }
        results.add(result); // results 라는 컬렉션에  위 result 결과값들을 추가함.
        return result; // 결과값을 새로 반환
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(); // 테스트를 위한 인스턴스 객체 생성


        // 정상작동을 위한 예제문 출력
        try {
            System.out.println("3 + 2 =" + calculator.calculate(3, 2, '+'));
            System.out.println("3 - 2 =" + calculator.calculate(3, 2, '-'));
            System.out.println("3 * 2 =" + calculator.calculate(3, 2, '*'));
            System.out.println("3 / 2 =" + calculator.calculate(3, 2, '/'));

        } catch (CalculatorException e) { // 예외 처리
            System.out.println("오류 메시지. " + e.getMessage());
        }

        System.out.println("저장된 결과 출력: " + calculator.results);
    }
}