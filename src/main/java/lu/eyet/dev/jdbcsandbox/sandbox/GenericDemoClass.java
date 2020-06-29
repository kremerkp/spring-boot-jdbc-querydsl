package lu.eyet.dev.jdbcsandbox.sandbox;

public class GenericDemoClass<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

}