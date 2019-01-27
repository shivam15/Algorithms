/*
 * Singleton reflection, cloning, serializable safe
 * with thread double locking
 */
package Algorithms.DesignPatterns;

import java.io.Serializable;

/**
 *
 * @author shivam
 */
public class Singleton implements Serializable, Cloneable {

    private static Singleton instance = null;

    private Singleton() {
        if (Singleton.instance != null) {
            throw new InstantiationError("Creating of this object is not allowed.");
        }
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
