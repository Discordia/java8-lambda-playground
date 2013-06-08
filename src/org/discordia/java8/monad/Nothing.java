package org.discordia.java8.monad;

/**
 * @author robban
 */
public class Nothing<T> implements Maybe<T> {

    public String toString() {
        return "Nothing";
    }
}
