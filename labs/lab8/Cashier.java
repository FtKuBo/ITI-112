public class Cashier {
    private Queue queue;
    private Customer currentCustomer;
    private int totalCustomerWaitTime;
    private int customersServed;
    private int totalItemsServed;

    public Cashier() {
        this.queue = new ArrayQueue<Customer>();
        this.currentCustomer = null;
        this.totalCustomerWaitTime = 0;
        this.customersServed = 0;
        this.totalItemsServed = 0;
    }

    @SuppressWarnings("unchecked")
    public void addCustomer(Customer c) {
        this.queue.enqueue(c);
    }

    public int getQueueSize() {
        return this.queue.size();
    }

    public void serveCustomers(int CurrentTime) {
        if (this.currentCustomer == null) {

            if (!this.queue.isEmpty()) {
                this.currentCustomer = (Customer) this.queue.dequeue();
                this.currentCustomer.serve();
                this.totalItemsServed++;

                if (this.currentCustomer.getNumberOfItems() <= 0) {
                    this.customersServed++;
                    this.totalCustomerWaitTime += CurrentTime - this.currentCustomer.getArrivalTime();
                    this.currentCustomer = null;
                }
            }
        }

        else {
            this.currentCustomer.serve();
            this.totalItemsServed++;
            if (this.currentCustomer.getNumberOfItems() <= 0) {
                this.customersServed++;
                this.totalCustomerWaitTime += CurrentTime - this.currentCustomer.getArrivalTime();
                this.currentCustomer = null;
            }
        }

    }

    public int getTotalCustomerWaitTime() {
        return totalCustomerWaitTime;
    }

    public int getTotalCustomersServed() {
        return customersServed;
    }

    public int getTotalItemsServed() {
        return totalItemsServed;
    }

    @Override
    public String toString() {
        return "The total number of customers served is " + totalCustomerWaitTime
                + "\nThe average number of items per customer was " + customersServed
                + "\nThe average waiting time (in seconds) was " + totalItemsServed;
    }

}
