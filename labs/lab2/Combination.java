public class Combination {

    int first;
    int second;
    int third;

    // Constructor
    public Combination(int first, int second, int third) {

        this.first = first;
        this.second = second;
        this.third = third;

    }

    // An instance method that compares this object
    // to other.
    // Always check that other is not null, i)
    // an error would occur if you tried to
    // access other.first if other was null, ii)
    // null is a valid argument, the method should
    // simply return false.

    public boolean equals(Combination other) {
        if (other == null) {
            return false;
        }
        return this.first == other.first && this.second == other.second && this.third == other.third;
    }

    // Returns a String representation of this Combination.

    public String toString() {
        // Put your code here and remove the line below
        return this.first + ":" + this.second + ":" + this.third;
    }

}