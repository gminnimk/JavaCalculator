package level2;


//2. Level 1에서 구현한 level1.App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정합니다.
//        - 연산 수행 역할은 Calculator 클래스가 담당합니다.
//        - 연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장됩니다.
//    - 소스 코드 수정 후에도 수정 전의 기능들이 반드시 똑같이 동작해야합니다.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        /* Calculator 인스턴스 생성 */
        Calculator calculate = new Calculator();

        Scanner sc = new Scanner(System.in);



        /* 반복문 시작 */
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요:");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요:");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);


            //        - 연산 수행 역할은 Calculator 클래스가 담당합니다.
            //        - 연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장됩니다.

            /* 위 요구사항에 맞게 소스 코드 수정 */

            try {
                //예외발생할 가능성이 있는 문장을 작성
                double result = calculate.calculate(num1, num2, operator); // Calculator 클래스에서 계산 수행
                System.out.println("결과: " + result);
            } catch (CalculatorException e) {
                //예외발생시 throw
                System.out.println("오류: " + e.getMessage());
            }


            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)"); // 반복문 탈출을 할건지에 대한 출력문
            String exit = sc.next(); // 문자열 입력받기
            if (exit.equals("exit")) { // eqauls 를 사용해서 exit 문자열과 똑같을 시 아래 조건문 실행
                System.out.println("프로그램을 종료합니다."); // 종료를 알리는 출력문
                break; // 반복문 탈출
            }
        }
    }
}