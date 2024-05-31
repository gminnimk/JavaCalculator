package level2;


import java.util.ArrayList;
import java.util.List;


class CalculatorException extends Exception {
    public CalculatorException(String message) {
        super(message);
    }
}

public class Calculator {
    /* static, final 활용 */
    /* 원의 넓이 결과를 저장하는 컬렉션 타입의 필드 선언 및 생성 */
    private List<Double> results;
    private List<Double> circleAreas;

    private static final double PI = 3.14;


    /* 생성자 수정 */
    // 기본 생성자
    public Calculator() {
        this.results = new ArrayList<>();
        this.circleAreas = new ArrayList<>();
    }

    // 초기값을 받는 생성자

    public Calculator(List<Double> initialResults) {
        this.results = new ArrayList<>(initialResults); // 사칙연산 결과 리스트 초기화
        this.circleAreas = new ArrayList<>(); // 원의 넓이 결과 리스트 빈 리스트로 초기화
    }

    // 결과 리스트를 반환하는 getter 메서드
    public List<Double> getResults() {
        return results;
    }

    // 결과 리스트를 설정하는 Setter 메서드 (옵션, 필요 시 사용)
    public void setResults(List<Double> results) {
        this.results = results;
    }

    // 원의 넓이 결과 리스트를 반환하는 Getter 메서드
    public List<Double> getCircleAreas() {
        return circleAreas;
    }

    // 원의 넓이 결과 리스트를 설정하는 Setter 메서드 (옵션, 필요 시 사용)
    public void setCircleAreas(List<Double> circleAreas) {
        this.circleAreas = circleAreas;
    }

    // 사칙연산 메서드
    public double calculate(int num1, int num2, char operator) throws CalculatorException {
        double result = 0;

        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            if (num2 == 0) {
                throw new CalculatorException("분모에 0이 들어갈 수 없습니다.");
            }
            result = num1 / num2;
        } else {
            throw new CalculatorException("기호를 잘못 입력하였습니다.");
        }

        results.add(result);
        return result;
    }


    /* 원의 넓이를 구하는 메서드 선언*/
    // 원의 넓이 계산 메서드
    public double calculateCircleArea(double radius) {
        /* 원의 넓이 계산 구현 */
        double area = PI * radius * radius;
        circleAreas.add(area);
        return area;
    }
    /* 원의 넓이 저장 필드 Getter, Setter, 조회 메서드 구현 */
}