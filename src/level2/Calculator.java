package level2;

import java.util.ArrayList;
import java.util.List;

// 예외처리 할 Exception 클래스를 생성
// Calculator의 사용자 정의 예외 클래스
class CalculatorException extends Exception {
    public CalculatorException(String message) {
        super(message);
    }
}


// App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지
// 못하도록 수정 (= 캡슐화)

public class Calculator {

    // 연산 결과를 저장하는 컬렉션 타입
    private List<Double> results;

    // Calculator 생성자
    public Calculator() {
        results = new ArrayList<>();
    }


    // 계산 결과 리스트를 반환하는 메서드
    public List<Double> getResults() {
        return new ArrayList<>(results); // 방어적 복사
    }

    // 결과 리스트를 반환하는 Setter 메서드
    public void setResults(List<Double> results) {
        this.results = new ArrayList<>(results);
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


        // getter 메서드 사용
        System.out.println("저장된 결과 출력: " + calculator.getResults());
    }
}