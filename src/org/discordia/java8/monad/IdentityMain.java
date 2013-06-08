package org.discordia.java8.monad;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.Date;
import java.util.function.Function;

import static org.discordia.java8.monad.Identity.toIdentity;

/**
 * This is basically an implementation fo this blog post (that uses C#) in Java 8:
 * http://mikehadlow.blogspot.se/2011/01/monads-in-c-3-creating-our-first-monad.html
 *
 * @author robban
 */
public class IdentityMain {

    public static void main(String[] args) {

        // Simple add and multiply functions that use Identity<T>
        Function<Integer, Identity<Integer>> add2 = x -> new Identity<>(x + 2);
        Function<Integer, Identity<Integer>> mult2 = x -> new Identity<>(x * 2);


        // Trying to combine. This won't compile, type miss match.
        // One returns a Identity<Integer>  and the other expects an Integer...
        // Function<Integer, Identity<Integer>> add2Mult2 = x -> mult2.apply(add2.apply(x));


        // This will work but is ugly/intrusive/cumbersome.
        // We will have to get the value of Identity everywhere....and
        // Identity is the simplest possible amplified type.
        Function<Integer, Identity<Integer>> add2Mult2 = x -> mult2.apply(add2.apply(x).value());
        System.out.println("add2Mult2(6): " + add2Mult2.apply(6));


        // Using bind to combine add2 and mult2. A bit nicer.
        // (Don't like that I have to call func.apply(...) on a Function.
        // I would like it to be just func(....) instead.
        Function<Integer, Identity<Integer>> bindAdd2Mult2 = x -> add2.apply(x).bind(mult2);
        System.out.println("bindAdd2Mult2(6): " + bindAdd2Mult2.apply(6));


        // Complex example with various identity values
        Identity<String> result = toIdentity("Hello World").bind((String a) ->
                toIdentity(7).bind((Integer b) ->
                        toIdentity(new Date(System.currentTimeMillis())).bind((Date c) ->
                                toIdentity(a + ", " + b + ", " + c)
                        )
                )
        );

        System.out.println(result.value());
    }
}
