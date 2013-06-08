package org.discordia.java8.monad;

import java.util.Date;

import static org.discordia.java8.monad.Maybe.toMaybe;

/**
 * This is basically an implementation fo this blog post (that uses C#) in Java 8:
 * http://mikehadlow.blogspot.se/2011/01/monads-in-c-5-maybe.html
 *
 * @author robban
 */
public class MaybeMain {

    public static Maybe<Integer> div(Integer numerator, Integer denominator)
    {
        return denominator == 0 ?
                new Nothing<>() :
                new Just<>(numerator/denominator);
    }

    public static Maybe<Integer> doSomeDivision(Integer denominator)
    {
        return toMaybe(12).bind((Integer a) ->
                div(a, denominator).bind((Integer b) ->
                        div(b, 2)));
    }

    public static void main(String[] args) {
        // This will go okay
        Maybe<String> resultOK = toMaybe("Hello World!").bind((String a) ->
                doSomeDivision(2).bind((Integer b) ->
                        toMaybe(new Date(System.currentTimeMillis())).bind((Date c) ->
                                toMaybe(a + " " + b + " " + c)
                        )
                )
        );

        System.out.println(resultOK);



        // This will NOT go okay
        Maybe<String> resultNOK = toMaybe("Hello World!").bind((String a) ->
                doSomeDivision(0).bind((Integer b) ->
                        toMaybe(new Date(System.currentTimeMillis())).bind((Date c) ->
                                toMaybe(a + " " + b + " " + c)
                        )
                )
        );

        System.out.println(resultNOK);
    }

}
