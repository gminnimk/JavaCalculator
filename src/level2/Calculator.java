package level2;

import java.util.ArrayList;
import java.util.List;


// 적합한 Exception 클래스를 생성!
// 사용자 정의 예외 클래스로, 오류 메시지를 생성자에서 받아 상위 Exception 클래스에 전달!
class CalculatorException extends Exception {
    public CalculatorException(String message) { // 전달받은 메시지를 출력할 생성자
        super(message); // 상속 받은 부모의 메시지 출력
    }
}


// 'results' 필드는 사칙연산 결과를 저장하는 리스트로 'ArrayList'로 초기화
// 'calculate' 메서드는 입력받은 두 정수와 연산자에 따라 사칙연산을 수행하고, 결과를 리스트에 저장하여, 예외 상황을 처리!


public class Calculator {
    // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
    private List<Double> results;

    public Calculator() {
        results = new ArrayList<>();
    }

    // 양의 정수 2개와 연산 기호를 매개변수로 받아 사칙연산 기능을 수행
    // 결과 값을 반환하는 메서드
    // 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘 못 들어온 경우
    // 적합한 Exception 클래스를 생성하여 throw 하기. (매개변수로 해당 오류 내용을 전달)
    public double calculate(int num1, int num2, char operator) throws CalculatorException {
        double result; // 결과 값을 저장할 변수 선언.

        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            if (num2 == 0) {
                throw new CalculatorException("분모에 0이 들어갈 수 없습니다."); // num2가 0일때 throw
            }
            result = num1 / num2;
        } else {
            throw new CalculatorException("잘못된 연산 기호를 입력하였습니다." + operator); // 그 밖의 기호일때 throw
        }
        results.add(result); // results 컬렉션에 result 값을 넣어 줌.
        return result; // result 값을 반환함.
    }


    // 'Calculator' 객체를 생성하고 몇 가지 예제 연산을 수행
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            // 몇 가지 예제 연산 수행
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
        System.out.println("저장된 결과들: " + calculator.results);
    }
}






