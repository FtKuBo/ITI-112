public class Geometric extends AbstractSeries {

    private int k;
    double[] serie;

    public Geometric() {
        k = 0;
    }

    public double next() {
        k++;
        serie = new double[k];
        serie[0] = 1;
        for (int i = 1; i < k; i++) {
            serie[i] = 1 / (Math.pow(2, i)) + serie[i - 1];
        }
        return serie[k - 1];
    }
}
