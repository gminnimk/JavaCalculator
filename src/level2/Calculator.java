
// Level 2-6
// Calculator 클래스 수정된 점
// 기본 생성자 Calculator() 를 유지하면서 초기 결과 리스트를 받을 수 있는 생성자
// Calculator(List<Double> initialResults)를 추가.
// 이 생성자는 외부에서 초기 결과 리스트를 전달받아 'results' 필드를 초기화

// results 필드의 초기화를 생성자를 통해 이루어지도록 수정함.

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


    // 기본 생성자
    // results 필드를 빈 ArrayList로 초기화
    // Calculator 객체가 기본 생성자를 통해 생설될 때 호출 됨.
    public Calculator() {
        this.results = new ArrayList<>(); // results 필드를 빈 ArrayList 로 초기화
    }


    // 초기값을 받는 생성자
    // initialResults 리스트의 내용을 복사하여 results 필드를 초기화
    // Calculator 객체가 초기 결과값 리스트를 전달받아 생성될 때 호출.
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
    // 결과값을 저장하는 컬렉션은 객체가 생성될 때 초기화되고, 그 후에는 필요에 따라 추가되는 값을 calculate() 메서드 내에서만 처리합니다.
    // 이런 경우에는 setResults() 메서드는 사용 X
    // 만약 결과값 리스트를 외부에서 설정해야 하는 경우나 다른 용도로 사용해야 한다면 setResults() 메서드가 필요할 수 있습니다.
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
    }
}