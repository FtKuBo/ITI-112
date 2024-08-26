import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return elems.length;
    }

    public Dictionary() {
        this.elems = new Pair[INITIAL_CAPACITY];
        this.count = 0;
    }

    @Override
    public void put(String key, Integer value) throws NullPointerException {

        if (key == null || value == null) {
            throw new NullPointerException();
        }

        this.elems[count++] = new Pair(key, value);
        if (this.getCount() >= this.getCapacity()) {
            this.increaseCapacity();
        }
    }

    private void increaseCapacity() {
        Pair[] replace = new Pair[this.getCapacity() + INCREMENT];
        for (int i = 0; i < this.getCount(); i++) {
            replace[i] = this.elems[i];
        }
        this.elems = replace;
    }

    @Override
    public boolean contains(String key) throws NullPointerException {
        if (key == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.getCount(); i++) {
            if (this.elems[i].getKey() == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer get(String key) throws NullPointerException, NoSuchElementException {
        if (key == null) {
            throw new NullPointerException();
        }
        for (int i = this.getCount() - 1; i >= 0; i--) {
            if (this.elems[i].getKey() == key) {
                return this.elems[i].getValue();
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public void replace(String key, Integer value) throws NullPointerException, NoSuchElementException {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        if (!this.contains(key)) {
            throw new NoSuchElementException();
        }
        for (int i = 0; i < this.getCount(); i++) {
            if (this.elems[i].getKey() == key) {
                this.elems[i].setValue(value);
            }
        }
    }

    @Override
    public Integer remove(String key) throws NullPointerException, NoSuchElementException {
        if (key == null) {
            throw new NullPointerException();
        }
        if (!(this.contains(key))) {
            throw new NoSuchElementException();
        }
        Pair[] replace = new Pair[this.getCapacity()];
        Integer removed = null;
        int sizeArray = this.getCount();
        while (this.getCount() > 0) {
            if (this.elems[this.count - 1].getKey() == key) {
                removed = this.elems[this.count - 1].getValue();
                this.elems[--this.count] = null;
                int stopLoop = this.getCount();
                for (int i = sizeArray - 2; i >= stopLoop; i--) {
                    this.elems[i] = replace[i + 1];
                    this.count++;
                }
                break;
            }
            replace[this.count - 1] = this.elems[this.count - 1];
            this.elems[--this.count] = null;

        }

        return removed;
    }

    @Override
    public String toString() {
        String res;
        res = "Dictionary: {elems = [";
        for (int i = count - 1; i >= 0; i--) {
            res += elems[i];
            if (i > 0) {
                res += ", ";
            }
        }
        return res + "]}";
    }

}