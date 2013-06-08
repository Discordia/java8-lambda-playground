package org.discordia.java8.lambda;

import java.util.function.Function;

/**
 * @author robban
 */
public class LambdaFunction {
    public static void main(String[] args) {

        Function<Integer, Integer> mult2 = x -> x * 2;
        System.out.println("Mult2(5): " + mult2.apply(5));

        Function<Integer, Integer> add2 = x -> x + 2;
        System.out.println("Add2(5): " + add2.apply(5));

        // Composing
        Function<Integer, Integer> add2Mult2 = x -> mult2.apply(add2.apply(x));
        System.out.println("add2Mult2(5): " + add2Mult2.apply(5));
    }
}
