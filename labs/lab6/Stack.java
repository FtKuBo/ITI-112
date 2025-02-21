public interface Stack<E> {

    public abstract boolean isEmpty();

    public abstract E peek();

    public abstract E pop();

    public abstract void clear();

    public abstract void push(E element);
}
