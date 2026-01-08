import java.util.*;

/**
 * Demonstrating HashMap and HashSet operations.
 */
public class MapSetOperations {

    public static void main(String[] args) {
        demonstrateHashMap();
        demonstrateHashSet();
        demonstrateFrequencyCount();
    }

    private static void demonstrateHashMap() {
        System.out.println("--- HashMap Operations ---");
        // Key: Name, Value: Age
        Map<String, Integer> map = new HashMap<>();

        // 1. Put - O(1)
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Alice", 26); // Updates value
        System.out.println("Map: " + map);

        // 2. Get - O(1)
        System.out.println("Alice's Age: " + map.get("Alice"));
        System.out.println("Unknown's Age: " + map.getOrDefault("Charlie", -1));

        // 3. Contains - O(1)
        System.out.println("Has Bob? " + map.containsKey("Bob"));

        // 4. Iteration
        System.out.print("Entries: ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
        }
        System.out.println();
    }

    private static void demonstrateHashSet() {
        System.out.println("\n--- HashSet Operations ---");
        Set<String> set = new HashSet<>();

        // 1. Add - O(1)
        set.add("Apple");
        set.add("Banana");
        boolean added = set.add("Apple"); // Duplicate
        System.out.println("Added Duplicate Apple? " + added); // false
        System.out.println("Set: " + set);

        // 2. Operations
        set.remove("Banana");
        System.out.println("Has Banana? " + set.contains("Banana"));
    }

    // Common Interview Pattern
    private static void demonstrateFrequencyCount() {
        System.out.println("\n--- Frequency Count Pattern ---");
        String[] arr = { "apple", "banana", "apple", "orange", "banana", "apple" };
        Map<String, Integer> counts = new HashMap<>();

        for (String s : arr) {
            counts.put(s, counts.getOrDefault(s, 0) + 1);
        }

        System.out.println("Frequencies: " + counts);
    }
}
