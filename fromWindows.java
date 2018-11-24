package org.haughki.cli;


import java.util.List;

public class Thing<T> extends SuperThing<T> {
    private T t;
    private List<T> listOfT;

    public Thing(T t) {
        set(t);
    }

    public void set(T t) {

        this.t = t;
    }

    public T get() {
        return t;
    }
}
