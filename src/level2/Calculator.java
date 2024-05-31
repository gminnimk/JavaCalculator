/*
💡 학습 목표

- 클래스 & 메서드 이해하기
- 생성자 & 접근 제어자 이해하기
- static & final 이해하기
- 상속(&포함) & 다형성 이해하기
- Exception & 예외처리 이해하기
 */

package level2;

import java.util.ArrayList;
import java.util.List;


// 적합한 Exception 클래스 생성
class CalculatorException extends Exception {
    public CalculatorException(String message) {
        super(message);
    }
}


public class Calculator {


    /* 연산 결과를 저장하는 컬렉션 타입 필드를 외부에서 직접 접근 하지 못하도록 수정*/


    // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
    // ◆◆◆◆◆ 위 내용에 대해 복습 필요 ◆◆◆◆◆
    private List<Double> results;

    // public List<Double> results;
    // 위 결과값을 저장하는 컬렉션은 내부에서만 사용되는 데이터 구조이기 때문에 private으로 선언하는게 올바름
    // 무조건 자료구조 형태라고 private으로 선언하는게 아니라
    // 전체적인 구조를 보았을때 그 필드가 클래스 내부에서만 사용되는 경우에 해당.
    // 이는 필드가 외부에서 직접적인 접근 및 조작을 허용하지 않음을 의미.

    // private 으로 선언하게 되면 => 클래스의 캡슐화를 유지하고, 클래스 간의 의존성을 최소화하여
    // 유연하고 안전한 코드를 작성하는 데 도움이 됨.

    // 따라서, 클래스의 필드를 'private'으로 선언할 때에는 해당 필드가 외부에서 사용될 필요가 없고, 오로지 클래스
    // 내부에서만 필요한 데이터인지를 고려해야함.


    // main 클래스에서 호출하기 위한 메서드 생성
    // Calculator 객체가 생성될 때마다 새로운 ArrayList 가 results 필드에 할당되어 초기화 됨.
    // 이 생성자를 통해 'Calculator' 객체가 생성될 때마다 결과값들을 저장하기 위한 새로운 리스트가 생성되며
    // 이 리스트는 해당 객체의 수명 동안 결과값을 저장하는 데 사용.
    public Calculator() {
        results = new ArrayList<>();
    }


    // App 클래스에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드(= results)에
    // 직접 접근하지 못하도록 수정(=캡슐화)

    // 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현 (Getter 메서드)
    // ★ 주의 ★
    public List<Double> getResults() {
        return new ArrayList<>(results);
    }


    // 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현 (Setter 메서드)
    // setResults() 메서드는 Calculator 클래스의 results 필드에 새로운 결과값 리스트를
    // 설정하기 위해 만들어졌지만, 현재의 코드에서는 이 메서드를 사용하지 않음.

    // 결과값을 저장하는 컬렉션은 객체가 생성될 때 초기화되고, 그 후에는 필요에 따라 추가되는 값을 calculate() 메서드 내에서만 처리합니다.
    // 이런 경우에는 setResults() 메서드는 사용되지 않을 수 있습니다.

    // ★ 주의 ★
    public void setResults(List<Double> results) {
        this.results = new ArrayList<>(results);
    }


    //getter
    // 메소드로 필드값을 가공 후 외부로 전달한다.

    //setter
    // 외부에서 메소드를 통해 데이터에 접근하도록 유도한다.


    public double calculate(int num1, int num2, char operator) throws CalculatorException {


        double result = 0; // 연산 결과를 반환할 변수


        // 사칙 연산 기능을 수행 한 후 결과값을 반환하는 메서드
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            if (num2 == 0) {
                throw new CalculatorException("분모에 0이 들어갈 수 없습니다.");
            }
            result = num1 / num2;
        } else {
            throw new CalculatorException("기호를 잘못 입력하였습니다.");
        }


        // 사칙 연산을 수행했으면 컬렉션 에다가 결과 값 넣어주기.
        results.add(result);
        return result; //결과 반환
    }


    public void removeResult() {

        // 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진
        // 메서드를 구현한 후 App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정
        results.remove(0); // 가장 먼저 저장된 데이터를 삭제.
    }


    public static void main(String[] args) {
    }
}