package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    // 필드 캡슐화 : results 리스트를 private로 설정하여 직접 접근을 막음
    private List<Double> results;

    // Calculator 생성자
    public Calculator() {
        results = new ArrayList<>();
    }


    // 계산 결과 리스트를 반환하는 Getter 메서드
    // getResults() 를 추가하여 result 리스트에 간접적으로 접근할 수 있게 함.
    // 방어적 복사를 사용해서 외부에서 리스트를 변경할 수 없도록 함.
    // 이 방법은 Calculator 클래스의 필드에 직접 접근하지 않고, 메서드를 통해 안전하게 접근하는 방법.
    public List<Double> getResults() {
        return new ArrayList<>(results); // 방어적 복사
    }

    // 결과 리스트를 반환하는 Setter 메서드
    // setResults(List<Double> results) 를 추가해서 외부에서 'results' 리스트를 수정할 수 없게 함.
    // 방어적 복사를 사용하여 내부 리스트가 외부의 리스트 변경에 영향을 받지 않도록.
    // 이 방법은 Calculator 클래스의 필드에 직접 접근하지 않고, 메서드를 통해 안전하게 접근하는 방법.
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


    // removeResult 메서드 추가
    // 리스트에서 가장 먼저 저장된 데이터를 삭제
    // 리스트가 비어있을 경우 메시지를 출력.
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        } else {
            System.out.println("삭제할 결과가 없습니다.");
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(); // 테스트를 위한 인스턴스 객체 생성
        Scanner sc =new Scanner(System.in);
        // 정상작동을 위한 예제문 출력
        try {
            System.out.println("3 + 2 =" + calculator.calculate(3, 2, '+'));
            System.out.println("3 - 2 =" + calculator.calculate(3, 2, '-'));
            System.out.println("3 * 2 =" + calculator.calculate(3, 2, '*'));
            System.out.println("3 / 2 =" + calculator.calculate(3, 2, '/'));

        } catch (CalculatorException e) { // 예외 처리
            System.out.println("오류 메시지. " + e.getMessage());
        }

        // 연산 결과 리스트 출력
        // getter 메서드 사용
        System.out.println("저장된 결과 출력: " + calculator.getResults());



    }
}