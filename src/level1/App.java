package level1;


/*

JAVA CALULATOR LV1

    - 변수 & 타입 이해하기
    - 연산자 이해하기
    - 제어문 & 반복문 이해하기
    - 배열 & 컬렉션 이해하기


★ 소스 코드를 설명하는 주석은 필수적으로 작성하기

 */

import java.util.Scanner; // Scanner를 사용하기 위한 import

public class App{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 양의 정수 2개를 전달 받기 위한 Scanner 선언.

        System.out.println("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt(); // num1 변수에 정수 입력받기.

        System.out.println("첫 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt(); // num2 변수에 정수 입력받기.

        // 정상작동을 위한 출력문 확인
        System.out.println("결과 :" + num1 +","+ num2);
    }
}
