package level2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 사칙연산");
            System.out.println("2. 원의 넓이 계산");
            System.out.println("3. 사칙연산 결과 삭제");
            System.out.println("4. 원의 넓이 결과 삭제");
            System.out.println("5. 사칙연산 결과 조회");
            System.out.println("6. 원의 넓이 결과 조회");
            System.out.println("exit: 프로그램 종료");
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
            } else if (choice.equals("2")) {
                System.out.println("원의 반지름을 입력해주세요: ");
                double radius = sc.nextDouble();
                double area = calc.calculateCircleArea(radius);
                System.out.println("원의 넓이: " + area);
                System.out.println("현재까지의 원의 넓이 결과 리스트: " + calc.getCircleareas());
            } else if (choice.equals("3")) {
                calc.removeResults();
                System.out.println("첫 번째 사칙연산 결과가 삭제되었습니다.");
                System.out.println("현재까지의 사칙연산 결과 리스트: " + calc.getResults());
            } else if (choice.equals("4")) {
                calc.removeCircleareas();
                System.out.println("첫 번째 원의 넓이 결과가 삭제되었습니다.");
                System.out.println("현재까지의 원의 넓이 결과 리스트: " + calc.getCircleareas());
            } else if (choice.equals("5")) {
                calc.inquiryResults();
            } else if (choice.equals("6")) {
                calc.inquiryCircleareas();
            } else if (choice.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }

        sc.close();
    }
}
