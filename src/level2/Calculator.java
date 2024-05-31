/*
💡 학습 목표

- 클래스 & 메서드 이해하기
- 생성자 & 접근 제어자 이해하기
- static & final 이해하기
- 상속(&포함) & 다형성 이해하기
- Exception & 예외처리 이해하기
 */

package level2;

import java.util.List;



// 적합한 Exception 클래스 생성
class CalculatorException extends Exception {
    public CalculatorException(String message) {
        super(message);
    }
}


public class Calculator {


    // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
    // ◆◆◆◆◆ 위 내용에 대해 복습 필요 ◆◆◆◆◆
    public List<Double> results;


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

    public static void main (String[]args){
    }
}