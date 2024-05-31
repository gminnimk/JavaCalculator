package level2;


/*
Calculator (계산기) 클래스

        추상 클래스로, 사칙연산 및 원의 관련된 계산에 공통적으로 필요한 기능과 속성을 정의합니다.
        PI 상수를 정의하여 원의 넓이 계산에 활용됩니다.
        results 필드는 계산 결과를 저장하는데 사용됩니다.
        removeResult(int index) 메서드는 특정 인덱스의 계산 결과를 제거합니다.
        inquiryResults() 메서드는 저장된 계산 결과를 조회하여 출력합니다. 이 메서드는 하위 클래스에서 구현되어야 합니다.
 */



import java.util.List;

public abstract class Calculator {
    public static final double PI = 3.14;

    private final List<Double> results;

    public Calculator(List<Double> results) {
        this.results = results;
    }

    public void removeResult(int index) {
        this.results.remove(index);
    }

    abstract void inquiryResults();

    public List<Double> getResults() {
        return results;
    }
}
