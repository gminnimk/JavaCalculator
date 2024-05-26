package level1;


/*

JAVA CALULATOR LV1

    - 변수 & 타입 이해하기
    - 연산자 이해하기
    - 제어문 & 반복문 이해하기
    - 배열 & 컬렉션 이해하기

소스 코드를 설명하는 주석은 필수적으로 작성하기

 */


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성합니다. */
        /* 연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수를 선언 */
        final int max_results = 10;  // 연산 결과를 저장할 수 있는 최대 갯수
        int[] arrays = new int[max_results];
        int count = 0;

        int result = 0;


        while (true) { // 반복문을 사용해서 무한 루프

            System.out.println("첫 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            // int 타입의 num1 변수 선언 후 sc.nextInt()로 정수를 입력받게 설정.
            int num1 = sc.nextInt();

            System.out.println("두 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            // int 타입의 num2 변수 선언 후 sc.nextInt()로 정수를 입력받게 설정.
            int num2 = sc.nextInt();


            System.out.println("사칙연산 기호를 입력하세요: ");
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            // char 타입의 operator 라는 변수를 선언
            // sc.next().charAt(0) => 스캐너로 문자열을 입력받고 charAt(0)를 통해 처음 문자를 추출.
            char operator = sc.next().charAt(0);


            // 조건문을 활용해서 operator가 각 기호를 가질때 result 값을 설정해줌
            if (operator == '+') {
                result = num1 + num2;
            } else if (operator == '-') {
                result = num1 - num2;
            } else if (operator == '*') {
                result = num1 * num2;
            } else if (operator == '/') {
                if (num2 == 0) { // 두 번째 입력된 값이 0일때 오류 발생
                    System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                }
                result = num1 / num2;
            } else {    // 사칙연산에서 벗어난 기호는 따로 처리
                System.out.println("기호를 잘못 입력하였습니다.");
            }

            // exit 문자열 입력시 무한 루프에서 벗어남.

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String str = sc.next();
            if (str.equals("exit")) {
                break;
            }

            // 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력
            // 결과 확인하기 위한 출력문
            System.out.println("결과 : " + result);


            /* 연산의 결과를 배열에 저장합니다. */
            /* index를 증가 시킵니다. */
            arrays[count] =+ result; // 연산의 결과를 배열에 저장
            count++; // index 증가



        }
    }
}

