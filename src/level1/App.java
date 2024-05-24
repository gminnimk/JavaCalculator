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


        // 결과 확인하기 위한 출력문
        System.out.println("결과 :" + num1 + " " + num2 + " " + operator);
    }
}

