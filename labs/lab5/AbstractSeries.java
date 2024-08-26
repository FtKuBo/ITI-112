public abstract class AbstractSeries implements Series {

    public double[] take(int k) {
        double[] partialSum = new double[k];
        for (int i = 1; i <= k; i++) {
            partialSum[i - 1] = next();
        }
        return partialSum;

    }

}