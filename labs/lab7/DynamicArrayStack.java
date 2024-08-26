import java.util.EmptyStackException;

public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems; // Used to store the elements of this ArrayStack
    private int top; // Designates the first free cell
    private static final int DEFAULT_INC = 25; // Used to store default increment / decrement

    @SuppressWarnings("unchecked")

    // Constructor
    public DynamicArrayStack(int capacity) {
        if (capacity < DEFAULT_INC) {
            this.elems = (E[]) new Object[DEFAULT_INC];
        } else {
            this.elems = (E[]) new Object[capacity];
        }
        this.top = 0;
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return (top == 0);
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return elems[top - 1];
    }

    @SuppressWarnings("unchecked")

    // Removes and returns the top element of this stack
    public E pop() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        E poped = this.elems[this.top - 1];
        this.elems[--this.top] = null;

        if (this.top <= DEFAULT_INC) {
            E[] replace = (E[]) new Object[DEFAULT_INC];
            for (int i = 0; i < this.top - 1; i++) {
                replace[i] = this.elems[i];
            }
            this.elems = replace;
        }

        return poped;

    }

    @SuppressWarnings("unchecked")

    // Puts the element onto the top of this stack.
    public void push(E element) {
        this.elems[top++] = element;

        if (this.top >= this.getCapacity()) {
            E[] replace = (E[]) new Object[this.getCapacity() + DEFAULT_INC];
            for (int i = 0; i < this.getCapacity(); i++) {
                replace[i] = this.elems[i];
            }
            this.elems = replace;
        }

    }

    @SuppressWarnings("unchecked")

    public void clear() {
        this.elems = (E[]) new Object[DEFAULT_INC];
        this.top = 0;
    }

}