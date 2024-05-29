//1. 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/) 기능을 수행한 후 결과 값을 반환하는 메서드와 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성합니다.
//    - 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘 못 들어온 경우 적합한 Exception 클래스를 생성하여 throw 합니다. (매개변수로 해당 오류 내용을 전달합니다.)

package level2;

import java.util.ArrayList;
import java.util.List;

// 아래서 말한 Exception에서 상속받은 CalculateException 클래스를 생성
// 이 클래스는 입력받은 예외 메시지를 처리함.
class CalculateException extends Exception {
    public CalculateException(String message) {
        super(message);
    }
}


public class Calculator {

    // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
    // ★ 컬렉션 선언 시 주의 ★
    private List<Double> results;


    // main 클래스에서 호출하기 위한 메서드 생성
    // 생성자 : results 리스트를 초기화 (와부애서 초기값을 받을 수 있도록 수정)
    public Calculator() {
        this.results = new ArrayList<>();
    }

    public Calculator(List<Double> initialResults) {
        this.results = new ArrayList<>(initialResults);
    }






    // (1). 나눗셈에서 분모에 0이 들어오는 경우
    // (2). 연산자 기호가 잘 못 들어온 경우
    // => 적합한 Exception 클래스를 생성하여 throw을 처리 해야함.
    // 그러기 위해서 Exception 클래스를 새로 생성

    public double calculate(int num1, int num2, char operator) throws CalculateException {

        double result = 0; // 결과를 나타내기 위한 변수 선언

        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            // 분모가 0일시 throw 처리
            if (num2 == 0) {
                throw new CalculateException("분모에 0이 들어갈 수 없습니다.");
            }
            result = num1 / num2;
        } else {
            // 사칙연산 기호 외 다른 기호를 입력시 throw 처리.
            throw new CalculateException("사칙연산 기호를 잘못 입력하였습니다");
        }
        results.add(result); // results 라는 컬렉션에 result 값들을 추가
        return result;
    }

    // App 클래스에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드(= results)에
    // 직접 접근하지 못하도록 수정(=캡슐화)

    // 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현 (Getter 메서드)
    // ★ 주의 ★
    public List<Double> getResults() {
        return new ArrayList<>(results); // 방어적 복사
    }


    // 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현 (Setter 메서드)
    // 외부에서 results 리스트를 수정할 수 있게 함.
    // ★ 주의 ★
    public void setResults(List<Double> results) {
        this.results = new ArrayList<>(results); // 방어적 복사
    }


    // 삭제를 위한 메서드
    public void removeResults() {
        if (!results.isEmpty()) {
            results.remove(0);
        } else {
            System.out.println("삭제할 결과가 없습니다.");
        }
    }


    // 조회를 위한 메서드
    public void inquiryResults() {
        System.out.println("저장된 결과 : " + getResults());
    }


    // 양의 정수 2개 & 연산 기호를 매개변수로 받아 사칙연산 기능 수행 후
    // 결과 값을 반환하는 메서드와 연산 결과를 저장


    public static void main(String[] args) {



        // Calculator 인스턴스 생성 (초기 결과 리스트를 전달)
        Calculator calculator = new Calculator();

        // 위 로직이 잘 수행이 되는지 확인하기 위한 출력문 생성


        try {
            System.out.println("3 + 4 = " + calculator.calculate(3, 4, '+'));
            System.out.println("3 - 4 = " + calculator.calculate(3, 4, '-'));
            System.out.println("3 * 4 = " + calculator.calculate(3, 4, '*'));
            System.out.println("3 / 4 = " + calculator.calculate(3, 4, '/'));


        } catch (CalculateException e) {
            System.out.println("오류 : " + e.getMessage());
        }

        System.out.println("저장된 결과 출력 :" + calculator.getResults());

    }
}