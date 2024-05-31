package level2;


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
