public class testRational {
    public static void main(String[] args) {

        testRational tester = new testRational();

        boolean testPassed = tester.testGCD() && tester.testplus() && tester.testSimpliAtInit()
                && tester.testCompareto();

        if (testPassed) {
            System.out.println("All Test passed: Success!");
        } else {
            System.out.println("Failure");
        }
    }

    public boolean testGCD() {
        return Rational.GCD(-10, -6) == 2 && Rational.GCD(125, 750) == 125;
    }

    public boolean testplus() {
        Rational obj1 = new Rational(13, 5);
        Rational obj2 = new Rational(27, 15);
        Rational res = new Rational(22, 5);
        return Rational.plus(obj1, obj2).equals(res);
    }

    public boolean testSimpliAtInit() {
        Rational obj1 = new Rational(25, 5);
        return obj1.equals(new Rational(5));
    }

    public boolean testCompareto() {
        Rational obj1 = new Rational(30, 2);
        Rational obj2 = new Rational(15, 4);
        System.out.println(obj2);
        return obj2.compareTo(obj1) == -1;
    }
}
