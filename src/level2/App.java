package level2;


// Level 2 - 6
// App 클래스 수정된 점
// Calculator 인스턴스를 생성할 때 초기 결과 리스트를 전달하는 예제를 추가
// initialResults 리스틀르 생성하고, 이를 사용하여 Calculator 객체를 초기화.
// 나머지는 유지

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // 초기 연산 결과 리스트 생성
        List<Double> initialResults = new ArrayList<>();
        initialResults.add(10.0);
        initialResults.add(20.0);
        /* Calculator 인스턴스 생성 */
        Calculator calc = new Calculator(initialResults);

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
            } catch (CalculateException e) {
                // 예외 발생시 메시지 출력
                System.out.println(e.getMessage());
            }


            // 삭제 출력문 추가
            System.out.println("결과를 삭제하시겠습니까? (yes 입력 시 삭제): ");
            String yes = sc.next();
            if (yes.equals("yes")) {
                calc.removeResults();
                System.out.println("첫 번째 결과가 삭제되었습니다.");
            }

            // 조회 출력문 추가
            System.out.println("결과를 조회하시겠습니까? (inquiry 입력 시 조회): ");
            String inquiry = sc.next();
            if (inquiry.equals("inquiry")) {
                calc.inquiryResults();
                System.out.println("저장된 결과를 조회하였습니다.");
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