package org.discordia.java8.monad;

/**
 * @author robban
 */
public class Type<T> {

    // This is ugly as hell
    public static <T> T as(Class<T> clazz, Object o){
        if(clazz.isInstance(o)){
            return clazz.cast(o);
        }
        return null;
    }
}
