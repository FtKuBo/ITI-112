public class Arithmetic extends AbstractSeries {

    private int k;
    double[] serie;

    public Arithmetic() {
        k = 0;
    }

    public double next() {
        k++;
        serie = new double[k];
        serie[0] = 1;
        for (int i = 1; i < k; i++) {
            serie[i] = i + 1 + serie[i - 1];
        }
        return serie[k - 1];
    }
}
