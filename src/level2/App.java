package level2;

/*
App (애플리케이션) 클래스

        주어진 문제에서는 애플리케이션의 진입점입니다.
        main 메서드에서는 사용자에게 사칙연산 또는 원의 넓이 계산을 선택하도록 안내하고, 사용자의 입력을 받아 각각의 계산기 클래스를 사용하여 계산을 수행합니다.
        계산 결과는 해당 계산기의 결과 리스트에 저장되고, 사용자가 원하는 경우 결과를 조회할 수 있습니다.
        사용자가 종료를 선택할 때까지 반복하여 계산을 수행합니다.
 */

import java.util.*;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(new ArrayList<>());
        CircleCalculator circleCalculator = new CircleCalculator(new ArrayList<>());

        do {

            System.out.println("어떤 계산을 하시겠습니가? (1: 사칙연산, 2: 원의 넚이)");
            int choice = sc.nextInt();

            if(choice == 1) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: "); // +, -, *, /
                /* charAt(idx) : charAt 메서드는 매개변수로 char 타입으로 반환 하고자하는 문자열의 위치(index)를 받는다. */
                char operator = sc.next().charAt(0);

                double result = arithmeticCalculator.calculate(num1, num2, operator);
                arithmeticCalculator.getResults().add(result);

                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                if (Objects.equals(sc.next(), "remove")) {
                    arithmeticCalculator.removeResult(0);
                }

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                if (Objects.equals(sc.next(), "inquiry")) {
                    arithmeticCalculator.inquiryResults();
                }
            } else {
                System.out.println("원의 반지름을 입력하세요: ");
                int radius = sc.nextInt();

                double area = circleCalculator.calculate(radius);
                circleCalculator.getResults().add(area);
                System.out.println("반지름이 " + radius + "인 원의 넓이는 : " + area);

                System.out.println("저장된 원의 넓이 전체 조회: ");
                circleCalculator.inquiryResults();
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        } while (!sc.next().equals("exit"));

    }
}
