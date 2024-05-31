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
    private List<Double> circleareas;

    // 원의 넓이를 구하기 위한 PI 선언 (static 정적으로)
    private static final double PI = 3.14;


    /* 생성자 수정 */
    // 기본 생성자
    public Calculator() {
        this.results = new ArrayList<>();
        this.circleareas = new ArrayList<>();
    }

    // 초기값을 받는 생성자

    public Calculator(List<Double> initialResults) {
        this.results = new ArrayList<>(initialResults); // 사칙연산 결과 리스트 초기화
        this.circleareas = new ArrayList<>();
    }

    // 결과 리스트를 반환하는 getter 메서드
    public List<Double> getResults() {
        return results;
    }


    // 결과 리스트를 설정하는 Setter 메서드 (옵션, 필요 시 사용)
    public void setResults(List<Double> results) {
        this.results = results;
    }


    // 삭제 기능 메서드
    public void removeResults() {
        if(!results.isEmpty()) {
            results.remove(0);
        } else{
            System.out.println("삭제할 결과가 없습니다.");
        }
    }

    // 원의 넓이 컬렉션 삭제 기능 메서드
    public void removeCircleareas() {
        if(!circleareas.isEmpty()) {
            circleareas.remove(0);
        } else{
            System.out.println("삭제할 결과가 없습니다.");
        }
    }

    // 조회 기능 메서드
    public void inquiryResults() {
        System.out.println("저장된 결과 조회 : " + getResults());
    }

    // 원의 넓이 컬렉션 조회 기능 메서드
    public void inquiryCircleareas() {
        System.out.println("저장된 결과 조회 : " + getCircleareas());
    }

    /* 원의 넓이 저장 필드 Getter, Setter, 조회 메서드 구현 */

    public List<Double> getCircleareas() {
        return circleareas;
    }


    // 옵션
    public void setCircleareas(List<Double> circleareas) {
        this.circleareas = circleareas;
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
    public double calculateCircleArea(double radius) {
        double area = PI * radius * radius;
        circleareas.add(area);
        return area;
    }

}