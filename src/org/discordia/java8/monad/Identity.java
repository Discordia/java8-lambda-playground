package org.discordia.java8.monad;

import java.util.function.Function;

/**
 * @author robban
 */
public class Identity<T> {

    private final T value;

    public Identity(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }

    @SuppressWarnings("unchecked")
    public <T,B> Identity<B> bind(Function<T, Identity<B>> function) {
        return function.apply((T) this.value());
    }

    public static <T> Identity<T> toIdentity(T value) {
        return new Identity<>(value);
    }

    @Override
    public String toString() {
        return "Identity{" + "value=" + value + '}';
    }
}
