import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // Load class dynamically
        Class<?> personClass = Class.forName("Person");

        // Print all declared methods and their parameters
        System.out.println("Declared methods in " + personClass.getName() + ":");
        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print("Method: " + method.getName() + "(");
            Parameter[] params = method.getParameters();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getType().getSimpleName() + " " + params[i].getName());
                if (i < params.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }

        // Create instance via reflection (using no-arg constructor)
        Object personInstance = personClass.getDeclaredConstructor().newInstance();

        // Invoke sayHello method dynamically
        Method sayHelloMethod = personClass.getDeclaredMethod("sayHello");
        sayHelloMethod.invoke(personInstance);

        // Invoke greet(String) method dynamically with argument
        Method greetMethod = personClass.getDeclaredMethod("greet", String.class);
        greetMethod.invoke(personInstance, "Good morning");
    }
}
