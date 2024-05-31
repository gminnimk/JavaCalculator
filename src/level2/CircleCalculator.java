package level2;

/*
CircleCalculator (원의 계산기) 클래스

Calculator 클래스를 상속합니다.
원의 넓이를 계산하는 기능을 구현합니다.
calculate(int radius) 메서드는 반지름을 받아 원의 넓이를 계산하고 반환합니다.
inquiryResults() 메서드는 상위 클래스인 Calculator의 추상 메서드를 구현하여 저장된 원의 넓이 결과를 조회하고 출력합니다.
 */


import java.util.List;

public class CircleCalculator extends Calculator {

    public CircleCalculator(List<Double> results) {
        super(results);
    }

    /**
     * 원의 넓이를 구하는 메서드
     * @param radius : 원의 반지름
     * @return 원의 넓이
     */
    public double calculate(int radius) {
//        Math.PI
        return PI * radius * radius;
    }

    @Override
    public void inquiryResults() {
        for (Double circleResult : super.getResults()) {
            System.out.println("원의 넚이 = " + circleResult);
        }
    }

}
