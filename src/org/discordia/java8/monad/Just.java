package org.discordia.java8.monad;

/**
 * @author robban
 */
public class Just<T> implements Maybe<T> {

    private final T value;

    public Just(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }

    @Override
    public String toString() {
        return "Just{" + "value=" + value + '}';
    }
}
