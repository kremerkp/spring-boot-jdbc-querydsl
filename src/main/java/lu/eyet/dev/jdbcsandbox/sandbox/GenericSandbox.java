package lu.eyet.dev.jdbcsandbox.sandbox;

public class GenericSandbox {

    public static void main(String args[]) {
        GenericDemoClass<String> test = new GenericDemoClass<String>();
        test.set("Hallo Generic");

        System.out.println(test);
        System.out.println(test.get());

    }

}