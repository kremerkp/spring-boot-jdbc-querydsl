package lu.eyet.dev.jdbcsandbox.sandbox;

public interface GenericDemoInterface<T1, T2> {
    T2 doSomething(T1 t);

    T1 doReversSomething(T2 t);
}

class DemoClass2 implements GenericDemoInterface<String, Integer> {

    @Override
    public Integer doSomething(String t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String doReversSomething(Integer t) {
        // TODO Auto-generated method stub
        return null;
    }

}