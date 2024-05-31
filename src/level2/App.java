package level2;

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

            try {
                // 위에서 입력한 숫자를 Calculator 클래스와 연동하여 실질적으로/
                // 계산을 수행하는 코드를 구현.
                // ◆◆◆◆◆ 위 내용에 대한 복습 필요 ◆◆◆◆◆
                double result = calc.calculate(num1, num2, operator);
                System.out.println("결과 : " + calc.getResults());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");


            /* 반복문 종료 */
            String exit = sc.next();
            if (exit.equals("exit")) { //equals를 사용하여 해당 문자열이 입력시 조건문 발동
                System.out.println("프로그램을 종료합니다.");
                break; // break로 프로그램 종료
            }
        }
    }
}