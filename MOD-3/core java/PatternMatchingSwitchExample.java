public class PatternMatchingSwitchExample {

    public static void checkObjectType(Object obj) {
        String result = switch (obj) {
            case Integer i -> "Integer with value: " + i;
            case String s -> "String with length: " + s.length();
            case Double d -> "Double with value: " + d;
            case null -> "Null value received";
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };

        System.out.println(result);
    }

    public static void main(String[] args) {
        checkObjectType(42);               // Integer
        checkObjectType("Hello, World!"); // String
        checkObjectType(3.14);             // Double
        checkObjectType(true);             // Unknown type (Boolean)
        checkObjectType(null);             // Null case
    }
}
