import java.util.Random;

public class Customer {

    private int arrivalTime;
    private int intialNumberOfItems;
    private int numberOfItems;
    private static final int MAX_NUM_ITEMS = 20;

    /**
     * @param arrivalTime
     */
    public Customer(int arrivalTime) {
        Random generator = new Random();
        this.intialNumberOfItems = generator.nextInt(MAX_NUM_ITEMS - 1) + 1;
        this.numberOfItems = intialNumberOfItems;
        this.arrivalTime = arrivalTime;
    }

    public void serve() {
        if (this.numberOfItems > 0) {
            this.numberOfItems--;
        }
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getNumberOfServedItems() {
        return this.intialNumberOfItems - this.numberOfItems;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

}
