package strings;

import java.util.*;

/**
 * Comprehensive guide to String operations in Java.
 * Covers: String methods, StringBuilder, transformations, and common patterns.
 */
public class StringOperations {

    public static void main(String[] args) {
        demonstrateBasicOperations();
        demonstrateStringBuilder();
        demonstrateCharacterManipulation();
        demonstrateConversions();
    }

    private static void demonstrateBasicOperations() {
        System.out.println("--- Basic String Operations ---");
        String s = "Hello, World!";

        // 1. Length - O(1)
        System.out.println("Length: " + s.length());

        // 2. Access Character - O(1)
        System.out.println("Char at index 1: " + s.charAt(1));

        // 3. Substring - O(n)
        // substring(start, end) -> start inclusive, end exclusive
        System.out.println("Substring (0-5): " + s.substring(0, 5));
        System.out.println("Substring (7+): " + s.substring(7));

        // 4. Search - O(n*m)
        System.out.println("Index of 'World': " + s.indexOf("World"));
        System.out.println("Contains 'Hello': " + s.contains("Hello"));

        // 5. Comparison - O(n)
        String s1 = "Java";
        String s2 = new String("Java");
        System.out.println("Using == (Reference): " + (s1 == s2)); // false
        System.out.println("Using equals (Content): " + s1.equals(s2)); // true
    }

    private static void demonstrateStringBuilder() {
        System.out.println("\n--- StringBuilder (Mutable) ---");
        // Efficient for modifications loop
        StringBuilder sb = new StringBuilder();

        // 1. Append - O(1) amortized
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        System.out.println("Built String: " + sb.toString());

        // 2. Insert - O(n)
        sb.insert(5, ",");
        System.out.println("After Insert: " + sb.toString());

        // 3. Delete - O(n)
        sb.deleteCharAt(5); // Remove comma
        System.out.println("After Delete: " + sb.toString());

        // 4. Reverse - O(n)
        sb.reverse();
        System.out.println("Reversed: " + sb.toString());
    }

    private static void demonstrateCharacterManipulation() {
        System.out.println("\n--- Character Manipulation ---");
        String text = "Java 101";

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                System.out.print("L"); // Letter
            } else if (Character.isDigit(c)) {
                System.out.print("D"); // Digit
            } else if (Character.isWhitespace(c)) {
                System.out.print("_"); // Space
            }
        }
        System.out.println();
    }

    private static void demonstrateConversions() {
        System.out.println("\n--- Conversions ---");

        // String to Char Array
        char[] chars = "hello".toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        System.out.println("Sorted String: " + sorted);

        // Primitive to String
        String num = String.valueOf(123);
        System.out.println("Number as String: " + num);

        // String to Primitive
        int n = Integer.parseInt("123");
        System.out.println("String as Integer: " + n);
    }
}
