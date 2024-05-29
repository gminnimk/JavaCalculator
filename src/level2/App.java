package level2;


//2. Level 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정합니다.
//        - 연산 수행 역할은 Calculator 클래스가 담당합니다.
//        - 연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장됩니다.


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        /* Calculator 인스턴스 생성 */
        Calculator calc = new Calculator();

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
                double result = calc.calculate(num1, num2, operator);
                System.out.println("결과 : " + result);
            } catch(CalculateException e) {
                // 예외 발생시 메시지 출력
                System.out.println(e.getMessage());
            }
            /* 반복문 종료 */
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.next();
            if (exit.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}