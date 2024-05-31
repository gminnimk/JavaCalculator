package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        /* Calculator 인스턴스 생성 */
        Calculator calc = new Calculator();

        Scanner sc = new Scanner(System.in);

        /* 반복문 시작 */
        /* 사칙연산을 진행할지 원의 너비를 구할지 선택 구현 */
        while (true) {
            System.out.println("원하는 기능을 선택하세요:");
            System.out.println("1. 사칙연산");
            System.out.println("2. 원의 넓이 계산");
            String choice = sc.next();

            if (choice.equals("1")) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                try {
                    double result = calc.calculate(num1, num2, operator);
                    System.out.println("결과: " + result);
                    System.out.println("현재까지의 결과 리스트: " + calc.getResults());
                } catch (CalculatorException e) {
                    System.out.println("오류 발생: " + e.getMessage());
                }


                /* 원의 넓이를 구하는 경우 반지름을 입력받아 원의 넓이를 구한 후 출력*/
                /* 원의 넓이 저장 */
                /* 저장된 원의 넓이 값들 바로 전체 조회 */
            } else if (choice.equals("2")) {
                System.out.println("반지름을 입력하세요: ");
                double radius = sc.nextDouble();
                double area = calc.calculateCircleArea(radius);
                System.out.println("원의 넓이: " + area);
                System.out.println("현재까지의 원의 넓이 결과 리스트: " + calc.getCircleAreas());
            } else {
                System.out.println("잘못된 선택입니다.");
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String input = sc.next();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }


            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");

        }
    }
}