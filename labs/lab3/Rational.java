public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
        this.reduce();
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }

    // getters

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {

        int numi;
        int numi2;
        int denom;

        if (this.denominator != other.denominator) {

            numi = this.numerator * other.denominator;
            numi2 = other.numerator * this.denominator;
            denom = this.denominator * other.denominator;
        }

        else {
            numi = this.numerator;
            numi2 = other.numerator;
            denom = this.denominator;
        }
        Rational sum = new Rational(numi + numi2, denom);
        sum.reduce();
        return sum;

    }

    public static Rational plus(Rational a, Rational b) {

        return a.plus(b);
    }

    public static int GCD(int a, int b) {
        if (a < 0) {
            a = a * -1;
        }
        if (b < 0) {
            b = b * -1;
        }

        while (a != b)
            if (a > b)
                a = a - b;
            else
                b = b - a;
        return a;
    }

    // Transforms this number into its reduced form

    private void reduce() {

        int GCD = gcd(this.numerator, this.denominator);
        this.numerator /= GCD;
        this.denominator /= GCD;
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
        // Note that the loop below, as-is, will time out on negative inputs.
        // The gcd should always be a positive number.
        // Add code here to pre-process the inputs so this doesn't happen.

        if (a < 0) {
            a = a * -1;
        }
        if (b < 0) {
            b = b * -1;
        }

        while (a != b)
            if (a > b)
                a = a - b;
            else
                b = b - a;
        return a;
    }

    public int compareTo(Rational other) {
        double res = this.numerator / this.denominator - other.numerator / other.denominator;

        if (res < 0) {
            return -1;
        }

        else if (res == 0) {
            return 0;
        }

        else {
            return 1;
        }
    }

    public boolean equals(Rational other) {

        return this.numerator == other.numerator && this.denominator == other.denominator;
    }

    public String toString() {
        String result;
        if (denominator == 1) {
            result = "the rational number is " + numerator;
        } else {
            result = "the rational number is " + numerator + "/" + denominator;
        }
        return result;
    }

}