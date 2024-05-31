package level2;

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
