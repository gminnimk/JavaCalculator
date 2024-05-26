package level1;


/*

JAVA CALULATOR LV1

    - 변수 & 타입 이해하기
    - 연산자 이해하기
    - 제어문 & 반복문 이해하기
    - 배열 & 컬렉션 이해하기


★ 소스 코드를 설명하는 주석은 필수적으로 작성하기

 */

import java.util.Arrays;
import java.util.Scanner; // Scanner를 사용하기 위한 import

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 양의 정수 2개를 전달 받기 위한 Scanner 선언.
        int result = 0; // 사칙연산에 따라 결과값 반환을 위한 변수 선언.

        int max_results = 10; // 하드코딩 방지.
        int[] results = new int[max_results]; // 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성.
        int count = 0; // 연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수를 선언



        while (true) { // 무한 루프를 위한 while 반복문 선언.

            System.out.println("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt(); // num1 변수에 정수 입력받기.


            System.out.println("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt(); // num2 변수에 정수 입력받기.

            System.out.print("사칙연산 기호를 입력하세요: ");
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            char operator = sc.next().charAt(0); // char 타입 operator라는 변수에 입력받은 문자에 첫번째 문자 추출


            // 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력.
            // 제어문을 활용
            if (operator == '+') { // 사칙연산 기호의 변수가 + 일때 result 값 반환
                result = num1 + num2;
            } else if (operator == '-') { // 사칙연산 기호의 변수가 - 일때 result 값 반환
                result = num1 - num2;
            } else if (operator == '*') { // 사칙연산 기호의 변수가 * 일때 result 값 반환
                result = num1 * num2;
            } else if (operator == '/') { // 사칙연산 기호의 변수가 / 일때 result 값 반환
                if (num2 == 0) { // 분모가 0일때 오류 출력.
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    System.out.println("다시 입력하세요.");
                    continue; //continue를 사용함으로써 프로그램을 종료시키지 않고 다시 입력하게끔 설정.
                }
                result = num1 / num2;
            } else { // 사칙연산 기호 외 다른 기호일때 오류 출력.
                System.out.println("기호를 잘못 입력하였습니다.");
            }


            // 결과값 확인.
            System.out.println("결과 : " + result);




            results[count] = result; // 연산의 결과를 배열에 저장
            count ++; // index 증가

            // ▶ 숙지
            // 배열에 들어간 값을 확인하기 위해서는 results 가 아닌 Arrays.toString(results)와 같이 작성
            // Arrays를 사용하기 위해서는 import로 라이브러리를 가져와야 함.
            System.out.println("배열 확인 : " + Arrays.toString(results) + " " + "count : " + count); // 배열에 값이 들어갔는지 확인.



            // exit 문자열 입력시 break를 이용해 무한 루프를 빠져나옴.
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String str = sc.next();
            if (str.equals("exit")) { // equals를 사용해서 이와 같은 문자열과 똑같은 문자를 입력받을시 조건문 실행.
                System.out.println("프로그램을 종료하겠습니다.");
                break;
            }
        }
    }
}
