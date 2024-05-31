package level2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력을 받기 위한 구문

        /* Calculator 인스턴스 생성 */
        Calculator calc = new Calculator();



        /* 반복문 시작 */
        while (true) {

            System.out.print("첫 번째 숫자를 입력하세요:");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요:");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0); // operator 변수에 charAt(0)를 이용해서 문자열의 첫 번째 숫자를 끄집어 냄.

            try {
                // 위에서 입력한 숫자를 Calculator 클래스와 연동하여 실질적으로/
                // 계산을 수행하는 코드를 구현.
                // ◆◆◆◆◆ 위 내용에 대한 복습 필요 ◆◆◆◆◆
                calc.calculate(num1, num2, operator); // Calculator 클래스의 인스턴스인 calc에서 calculate 메서드를 가져와 기능 수행
                System.out.println("결과 : " + calc.getResults()); // 기능을 수행 후 결과 출력

            } catch (Exception e) {
                System.out.println(e.getMessage()); // 예외 발생시 예외 메시지 출력
            }


            // 데이터를 삭제할지?
            System.out.println("가장 먼저 저장된 데이터를 삭제하겠습니까? (delete 입력 시 삭제)");
            String delete = sc.next();
            if (delete.equals("delete")) {
                calc.removeResult(); // Calculator에서 삭제 기능이 구현된 메서드를 가져와서 사용.
                System.out.println("가장 먼저 저장된 데이터를 삭제하였습니다.");
            }


            // 조회를 할건지?
            System.out.println("저장된 데이터를 조회 하시겠습니까? (inquiry 입력 시 조회)");
            String inquiry = sc.next();
            if (inquiry.equals("inquiry")) {
                System.out.println("저장된 데이터를 조회하겠습니다.");
                System.out.println("결과 확인 : " + calc.getResults());
            }

            // 더 계산할지?
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.next();
            if (exit.equals("exit")) { //equals를 사용하여 해당 문자열이 입력시 조건문 발동
                System.out.println("프로그램을 종료합니다.");
                break; // break로 프로그램 종료
            }
        }
    }
}